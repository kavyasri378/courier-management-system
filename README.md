**Project Name: Courier Management System**
**1. Project Overview**

The Courier Management System (CMS) is a desktop-based application built in Java with MySQL as the database backend. The system is designed to streamline courier operations, including branch management, shipment tracking, and customer service. The project demonstrates the use of OOP concepts, JDBC connectivity, and GUI components.

This repository contains a partial working prototype that allows:

Adding, updating, and viewing branches.

Recording courier shipments and tracking status.

Managing customers and courier details.

⚠️ Note: The system is still under development. Future versions will include full CRUD operations for all entities, reporting, and enhanced GUI.

**2. Features Implemented (Partial Prototype)**

Branch Management: Add/View/Update Branches

Courier Management: Add/View Courier Shipments

Customer Management: Add/View Customer Details

Database Connectivity using JDBC

**3. Technologies Used
**
Programming Language: Java (JDK 17+)

Database: MySQL

IDE: VS Code / IntelliJ IDEA

Version Control: Git & GitHub

**4. UML Diagrams**
**4.1 Class Diagram**
+------------------+
|      Branch      |
+------------------+
| - branch_id: int |
| - branch_name: String |
| - location: String |
+------------------+
| + getBranch_id() |
| + setBranch_id() |
| + getBranch_name()|
| + setBranch_name()|
| + getLocation()  |
| + setLocation()  |
+------------------+

+------------------+
|     Courier      |
+------------------+
| - courier_id: int|
| - sender: String |
| - receiver: String|
| - status: String |
+------------------+
| + getCourier_id()|
| + setCourier_id()|
| + getSender()   |
| + setSender()   |
| + getReceiver() |
| + setReceiver() |
| + getStatus()   |
| + setStatus()   |
+------------------+

+------------------+
|     Customer     |
+------------------+
| - customer_id: int|
| - name: String    |
| - phone: String   |
+------------------+
| + getCustomer_id()|
| + setCustomer_id()|
| + getName()      |
| + setName()      |
| + getPhone()     |
| + setPhone()     |
+------------------+

**4.2 Sequence Diagram (Adding a Courier)**
Customer -> CMS GUI : Fill Courier Details
CMS GUI -> CourierController : sendDetails()
CourierController -> CourierDAO : saveCourier()
CourierDAO -> Database : INSERT INTO courier(...)
Database -> CourierDAO : Success
CourierDAO -> CourierController : Success
CourierController -> CMS GUI : Show Confirmation

**4.3 Use Case Diagram**
[Customer] --> (Add Courier)
[Customer] --> (Track Courier)
[Admin] --> (Add Branch)
[Admin] --> (Manage Customers)
[Admin] --> (Update Courier Status)

5. Partial Prototype Screenshot

(Attach screenshot here if possible)

**6. Future Enhancements**

Full CRUD for all modules

GUI enhancement using JavaFX

Reporting & analytics

User authentication & role-based access
