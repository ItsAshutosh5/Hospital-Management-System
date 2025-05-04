-- Create the hospital database if it doesn't exist
CREATE DATABASE IF NOT EXISTS hospital;

-- Use the hospital database
USE hospital;

-- Create the doctors table
CREATE TABLE IF NOT EXISTS doctors (
    id INT PRIMARY KEY,                     -- Doctor's ID (Primary Key)
    name VARCHAR(255) NOT NULL,              -- Doctor's Name
    specialization VARCHAR(255) NOT NULL     -- Doctor's Specialization
);

-- Create the patients table
CREATE TABLE IF NOT EXISTS patients (
    id INT PRIMARY KEY,                     -- Patient's ID (Primary Key)
    name VARCHAR(255) NOT NULL,              -- Patient's Name
    disease VARCHAR(255) NOT NULL            -- Patient's Disease
);

-- Create the appointments table
CREATE TABLE IF NOT EXISTS appointments (
    id INT PRIMARY KEY,                     -- Appointment's ID (Primary Key)
    doctor_id INT NOT NULL,                  -- Doctor's ID (Foreign Key)
    patient_id INT NOT NULL,                 -- Patient's ID (Foreign Key)
    date DATE NOT NULL,                      -- Appointment Date
    FOREIGN KEY (doctor_id) REFERENCES doctors(id),   -- Foreign Key reference to doctors
    FOREIGN KEY (patient_id) REFERENCES patients(id)   -- Foreign Key reference to patients
);

-- Create the bills table
CREATE TABLE IF NOT EXISTS bills (
    id INT PRIMARY KEY,                     -- Bill's ID (Primary Key)
    patient_id INT NOT NULL,                 -- Patient's ID (Foreign Key)
    amount DOUBLE NOT NULL,                  -- Bill Amount
    date DATE NOT NULL,                      -- Bill Date
    FOREIGN KEY (patient_id) REFERENCES patients(id)  -- Foreign Key reference to patients
);
