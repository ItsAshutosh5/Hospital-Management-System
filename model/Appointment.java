package model;

public class Appointment {
    private int id;
    private int doctorId;
    private int patientId;
    private String date;

    public Appointment(int id, int doctorId, int patientId, String date) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.date = date;
    }

    public void showInfo() {
        System.out.println("Appointment ID= " + id + ", DoctorID= " + doctorId + ", PatientID= " + patientId + ", Date= " + date);
    }
    public int getID(){
        return id;
    }
    public int getDoctorID(){
        return doctorId;
    }
    public int getPatientID(){
        return patientId;
    }
    public String getDate(){
        return date;
    }
}