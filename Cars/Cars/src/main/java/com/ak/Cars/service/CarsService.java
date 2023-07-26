package com.ak.Cars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.Cars.CarsDAO;
import com.ak.Cars.model.Cars;
@Service
public class CarsService {

	
	@Autowired
	CarsDAO carsRepository;
	
	
	public List<Cars> getAllcars() {
		// TODO Auto-generated method stub
		return carsRepository.findAll();
	}

	public Cars getcarById(int id) {
		// TODO Auto-generated method stub
		return carsRepository.findById(id).get();
	}

	public Cars createCar(Cars car) {
		// TODO Auto-generated method stub
		return carsRepository.save(car);
	}

	public void deleteCar(int id) {
		// TODO Auto-generated method stub
		 carsRepository.deleteById(id);
	}
	
	 public Cars updateCar(int carId, Cars updatedCar) {
	        Cars existingCar = carsRepository.findById(carId).orElse(null);
	        if (existingCar != null) {
	            existingCar.setModel(updatedCar.getModel());
	            existingCar.setPrice(updatedCar.getPrice());
	            existingCar.setColor(updatedCar.getColor());
	            return carsRepository.save(existingCar);
	        }
	        return null; // Car with the specified ID not found
	    }

}
