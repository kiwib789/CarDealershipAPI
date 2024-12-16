package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.Dealership;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DealershipDao {
    List<Dealership> findAllDealerships();
    List<Dealership> findDealershipById();
}
