package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.SalesContract;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface SalesContractDao {


    List<SalesContract> findAllSalesContracts();
    SalesContract findSalesContractById(int id);
    SalesContract addSalesContract(SalesContract salesContract);
    void updateSalesContract(SalesContract salesContract);
    void deleteSalesContract(int id);
}
