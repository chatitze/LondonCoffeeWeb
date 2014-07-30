package com.web.londoncoffee.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyInt;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.web.londoncoffee.dao.ICoffeeShopDao;
import com.web.londoncoffee.model.CoffeeShop;

/**
 * @author Chatitze Moumin
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class CoffeeShopServiceTest {

	@Mock
	private ICoffeeShopDao coffeeShopDaoMock;
	
	@InjectMocks
    private ICoffeeShopService coffeeShopService = new CoffeeShopServiceImpl();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getCoffeeShopTest() {
		
		CoffeeShop shop = new CoffeeShop();
		shop.setName("testCoffeeShopName");
		shop.setWebAddress("www.testwebaddress.com");
		shop.setRating(4.0);
		
		// specify mock behave when method called
		Mockito.when(coffeeShopDaoMock.getCoffeeShop(anyInt())).thenReturn(shop);
         
		assertNotNull("In 'getCoffeeShopTest()' the coffeeShopService is NULL",coffeeShopService);
        CoffeeShop testShop = coffeeShopService.getCoffeeShop(5);
        
        //Verify the invocation of the stub
        Mockito.verify(coffeeShopDaoMock).getCoffeeShop(anyInt());

        assertEquals("1. Get Coffee Shop with id test failed!", "testCoffeeShopName", testShop.getName());
        assertEquals("2. Get Coffee Shop with id test failed!",4.0, testShop.getRating(), 0);
        assertEquals("3. Get Coffee Shop with id test failed!", "www.testwebaddress.com", testShop.getWebAddress());

	}
	
	@Test
	public void getCoffeeShopListTest() {
		
		List<CoffeeShop> shopList = new ArrayList<CoffeeShop>();
		CoffeeShop shop1 = new CoffeeShop();
		shop1.setName("testCoffeeShopName1");
		shop1.setWebAddress("www.testwebaddress1.com");
		shop1.setRating(4.0);
		CoffeeShop shop2 = new CoffeeShop();
		shop2.setName("testCoffeeShopName2");
		shop2.setWebAddress("www.testwebaddress2.com");
		shop2.setRating(3.0);
		shopList.add(shop1);
		shopList.add(shop2);
				
		// specify mock behave when method called
		Mockito.when(coffeeShopDaoMock.getCoffeeShopList()).thenReturn(shopList);
         
		assertNotNull(coffeeShopService);
		List<CoffeeShop> testShopList = coffeeShopService.getCoffeeShopList();
        
        //Verify the invocation of the stub
        Mockito.verify(coffeeShopDaoMock).getCoffeeShopList();

        assertEquals("1. Get Coffee Shop List test failed!", 2, testShopList.size());
        // First coffee shop
        assertEquals("2. Get Coffee Shop List test failed!", "testCoffeeShopName1", testShopList.get(0).getName());
        assertEquals("3. Get Coffee Shop List test failed!",4.0, testShopList.get(0).getRating(), 0.0);
        assertEquals("4. Get Coffee Shop List test failed!", "www.testwebaddress1.com", testShopList.get(0).getWebAddress());
        // Second coffee shop
        assertEquals("5. Get Coffee Shop List test failed!", "testCoffeeShopName2", testShopList.get(1).getName());
        assertEquals("6. Get Coffee Shop List test failed!", 3.0, testShopList.get(1).getRating(), 0);
        assertEquals("7. Get Coffee Shop List test failed!", "www.testwebaddress2.com", testShopList.get(1).getWebAddress());
	}

	@Test
	public void saveCoffeeShopTest() {
		
		// specify mock behave when method called
		Mockito.when(coffeeShopDaoMock.save(Mockito.any(CoffeeShop.class))).thenReturn(1);
		  
		CoffeeShop newShop = new CoffeeShop();
	
		assertNotNull(coffeeShopService);
		int shopId = coffeeShopService.save(newShop);
		
		//Verify the invocation of the stub
        Mockito.verify(coffeeShopDaoMock).save(Mockito.any(CoffeeShop.class));
        
        assertEquals("Add New Coffee Shop test failed!", 1, shopId);      
	}
	
	@Test
	public void updateCoffeeShopTest() {
		
		CoffeeShop updateShop = new CoffeeShop();
		updateShop.setId(1);
		
		assertNotNull(coffeeShopService);
		coffeeShopService.update(updateShop);
		
		//Verify the invocation of the stub
        Mockito.verify(coffeeShopDaoMock).update(Mockito.any(CoffeeShop.class));
	}
	
	@Test
	public void deleteCoffeeShopTest() {
		
		assertNotNull(coffeeShopService);
		coffeeShopService.delete(1);
		
		//Verify the invocation of the stub
        Mockito.verify(coffeeShopDaoMock).delete(anyInt());
	}
}
