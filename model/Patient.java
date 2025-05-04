package model;

public class Patient extends Person {
    private String disease;

    public Patient(int id, String name, String disease) {
        super(id, name);
        this.disease = disease;
    }

    @Override
    public void showInfo() {
        System.out.println("Patient: ID= " + id + ", Name= " + name + ", Disease= " + disease);
    }
    public int getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDisease(){
        return disease;
    }
}