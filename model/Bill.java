package model;

public class Bill {
    public int id;
    public int patientId;
    public double amount;
    public String date;

    public Bill(int id, int patientId, double amount, String date) {
        this.id = id;
        this.patientId = patientId;
        this.amount = amount;
        this.date = date;
    }

    public void showInfo() {
        System.out.println("Bill ID= " + id + ", PatientID= " + patientId + ", Amount= " + amount + ", Date= " + date);
    }
    public int getID(){
        return id;
    }
    public double getAmount(){
        return amount;
    }
    public int getPatientID(){
        return patientId;
    }
    public String getDate(){
        return date;
    }
}