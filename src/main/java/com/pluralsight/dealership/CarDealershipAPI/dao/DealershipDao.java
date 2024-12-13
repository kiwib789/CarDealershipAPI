package com.pluralsight.dealership.CarDealershipAPI.dao;



import com.pluralsight.dealership.CarDealershipAPI.model.Dealership;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DealershipDao {
    List<Dealership> findAllDealerships();
    List<Dealership> findDealershipById();
}

