package Q3.CourseType;

import Q3.Organizer.StudentOrganizer;
import Q3.PersonType.Student;

import java.util.Arrays;


public class Course {
   private String name;
   public Student[] students;
   private int capacity = 40;
   private int numberOfStudent = 0;

    public Course(String name) {
        this.name = name;
    }

    public Course(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public String getCourseName() {
        return name;
    }

    public Student[] getStudents() {
        return students;
    }

    public boolean addStudent(Student student){
        if (capacity <= numberOfStudent) return false;
        if(students == null){
            students = new Student[1];
            students[0] = student;
            numberOfStudent++;
            return true;
        }
        else{

            for (Student s:students ) {
                 if(s.getId() == student.getId())
                    return false;
             }
            students = StudentOrganizer.addStudentArray(students, student);
            numberOfStudent++;
            return true;
        }
    }


    public boolean dropStudent(Student student){
        if (students == null) return false;
        for (int i = 0; i<students.length;i++ ) {
            if (students[i].getId()==student.getId()){
                students = StudentOrganizer.dropStudentArray(students,i);
                numberOfStudent--;
                return true;
            }

        }
        return false;
    }

    public void increaseCapacity(){
        capacity+=5;
    }

    public Student getBestStudent(){
        Student bestS = students[0];
        for (Student s:students) {
            if (s.getGpa() > bestS.getGpa()){
                bestS = s;
            }

        }
        return bestS;
    }

    public Student getYoungestStudent(){
        Student youngS = students[0];

        for (Student s:students) {
            if(youngS.getPd().getBirthDate().compareTo(s.getPd().getBirthDate()) < 0){
                youngS = s;
            }

         }

        return youngS;
    }


    public void clear(){
        students = null;
        numberOfStudent = 0;

    }

    public void list(){
        for (Student s:students) {
            System.out.println(s);
            }
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", students=" + Arrays.toString(students) +
                ", capacity=" + capacity +
                ", numberOfStudent=" + numberOfStudent +
                '}';
    }
}
