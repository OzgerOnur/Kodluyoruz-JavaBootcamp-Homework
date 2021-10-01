package Q3.Organizer;

import Q3.PersonType.Student;

public class StudentOrganizer {

    public static Student[] addStudentArray(Student[] students, Student student){


            Student[] newStudents = new Student[(students.length + 1)];
            for(int i = 0;i < students.length; i++){
                newStudents[i] = students[i];
            }
            newStudents[(newStudents.length - 1)] = student;

            return  newStudents;



    }

    public static Student[] dropStudentArray(Student[] students, int arrayNumber){
        Student[] newStudents = new Student[(students.length - 1)];
        for (int i = 0;i<newStudents.length;i++){
            if (i < arrayNumber) newStudents[i] = students[i];
            else newStudents[i] = students[(i+1)];
        }
        return newStudents;
    }



}
