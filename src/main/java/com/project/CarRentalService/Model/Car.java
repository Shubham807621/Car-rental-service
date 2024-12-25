package com.project.CarRentalService.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;


@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long carId;
	private String brandName;
	private String modelName;
	private int carNo;
	private int basePrice;
	private int seatNo;
	private String fuelType;
	private boolean carAvailable;
	private String imageName;
	private String imageType;
	@Lob
	private byte [] imageData;
	
	
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Car(int basePrice, String brandName, boolean carAvailable, Long carId, int carNo, String fuelType, byte[] imageData, String imageName, String imageType, String modelName, int seatNo) {
		this.basePrice = basePrice;
		this.brandName = brandName;
		this.carAvailable = carAvailable;
		this.carId = carId;
		this.carNo = carNo;
		this.fuelType = fuelType;
		this.imageData = imageData;
		this.imageName = imageName;
		this.imageType = imageType;
		this.modelName = modelName;
		this.seatNo = seatNo;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public int getCarNo() {
		return carNo;
	}

	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public boolean isCarAvailable() {
		return carAvailable;
	}

	public void setCarAvailable(boolean carAvailable) {
		this.carAvailable = carAvailable;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
}
