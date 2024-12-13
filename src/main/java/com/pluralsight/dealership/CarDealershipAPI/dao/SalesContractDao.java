package com.pluralsight.dealership.CarDealershipAPI.dao;


import com.pluralsight.dealership.CarDealershipAPI.model.SalesContract;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface SalesContractDao {
    List<SalesContract> findAllSalesContracts();
    SalesContract findSalesContractById(int id);
    void addSalesContract(SalesContract salesContract);
    void updateSalesContract(SalesContract salesContract);
    void deleteSalesContract(int id);
}
