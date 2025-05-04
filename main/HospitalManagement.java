package main;

import model.*;
import service.*;
import util.*;
import java.util.*;

public class HospitalManagement {
    public static void main(String[] args) {
        HospitalService service = new HospitalServiceImpl();
        Scanner sc = new Scanner(System.in);

        Thread monitor = new Thread(() -> {
            while (true) {
                System.out.println("[Monitor] System running...");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        monitor.start();

        while (true) {
            System.out.println("\n1. Add Doctor\n2. Add Patient\n3. Add Appointment\n4. Add Bill\n5. View All Doctors\n6. View All Patients\n7. View All Appointments\n8. View All Bills\n9. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Doctor ID: "); int dId = sc.nextInt(); sc.nextLine();
                        System.out.print("Doctor Name: "); String dName = sc.nextLine();
                        System.out.print("Specialization: "); String spec = sc.nextLine();
                        service.addDoctor(new Doctor(dId, dName, spec));
                        break;
                    case 2:
                        System.out.print("Patient ID: "); int pId = sc.nextInt(); sc.nextLine();
                        System.out.print("Patient Name: "); String pName = sc.nextLine();
                        System.out.print("Disease: "); String disease = sc.nextLine();
                        service.addPatient(new Patient(pId, pName, disease));
                        break;
                    case 3:
                        System.out.print("Appointment ID: "); int aId = sc.nextInt(); sc.nextLine();
                        System.out.print("Doctor ID: "); int aDocId = sc.nextInt(); sc.nextLine();
                        System.out.print("Patient ID: "); int aPatId = sc.nextInt(); sc.nextLine();
                        System.out.print("Date (YYYY-MM-DD): "); String date = sc.nextLine();
                        service.addAppointment(new Appointment(aId, aDocId, aPatId, date));
                        break;
                    case 4:
                        System.out.print("Bill ID: "); int bId = sc.nextInt(); sc.nextLine();
                        System.out.print("Patient ID: "); int bPatId = sc.nextInt(); sc.nextLine();
                        System.out.print("Amount: "); double amount = sc.nextDouble(); sc.nextLine();
                        System.out.print("Date (YYYY-MM-DD): "); String bDate = sc.nextLine();
                        service.addBill(new Bill(bId, bPatId, amount, bDate));
                        break;
                    case 5:
                        service.getAllDoctors().forEach(Doctor::showInfo);
                        break;
                    case 6:
                        service.getAllPatients().forEach(Patient::showInfo);
                        break;
                    case 7:
                        service.getAllAppointments().forEach(Appointment::showInfo);
                        break;
                    case 8:
                        service.getAllBills().forEach(Bill::showInfo);
                        break;
                    case 9:
                        System.exit(0);
                    default:
                        throw new CustomException("Invalid menu option.");
                }
            } catch (CustomException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}