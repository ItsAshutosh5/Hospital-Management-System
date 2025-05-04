package service;

import model.*;
import db.DBConnection;
import java.sql.*;
import java.util.*;

public class HospitalServiceImpl implements HospitalService {
    public void addDoctor(Doctor doctor) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO doctors(id, name, specialization) VALUES(?, ?, ?)");) {
            stmt.setInt(1, doctor.getID());
            stmt.setString(2, doctor.getName());
            stmt.setString(3, doctor.getSpecialization());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPatient(Patient patient) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO patients(id, name, disease) VALUES(?, ?, ?)");) {
            stmt.setInt(1, patient.getID());
            stmt.setString(2, patient.getName());
            stmt.setString(3, patient.getDisease());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAppointment(Appointment appointment) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO appointments(id, doctor_id, patient_id, date) VALUES(?, ?, ?, ?)");) {
            stmt.setInt(1, appointment.getID());
            stmt.setInt(2, appointment.getDoctorID());
            stmt.setInt(3, appointment.getPatientID());
            stmt.setString(4, appointment.getDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBill(Bill bill) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO bills(id, patient_id, amount, date) VALUES(?, ?, ?, ?)");) {
            stmt.setInt(1, bill.getID());
            stmt.setInt(2, bill.getPatientID());
            stmt.setDouble(3, bill.getAmount());
            stmt.setString(4, bill.getDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> list = new ArrayList<>();
        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM doctors");) {
            while (rs.next()) {
                list.add(new Doctor(rs.getInt("id"), rs.getString("name"), rs.getString("specialization")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Patient> getAllPatients() {
        List<Patient> list = new ArrayList<>();
        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM patients");) {
            while (rs.next()) {
                list.add(new Patient(rs.getInt("id"), rs.getString("name"), rs.getString("disease")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> list = new ArrayList<>();
        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM appointments");) {
            while (rs.next()) {
                list.add(new Appointment(
                    rs.getInt("id"),
                    rs.getInt("doctor_id"),
                    rs.getInt("patient_id"),
                    rs.getString("date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Bill> getAllBills() {
        List<Bill> list = new ArrayList<>();
        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM bills");) {
            while (rs.next()) {
                list.add(new Bill(
                    rs.getInt("id"),
                    rs.getInt("patient_id"),
                    rs.getDouble("amount"),
                    rs.getString("date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}