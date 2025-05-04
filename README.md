
🏥 Hospital Management System (Java CLI Project)

A simple, modular, command-line based Hospital Management System built using Java. 
The system allows managing doctors, patients, appointments, and billing operations 
efficiently using Object-Oriented Programming principles, JDBC for database interaction, 
and threading for background system monitoring.

👨‍💻 Creators
-------------
- Kanishka Tyagi (235UCS066)
- Sakshi Singh (235UCS106)
- Aparna Sharma (235UCS131)
- Ashutosh Ranjan Tripathi (235UCS130)

📌 Features
-----------
- Add & view Doctors, Patients, Appointments, and Bills
- Stores data persistently using MySQL or SQLite
- Uses Threading to monitor system status in background
- Implements OOP Concepts:
  - Abstraction (via abstract classes)
  - Inheritance (Doctor and Patient inherit Person)
  - Polymorphism (interface implementation)
- Uses Exception Handling for input and database operations

🛠️ Technologies Used
---------------------
- Java
- JDBC
- MySQL
- Command-line interface (CLI)

🧾 Database Schema
------------------
Tables used:
- doctors — ID, Name, Specialization
- patients — ID, Name, Disease
- appointments — ID, Doctor ID, Patient ID, Date
- bills — ID, Patient ID, Amount, Date

> SQL script to create tables is included in `create_tables.sql`

▶️ How to Run
-------------
1. Clone the git repository into your system.

2. Compile all Java files:
   javac model/*.java service/*.java main/*.java util/*.java

3. Run the application:
   java main.HospitalManagement

4. Make sure MySQL is set up and the `create_tables.sql` is executed before running.

💡 Future Improvements
----------------------
- Add GUI with JavaFX or Swing
- Add login/authentication
- Export reports to PDF
- Add RESTful API backend (Spring Boot)
