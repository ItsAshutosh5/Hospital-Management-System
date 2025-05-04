package service;

import model.*;
import java.util.List;

public interface HospitalService {
    void addDoctor(Doctor doctor);
    void addPatient(Patient patient);
    void addAppointment(Appointment appointment);
    void addBill(Bill bill);
    List<Doctor> getAllDoctors();
    List<Patient> getAllPatients();
    List<Appointment> getAllAppointments();
    List<Bill> getAllBills();
}