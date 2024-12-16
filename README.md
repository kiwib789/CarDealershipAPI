### Car Dealership 

This Spring Boot application provides a simple way to manage a car dealership’s vehicles, sales contracts, and lease contracts. It uses MySQL as the database and includes features to add, view, and list vehicles and contracts.

---

### **Features**

1. **Vehicle Management**:
   - **Add Vehicles**: Users can add new cars to the dealership’s inventory.
   - **View Vehicles**: Users can look up details of a specific car using its VIN (Vehicle Identification Number).
   - **List Vehicles**: Users can see all cars in the dealership’s inventory.

2. **Sales Contract Management**:
   - **Add Sales Contracts**: Users can create new sales contracts for cars sold.
   - **View Sales Contracts**: Users can see all sales contracts or search by VIN to view a specific contract.

3. **Lease Contract Management**:
   - **Add Lease Contracts**: Users can add new lease contracts for cars leased to customers.
   - **View Lease Contracts**: Users can see all lease contracts or search by VIN to find a specific contract.

---


#### **Vehicle Management**

1. **GET /vehicles**
   - Retrieves a list of all vehicles.
   
2. **GET /vehicles/{vin}**
   - Retrieves details of a vehicle using its VIN.
   
3. **POST /vehicles/add**
   - Adds a new vehicle to the inventory.

#### **Sales Contract**

1. **GET /sales-contracts**
   - Retrieves a list of all sales contracts.

2. **GET /sales-contracts/by-vin/{vin}**
   - Retrieves a sales contract by the vehicle’s VIN.
   
3. **POST /sales-contracts/add**
   - Adds a new sales contract for a vehicle.

#### **Lease Contract**

1. **GET /lease-contracts**
   - Retrieves a list of all lease contracts.

2. **GET /lease-contracts/by-vin/{vin}**
   - Retrieves a lease contract for a vehicle using its VIN.

3. **POST /lease-contracts/add**
   - Adds a new lease contract.

---

### **Summary**

The **Car Dealership Management System** helps a dealership manage cars, sales, and leases using a simple web API built with **Spring Boot** and **MySQL**.
