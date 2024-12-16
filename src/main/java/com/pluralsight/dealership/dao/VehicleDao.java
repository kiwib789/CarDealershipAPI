package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.Vehicle;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface VehicleDao {
    List<Vehicle> findAllVehicles();
    List<Vehicle> findVehicleByMakeModel(String make, String model);
    List<Vehicle> findVehicleByPrice(double minPrice, double maxPrice);
    List<Vehicle> findVehicleByYear(int year);
    List<Vehicle> findVehicleByColor(String color);
    List<Vehicle> findVehicleByMileage(int minMiles, int maxMiles);
    List<Vehicle> findVehicleByType(String type);
    Vehicle addVehicle(Vehicle vehicle);
    void removeVehicle(int vin);
    List<Vehicle> findVehicleByVin(int vin);
}
