package com.ak.Cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ak.Cars.model.Cars;
import com.ak.Cars.service.CarsService;

@RestController
@RequestMapping("/api")
public class CarsController {

	@Autowired
	CarsService carsService;
	
	@GetMapping("/greetings")
	public String sayHello() {
		return ("Hello World");
		
		
	}
	@GetMapping("/cars")
	public List<Cars> getAllcars(){
		return carsService.getAllcars();
		
	}
	@GetMapping("/cars/{id}")
	public Cars getBookById(@PathVariable int id) {
		
		return carsService.getcarById(id);
		
	}
	@PostMapping("/cars")
	public Cars createBook(@RequestBody Cars cars) {
		return carsService.createCar(cars);
		
	}
	
	@DeleteMapping("/cars/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        try {
            carsService.deleteCar(id);
            return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete the book", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	
	@PutMapping("/cars/{id}")
    public ResponseEntity<String> updateCar(@PathVariable int id, @RequestBody Cars updatedCar) {
        try {
            Cars updatedCarResult = carsService.updateCar(id, updatedCar);
            if (updatedCarResult != null) {
                return new ResponseEntity<>("Car updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Car with the given ID not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update the car", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
