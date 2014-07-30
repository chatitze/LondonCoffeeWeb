/**
 * 
 */
package com.web.londoncoffee.controller;

import static org.mockito.Matchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.web.londoncoffee.model.CoffeeShop;
import com.web.londoncoffee.service.ICoffeeShopService;

/**
 * @author Chatitze Moumin
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CoffeeShopControllerTest {

	@Mock
    private ICoffeeShopService coffeeShopService;
	
	@InjectMocks
    private CoffeeShopController coffeeShopController=new CoffeeShopController();
 
    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
 
        mockMvc = MockMvcBuilders.standaloneSetup(coffeeShopController).build();
 
        //when(validator.supports(any(Class.class))).thenReturn(true);
    }
    
	@Test
	public void getCoffeeShop() {
		
		// specify mock behave when method called
		//Mockito.when(coffeeShopService.getCoffeeShop(anyInt())).thenReturn(new CoffeeShop("testCoffeeShopName", (float) 4.0, "www.testwebaddress.com"));
		
		//CoffeeShop testShop = new CoffeeShop("testCoffeeShopName", (float) 4.0, "www.testwebaddress.com");
		CoffeeShop testShop = new CoffeeShop();
		JSONObject testObj = new JSONObject();
		testObj.put("id", 1);
		testObj.put("name", "testCoffeeShop");
		testObj.put("webAddress", "www.testCoffeeShop.com");
		testObj.put("rating", "4.5");
		
		Mockito.when(coffeeShopService.getCoffeeShop(anyInt())).thenReturn(testShop);
		 try {
			mockMvc.perform((RequestBuilder) ((ResultActions) get("http://localhost:8080/londoncoffee/venue/4"))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")))
					.andExpect(jsonPath("rootId").value(4))
					.andExpect(jsonPath("id").value(4))
					.andExpect(jsonPath("name").value("Flat White"))
					.andExpect(jsonPath("rating").value("4.2"))		
					.andExpect(jsonPath("webAddress").value("http://www.flatwhitecafe.com/\r")));
			
			mockMvc.perform((RequestBuilder) ((ResultActions) get("/londoncoffee/venue/4"))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")))
					.andExpect(jsonPath("rootId").value(4))
					.andExpect(jsonPath("id").value(4))
					.andExpect(jsonPath("name").value("Flat White"))
					.andExpect(jsonPath("rating").value("4.0"))		
					.andExpect(jsonPath("webAddress").value("www.testwebaddress.com")));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 
	}

}
