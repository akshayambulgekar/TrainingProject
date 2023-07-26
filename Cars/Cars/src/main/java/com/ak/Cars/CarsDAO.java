package com.ak.Cars;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.Cars.model.Cars;



public interface CarsDAO extends JpaRepository <Cars,Integer>{

}
