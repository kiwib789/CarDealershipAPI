package com.pluralsight.dealership.CarDealershipAPI;

import com.pluralsight.dealership.SalesContract;
import com.pluralsight.dealership.dao.SalesContractDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class SalesContractsController {
    @Autowired
    private SalesContractDaoImpl salesContractService;

    @GetMapping("/{id}")
    public SalesContract getSalesContract(@PathVariable int id) {
        return salesContractService.findSalesContractById(id);
    }

    @PostMapping
    public SalesContract addSalesContract(@RequestBody SalesContract salesContract) {
        return salesContractService.addSalesContract(salesContract);
    }
    // get method to get sales contract by Id

    // post method to add a new sales contract to database
}
