package com.pluralsight.dealership.CarDealershipAPI;


import com.pluralsight.dealership.dao.VehicleDao;
import com.pluralsight.dealership.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping (path = "/vehicles")
public class VehicleController {

    private VehicleDao vehicleDAO;
    @Autowired
    public VehicleController(VehicleDao vehicleFromDataBase) {
        this.vehicleDAO = vehicleFromDataBase;
    }

    @GetMapping("/allCars")
    public List<Vehicle> findAllVehicles() {
        return vehicleDAO.findAllVehicles();
    }
    @GetMapping("/vehiclePrice")
    public List<Vehicle> findByPrice(@RequestParam("minPrice") double minPrice, @RequestParam("maxPrice") double maxPrice){
        return vehicleDAO.findVehicleByPrice(minPrice, maxPrice);
    }

    @GetMapping("/vehicleMakeModel")
    public List<Vehicle> findMakeModel(@RequestParam("make") String make, @RequestParam("model") String model){
        return vehicleDAO.findVehicleByMakeModel(make, model);
    }

    @GetMapping("/vehicleYear")
    public List<Vehicle> findByYear(@RequestParam("minYear") int minYear, @RequestParam("maxYear") int maxYear) {
        return vehicleDAO.findVehicleByYear(minYear + maxYear);
    }
    //needs fixing.
    @GetMapping("/vehicleColor")
    public List<Vehicle> findByColor (@RequestParam("color") String color){
        return vehicleDAO.findVehicleByColor(color);
    }

    @GetMapping("/vehicleMileage")
    public List<Vehicle> findVehiclesByMiles(@RequestParam("minMiles") int minMiles, @RequestParam("maxMiles") int maxMiles) {
        return vehicleDAO.findVehicleByMileage(minMiles + maxMiles);
    }
    @GetMapping("/vehicleVin")
    public List<Vehicle> findByVin(@RequestParam("vin") int vin) {
        return vehicleDAO.findVehicleByVin(vin);
    }


    // get method that accepts query string parameters for minPrice maxPrice make model minYear
    // maxYear color minMiles maxMiles type

    // post method to add new vehicle

    //put method to update vehicle info

    //delete method to delete vehicle
}
