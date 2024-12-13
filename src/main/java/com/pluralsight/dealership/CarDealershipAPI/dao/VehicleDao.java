package com.pluralsight.dealership.CarDealershipAPI.dao;

import com.pluralsight.dealership.CarDealershipAPI.model.Vehicle;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface VehicleDao {
    List<Vehicle> findAllVehicles();
    List<Vehicle> findVehicleByMakeModel(String make, String model);
    List<Vehicle> findVehicleByPrice(double minPrice, double maxPrice);
    List<Vehicle> findVehicleByYear(int year);
    List<Vehicle> findVehicleByColor(String color);
    List<Vehicle> findVehicleByMileage(int mileage);
    List<Vehicle> findVehicleByType(String type);
    void addVehicle(Vehicle vehicle);
    void removeVehicle(int vin);
}
