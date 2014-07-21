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
		
		// specify mock behave when method called
		Mockito.when(coffeeShopDaoMock.getCoffeeShop(anyInt())).thenReturn(new CoffeeShop("testCoffeeShopName", (float) 4.0, "www.testwebaddress.com"));
         
		assertNotNull(coffeeShopService);
        CoffeeShop testShop = coffeeShopService.getCoffeeShop(5);
        
        //Verify the invocation of the stub
        Mockito.verify(coffeeShopDaoMock).getCoffeeShop(anyInt());

        assertEquals("Get Coffee Shop with id test failed!", "testCoffeeShopName", testShop.getName());
        assertEquals(4.0, testShop.getRating(), 0);
        assertEquals("Get Coffee Shop with id test failed!", "www.testwebaddress.com", testShop.getWebAddress());

	}
	
	@Test
	public void getCoffeeShopListTest() {
		
		List<CoffeeShop> shopList = new ArrayList<CoffeeShop>();
		CoffeeShop shop1 = new CoffeeShop("testCoffeeShopName1", (float) 4.0, "www.testwebaddress1.com");
		CoffeeShop shop2 = new CoffeeShop("testCoffeeShopName2", (float) 3.0, "www.testwebaddress2.com");
		shopList.add(shop1);
		shopList.add(shop2);
		
		// specify mock behave when method called
		Mockito.when(coffeeShopDaoMock.getCoffeeShopList()).thenReturn(shopList);
         
		assertNotNull(coffeeShopService);
		List<CoffeeShop> testShopList = coffeeShopService.getCoffeeShopList();
        
        //Verify the invocation of the stub
        Mockito.verify(coffeeShopDaoMock).getCoffeeShopList();

        assertEquals("Get Coffee Shop List test failed!", 2, testShopList.size());
        // First coffee shop
        assertEquals("Get Coffee Shop List test failed!", "testCoffeeShopName1", testShopList.get(0).getName());
        assertEquals(4.0, testShopList.get(0).getRating(), 0.0);
        assertEquals("Get Coffee Shop List test failed!", "www.testwebaddress1.com", testShopList.get(0).getWebAddress());
        // Second coffee shop
        assertEquals("Get Coffee Shop List test failed!", "testCoffeeShopName2", testShopList.get(1).getName());
        assertEquals(3.0, testShopList.get(1).getRating(), 0);
        assertEquals("Get Coffee Shop List test failed!", "www.testwebaddress2.com", testShopList.get(1).getWebAddress());
	}

	@Test
	public void saveCoffeeShopTest() {
		
		// specify mock behave when method called
		Mockito.when(coffeeShopDaoMock.save(Mockito.any(CoffeeShop.class))).thenReturn(1);
		  
		CoffeeShop newShop = new CoffeeShop("newShopName", (float) 4.0, "www.newshopaddress.com");
	
		assertNotNull(coffeeShopService);
		int shopId = coffeeShopService.save(newShop);
		
		//Verify the invocation of the stub
        Mockito.verify(coffeeShopDaoMock).save(Mockito.any(CoffeeShop.class));
        
        assertEquals("Add New Coffee Shop test failed!", 1, shopId);      
	}
	
	@Test
	public void updateCoffeeShopTest() {
		
		CoffeeShop updateShop = new CoffeeShop("updateShopName", (float) 4.0, "www.updateshopaddress.com");
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
