package com.project.CarRentalService.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.CarRentalService.Model.Car;



@Repository
public interface CarRepo extends JpaRepository<Car, Integer>{

}
