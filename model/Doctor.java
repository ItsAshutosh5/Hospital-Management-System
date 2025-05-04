package model;

public class Doctor extends Person {
    private String specialization;

    public Doctor(int id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    @Override
    public void showInfo() {
        System.out.println("Doctor: ID= " + id + ", Name= " + name + ", Specialization= " + specialization);
    }
    public int getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getSpecialization(){
        return specialization;
    }
}