package com.menuservice.java.cotroller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.menuservice.java.model.HotelMenu;
import com.menuservice.java.service.MenuService;




@RestController
public class MenuController {
	
	@Value("${server.port}")
	int port;
	
	@Autowired
	MenuService menuservice;

	
	protected final static Logger logger = LoggerFactory.getLogger(MenuController.class);


	@GetMapping("/menus/{id}")
	public ResponseEntity<Long> getAmount(@PathVariable Integer id){

		Long response=menuservice.getAmount(id);
		logger.info("Getting amount for menu Id "+id);
		return new ResponseEntity<Long>(response,HttpStatus.CREATED);


	}
	

	@GetMapping("/menus")
	public ResponseEntity<List<HotelMenu>> getMenu(){
		List<HotelMenu> hotelMenus=menuservice.findall();
		logger.info("Showing all Menu details");
		return new ResponseEntity<List<HotelMenu>>(hotelMenus,HttpStatus.OK);
		
	}

	
	@GetMapping("/menus/port")
	public ResponseEntity<Integer> getPort(){
		return new ResponseEntity<Integer>(port,HttpStatus.OK);
	}
		
	
	


	@GetMapping("/menusByName")
	public ResponseEntity<Long> getMenuPrice(@Param("name") String name){
		Long response=menuservice.findByName(name);
		logger.info("Showing Amount for particular Item");
		return new ResponseEntity<Long>(response,HttpStatus.OK);
		
	}

}
