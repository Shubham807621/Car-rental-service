package com.project.CarRentalService.Service;

import java.io.IOException;
import java.util.List;

import com.project.CarRentalService.Model.CarRented;
import com.project.CarRentalService.Respository.RentedCarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.CarRentalService.Model.Car;
import com.project.CarRentalService.Model.Customer;
import com.project.CarRentalService.Respository.CarRepo;
import com.project.CarRentalService.Respository.CustomerRepo;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CarService {
	
	@Autowired
	private CarRepo carRepo;

	@Autowired
	private CustomerRepo cusRepo;

	@Autowired
	private RentedCarRepo rentedRepo;

	public List<Car> getAllCar() {
		
		return carRepo.findAll();
	}


	public Customer addCustomer(Customer customer) {

		return cusRepo.save(customer);
	}

	public Car addCar(Car car, MultipartFile imageFile) throws IOException {

		car.setImageName(imageFile.getOriginalFilename());
		car.setImageType(imageFile.getContentType());
		car.setImageData(imageFile.getBytes());
		return carRepo.save(car);
	}

	public Car getCarById(int id) {
		return  carRepo.findById(id).orElse(null);
	}

	public List<Customer> getAllCustomer() {
		return  cusRepo.findAll();
	}

	public CarRented addBooking(CarRented rented) {
			return  rentedRepo.save(rented);
	}

	public List<CarRented> getAllRentedCar() {
		return rentedRepo.findAll();
	}

	public CarRented getAllRentedCarByCarNo(int carNo) {

		return  rentedRepo.getCarRentedByCarNo(carNo);
	}


	public void deleteCarRented(int carNo) {

		rentedRepo.deleteByCarNo(carNo);
	}
}
