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
- Java SE 8+
- Swing for GUI
- JMapViewer for map rendering
- Java RMI for real-time communication
- Java WebSocket API (javax.websocket)
- JDBC for database operations
- MySQL or SQLite (configurable)
