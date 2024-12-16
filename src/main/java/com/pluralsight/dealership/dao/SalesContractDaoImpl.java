package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.SalesContract;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SalesContractDaoImpl implements SalesContractDao {

    @Override
    public List<SalesContract> findAllSalesContracts() {
        return List.of();
    }

    @Override
    public SalesContract findSalesContractById(int id) {
        return null;
    }

    @Override
    public SalesContract addSalesContract(SalesContract salesContract) {
        return null;
    }

    @Override
    public void updateSalesContract(SalesContract salesContract) {

    }

    @Override
    public void deleteSalesContract(int id) {

    }
}
