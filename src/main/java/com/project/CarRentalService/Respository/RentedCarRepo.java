package com.project.CarRentalService.Respository;

import com.project.CarRentalService.Model.CarRented;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RentedCarRepo extends JpaRepository<CarRented, Long> {

    // Find a car by car number
    @Query("SELECT c FROM CarRented c WHERE c.carNo = :keyword")
    CarRented getCarRentedByCarNo(@Param("keyword") int keyword);

    // Delete a car by car number
    @Modifying
    @Transactional
    @Query("DELETE FROM CarRented c WHERE c.carNo = :keyword")
    void deleteByCarNo(@Param("keyword") int keyword);
}
