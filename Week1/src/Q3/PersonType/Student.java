package Q3.PersonType;

public class Student {

    private String name;
    private long id;
    private double gpa;
    private PersonalData pd;


    public Student(String name, long id, double gpa, PersonalData pd) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
        this.pd = pd;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    public PersonalData getPd() {
        return pd;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", gpa=" + gpa +
                '}';
    }



}
