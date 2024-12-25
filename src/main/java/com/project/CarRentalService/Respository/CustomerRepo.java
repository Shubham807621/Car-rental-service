package com.project.CarRentalService.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.CarRentalService.Model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
