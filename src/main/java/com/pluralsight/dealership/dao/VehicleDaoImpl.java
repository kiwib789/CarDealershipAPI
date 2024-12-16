package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.DatabaseConfig;
import com.pluralsight.dealership.model.Vehicle;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleDaoImpl implements VehicleDao {
    private DataSource dataSource;
    public VehicleDaoImpl(DataSource dataSource) {this.dataSource = dataSource;}

    @Override
    public List<Vehicle> findAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM Vehicles";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                vehicles.add(createVehicleFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    private Vehicle createVehicleFromResultSet(ResultSet resultSet) throws SQLException {
        int vin = resultSet.getInt("vin");
        int year = resultSet.getInt("year");
        String make = resultSet.getString("make");
        String model = resultSet.getString("model");
        String vehicleType = resultSet.getString("type");
        String color = resultSet.getString("color");
        int odometer = resultSet.getInt("odometer");
        double price = resultSet.getDouble("price");

        return new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
    }

    @Override
    public List<Vehicle> findVehicleByMakeModel(String make, String model) {
        List<Vehicle> vehicleByMake = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE make = ? AND model = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, make);
            statement.setString(2, model);
            ResultSet results = statement.executeQuery();

            while (results.next()) {
                int vin = results.getInt("vin");
                int year = results.getInt("year");
                String vehicleMake = results.getString("make");
                String vehicleModel = results.getString("model");
                String vehicleType = results.getString("type");
                String color = results.getString("color");
                int odometer = results.getInt("odometer");
                double price = results.getDouble("price");

                Vehicle v = new Vehicle(vin, year, vehicleMake, vehicleModel, vehicleType, color, odometer, price);
                vehicleByMake.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicleByMake;
    }

    @Override
    public List<Vehicle> findVehicleByPrice(double minPrice, double maxPrice) {
        List<Vehicle> vehiclesByPrice = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setDouble(1, minPrice);
            statement.setDouble(2, maxPrice);
            ResultSet results = statement.executeQuery();

            while (results.next()) {
                int vin = results.getInt("vin");
                int year = results.getInt("year");
                String make = results.getString("make");
                String model = results.getString("model");
                String vehicleType = results.getString("type");
                String color = results.getString("color");
                int odometer = results.getInt("odometer");
                double price = results.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehiclesByPrice.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehiclesByPrice;
    }

    @Override
    public List<Vehicle> findVehicleByYear(int year) {
        List<Vehicle> vehiclesByYear = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE year = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, year);
            ResultSet results = statement.executeQuery();

            while (results.next()) {
                int vin = results.getInt("vin");
                int vehicleYear = results.getInt("year");
                String make = results.getString("make");
                String model = results.getString("model");
                String vehicleType = results.getString("type");
                String color = results.getString("color");
                int odometer = results.getInt("odometer");
                double price = results.getDouble("price");

                Vehicle v = new Vehicle(vin, vehicleYear, make, model, vehicleType, color, odometer, price);
                vehiclesByYear.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehiclesByYear;
    }


    @Override
    public List<Vehicle> findVehicleByColor(String color) {
        List<Vehicle> vehiclesByColor = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE color = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, color);
            ResultSet results = statement.executeQuery();

            while (results.next()) {
                int vin = results.getInt("vin");
                int year = results.getInt("year");
                String make = results.getString("make");
                String model = results.getString("model");
                String vehicleType = results.getString("type");
                String vehicleColor = results.getString("color");
                int odometer = results.getInt("odometer");
                double price = results.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, vehicleColor, odometer, price);
                vehiclesByColor.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehiclesByColor;
    }


    @Override
    public List<Vehicle> findVehicleByMileage(int minMiles, int maxMiles) {
        List<Vehicle> vehiclesByMileage = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE odometer = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, minMiles);
            statement.setInt(2, maxMiles);
            ResultSet results = statement.executeQuery();

            while (results.next()) {
                int vin = results.getInt("vin");
                int year = results.getInt("year");
                String make = results.getString("make");
                String model = results.getString("model");
                String vehicleType = results.getString("type");
                String color = results.getString("color");
                int vehicleOdometer = results.getInt("odometer");
                double price = results.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, vehicleOdometer, price);
                vehiclesByMileage.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehiclesByMileage;
    }


    @Override
    public List<Vehicle> findVehicleByType(String type) {
        List<Vehicle> vehiclesByType = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE type = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, type);
            ResultSet results = statement.executeQuery();

            while (results.next()) {
                int vin = results.getInt("vin");
                int year = results.getInt("year");
                String make = results.getString("make");
                String model = results.getString("model");
                String vehicleType = results.getString("type");
                String color = results.getString("color");
                int odometer = results.getInt("odometer");
                double price = results.getDouble("price");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehiclesByType.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehiclesByType;
    }


    @Override
    public void removeVehicle(int vin) {
        String query = "DELETE FROM vehicles WHERE vin = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, vin);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Vehicle> findVehicleByVin(int vin) {
        List<Vehicle> vehicleList = new ArrayList<>();
        //creat the vehicle list in here
        try(Connection connection = dataSource.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM vehicles WHERE vin = ?;");
            ps.setInt(1, vin);
            ps.executeQuery();


            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                int vinFromDataBase = resultSet.getInt( "vin");
                int yearFromDataBase = resultSet.getInt("year");
                boolean boolFromDataBase = resultSet.getBoolean("sold");
                String makeFromDataBase = resultSet.getString("make");
                String modelFromDataBase = resultSet.getString("model");
                String vehicleTypeFromDataBase = resultSet.getString("vehicle_type");
                String colorFromDataBase = resultSet.getString("car_color");
                int odometerFromDataBase = resultSet.getInt("odometer");
                double priceFromDataBase = resultSet.getDouble("price");

                vehicleList.add(new Vehicle(vinFromDataBase, yearFromDataBase, makeFromDataBase, modelFromDataBase,
                        vehicleTypeFromDataBase, colorFromDataBase, odometerFromDataBase, priceFromDataBase ));
            }
        }catch (SQLException e) {

        }
        return vehicleList;
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        String query = "INSERT INTO vehicles (vin, year, make, model, type, color, odometer, price, sold) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, vehicle.getVin());
            statement.setInt(2, vehicle.getYear());
            statement.setString(3, vehicle.getMake());
            statement.setString(4, vehicle.getModel());
            statement.setString(5, vehicle.getType());
            statement.setString(6, vehicle.getColor());
            statement.setInt(7, vehicle.getOdometer());
            statement.setDouble(8, vehicle.getPrice());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicle;
    }
}