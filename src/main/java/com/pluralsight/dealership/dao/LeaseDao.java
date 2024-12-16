package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.LeaseContract;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LeaseDao {
    void saveLeaseContract(LeaseContract leaseContract);
    List<LeaseContract> findLeaseContractByVin(int vin);

    LeaseContract addLeaseContract(LeaseContract leaseContract);
}
