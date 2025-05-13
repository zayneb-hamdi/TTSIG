# 📌 GIS Management and Internal Communication System – Tunisie Telecom

This project is a Java-based integrated system developed as part of an internship at **Tunisie Telecom**. It includes three key modules:

- 🗺️ A **Geographic Information System (GIS)** with map visualization and database layer management.
- 💬 A **real-time internal chat application** using **Java RMI**.
- 🔐 A **login system** implemented with **Java WebSocket**.

---

## 🗂️ Project Modules

### 1. 🌍 Geographic Information System (GIS)

This module enables users to:

- Import or download maps using **JMapViewer** (OpenStreetMap-based).
- Perform **CRUD operations** on geographic **layers**.
- Store layers with their name, latitude, and longitude in a relational database.

### 2. 💬 Internal Chat Application – Java RMI
A lightweight internal messaging system that allows employees of Tunisie Telecom to chat with each other in real time.  

Features:
- Built with Java RMI (Remote Method Invocation).
- Supports multiple clients connected to a central server.
- Simple Swing GUI for message input and display.

### 3. 🔐 Login Module – Java WebSocket
A basic authentication system using Java WebSocket API that:

- Authenticates users before giving access to GIS or Chat modules.
- Uses a WebSocket-based client/server communication model.
- Can be extended to support session management and roles.
## 🛠️ Technologies Used
- Java 
- Swing for GUI
- JMapViewer for map rendering
- Java RMI for real-time communication
- Java WebSocket API (javax.websocket)
- JDBC for database operations
- MySQL

## configuration and Setup
### Database Setup

To set up the MySQL databases for this project, follow these steps:
1. Create Databases
2. dvsv
Run the following commands in your MySQL terminal:  
   ```sql
   CREATE DATABASE IF NOT EXISTS layerdb;
   CREATE DATABASE IF NOT EXISTS chatdb;
2. Create tables
   ```sql
   USE layerdb;
   CREATE TABLE IF NOT EXISTS layer (
   id INT AUTO_INCREMENT PRIMARY KEY,
   nom VARCHAR(255) NOT NULL,
   latitude DECIMAL(10, 7) NOT NULL,
   longitude DECIMAL(10, 7) NOT NULL
   );
   USE chatdb;
   CREATE TABLE IF NOT EXISTS message (
   id INT AUTO_INCREMENT PRIMARY KEY,
   sender VARCHAR(255) NOT NULL,
   TEXTcontent NOT NULL
   );

## Interfaces
![image](https://github.com/user-attachments/assets/1bceb258-2da5-424b-9465-83dfb461f25c)
![image](https://github.com/user-attachments/assets/52cf254c-bd90-4f11-83de-c84bee2c67f1)
![image](https://github.com/user-attachments/assets/9832ae5c-5e8b-4ef6-835d-d1cd4174c55c)
![image](https://github.com/user-attachments/assets/8ddac8c0-1969-4192-90e1-5cb24123bfa1)

## Author
zayneb hamdi  
Internship Project at Tunisie Telecom
