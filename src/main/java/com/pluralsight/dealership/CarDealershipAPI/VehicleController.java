package com.pluralsight.dealership.CarDealershipAPI;


import com.pluralsight.dealership.dao.VehicleDao;
import com.pluralsight.dealership.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping (path = "/vehicles")
public class VehicleController {

    private final VehicleDao vehicleDAO;

    // constructor to inject the VehicleDao dependency using @Autowired.
    @Autowired
    public VehicleController(VehicleDao vehicleFromDataBase) {

        this.vehicleDAO = vehicleFromDataBase;
    }

    // get request to retrieve all vehicles.
    @GetMapping("/allCars")
    public List<Vehicle> findAllVehicles() {

        return vehicleDAO.findAllVehicles();
    }

    // get request to find vehicles by price.
    @GetMapping("/vehiclePrice")
    public List<Vehicle> findVehicleByPrice(@RequestParam("minPrice") double minPrice, @RequestParam("maxPrice") double maxPrice){
        return vehicleDAO.findVehicleByPrice(minPrice, maxPrice);
    }

    // get request to find vehicles by make and model.
    @GetMapping("/vehicleMakeModel")
    public List<Vehicle> findVehicleByMakeModel(@RequestParam("make") String make, @RequestParam("model") String model){
        return vehicleDAO.findVehicleByMakeModel(make, model);
    }

    // get request to find vehicles by year
    @GetMapping("/vehicleYear")
    public List<Vehicle> findVehicleByYear(@RequestParam("minYear") int minYear, @RequestParam("maxYear") int maxYear) {
        return vehicleDAO.findVehicleByYear(minYear + maxYear);
    }

    // get request to find vehicles by color.
    @GetMapping("/vehicleColor")
    public List<Vehicle> findVehicleByColor(@RequestParam("color") String color){
        return vehicleDAO.findVehicleByColor(color);
    }
    // get request to find vehicles by mileage
    @GetMapping("/vehicleMileage")
    public List<Vehicle> findVehiclesByMiles(@RequestParam("minMiles") int minMiles, @RequestParam("maxMiles") int maxMiles) {
        return vehicleDAO.findVehicleByMileage(minMiles, maxMiles);
    }

    // get request to find a vehicle by its VIN.
    @GetMapping("/vehicleVin")
    public List<Vehicle> findVehicleByVin(@RequestParam("vin") int vin) {
        return vehicleDAO.findVehicleByVin(vin);
    }


    // get method that accepts query string parameters for minPrice maxPrice make model minYear
    // maxYear color minMiles maxMiles type

    // post method to add new vehicle

    //put method to update vehicle info

    //delete method to delete vehicle
}
