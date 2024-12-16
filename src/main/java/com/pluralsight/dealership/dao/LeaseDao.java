package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.LeaseContract;
import org.springframework.stereotype.Component;

@Component
public interface LeaseDao {
    void saveLeaseContract(LeaseContract leaseContract);
}
