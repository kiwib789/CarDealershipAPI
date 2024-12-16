package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.DatabaseConfig;
import com.pluralsight.dealership.model.Dealership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class DealershipDaoImpl implements DealershipDao {
    private DataSource dataSource;
    public DealershipDaoImpl(DataSource dataSource) {this.dataSource = dataSource;}


    @Override
    public List<Dealership> findAllDealerships() {
        List<Dealership> dealerships = new ArrayList<>();
        String query = "SELECT * FROM Dealerships";
        int id;
        String name;
        String address;
        String phone;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                id = resultSet.getInt("Id");
                name = resultSet.getString("Name");
                address = resultSet.getString("Address");
                phone = resultSet.getString("Phone number");
                Dealership dealership = new Dealership(id, name, address,phone);


                        dealerships.add(dealership);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dealerships;
    }

    @Override
    public List<Dealership> findDealershipById() {
        return List.of();
    }
}

