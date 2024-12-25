package com.project.CarRentalService.Controller;

import java.io.IOException;
import java.util.List;

import com.project.CarRentalService.Model.CarRented;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.project.CarRentalService.Model.Car;
import com.project.CarRentalService.Model.Customer;
import com.project.CarRentalService.Service.CarService;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin
@RequestMapping("/api")   // base url
public class Controller {
	
	@Autowired
	private CarService service;


	@GetMapping("/cars")
	public ResponseEntity<List<Car>> getAllCar() {
		
		return new ResponseEntity<>(service.getAllCar(), HttpStatus.OK );

	}

	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		return new ResponseEntity<>(service.getAllCustomer(), HttpStatus.OK );
	}

	@GetMapping("/cart")
	public ResponseEntity<List<CarRented>> getAllRentedCar(){
		return new ResponseEntity<>(service.getAllRentedCar(), HttpStatus.OK);
	}


	@PostMapping("/addcar")
	public ResponseEntity<?> addCar(@RequestPart Car car, @RequestPart MultipartFile imageFile) {

		try {
			Car car1 = service.addCar(car, imageFile);
			return new ResponseEntity<>(car1, HttpStatus.CREATED);
		}
		catch (IOException e){
			return new ResponseEntity<>(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/cars/{carId}/image")
	public ResponseEntity<byte[]> getImageByCarId(@PathVariable int carId){

		Car car = service.getCarById(carId);
		byte [] imageFile = car.getImageData();

		return ResponseEntity.ok().contentType(MediaType.valueOf(car.getImageType())).body(imageFile);


	}

	@PostMapping("/customer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {

		Customer customer1 = service.addCustomer(customer);
		return new ResponseEntity<>(customer1 , HttpStatus.CREATED);
	}


	@PostMapping("/cart")
	public ResponseEntity<?> addBooking(@RequestBody CarRented rented){

		CarRented rented1 = service.addBooking(rented);
		return  new ResponseEntity<>(rented1, HttpStatus.CREATED);
	}


	@DeleteMapping("/returncar/{carNo}")
	public ResponseEntity<String> deleteRentedCar(@PathVariable int carNo){

			CarRented carRented = service.getAllRentedCarByCarNo(carNo);

			if(carRented !=null){
				service.deleteCarRented(carNo);
				return new ResponseEntity<>("Car Returned Successfully", HttpStatus.OK);
			}
			else
				return new ResponseEntity<>("Car Not Found", HttpStatus.NOT_FOUND);

	}
	
}
	