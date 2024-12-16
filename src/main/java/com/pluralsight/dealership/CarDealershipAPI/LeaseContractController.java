package com.pluralsight.dealership.CarDealershipAPI;

import com.pluralsight.dealership.dao.LeaseDao;
import com.pluralsight.dealership.model.LeaseContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "/leases")
public class LeaseContractController {
    private final LeaseDao leaseContractDao;

    @Autowired
    public LeaseContractController(LeaseDao leaseContractDao) {
        this.leaseContractDao = leaseContractDao;
    }

    // GET method to get a lease contract by VIN
    @GetMapping("/{vin}")
    public LeaseContract getLeaseContractByVin(@PathVariable int vin) {
        LeaseContract leaseContract = (LeaseContract) leaseContractDao.findLeaseContractByVin(vin);
        if (leaseContract == null) {
            throw new RuntimeException("Lease contract not found for VIN: " + vin);
        }
        return leaseContract;
    }

    // POST method to add a new lease contract to the database
    @PostMapping
    public LeaseContract addLeaseContract(@RequestBody LeaseContract leaseContract) {
        return leaseContractDao.addLeaseContract(leaseContract);
    }
    }



