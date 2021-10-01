package Q3;

import Q3.CourseType.Course;
import Q3.PersonType.PersonalData;
import Q3.PersonType.Student;

public class Main {
    public static void main(String[] args) {

System.out.println("Task - 1");

        Student[] S = new Student[]{
            new Student("onur", 5005, 5, new PersonalData(1992, 6, 25, 1)),
            new Student("mert", 2, 10, new PersonalData(1998, 6, 25, 1)),
            new Student("metin", 3, 15, new PersonalData(1990, 6, 25, 1)),
            new Student("emine", 4, 20, new PersonalData(1970, 6, 25, 1)),
            new Student("aslı", 5, 25, new PersonalData(1950, 6, 25, 1))

        };

System.out.println("Task - 2");




        Course K129 = new Course("K129", 3);


System.out.println("Task - 3");


        for (Student s:S) {
           K129.addStudent(s);
        }

System.out.println("Task - 4");

        K129.list();


System.out.println("Task - 5");


        K129.increaseCapacity();


System.out.println("Task - 6");


        K129.addStudent(S[3]);
        K129.addStudent(S[4]);


System.out.println("Task - 7");


        K129.list();


System.out.println("Task - 8");


        K129.dropStudent(S[0]);


System.out.println("Task - 9");


        K129.list();


System.out.println("Task - 10");


        System.out.println(K129.getNumberOfStudent());


System.out.println("Task - 11");


        System.out.println(K129.getBestStudent().getPd().getBirthDate().getYear());


System.out.println("Task - 12");

        Course K130 = new Course("K130");

System.out.println("Task - 13");

        for (Student s:K129.getStudents()) {
                    K130.addStudent(s);
        }

System.out.println("Task - 14");

        K129.clear();

System.out.println("Task - 15");

        System.out.println(K129.dropStudent(S[0]));

System.out.println("Task - 16");

        K130.list();

System.out.println("Task - 17");

        K130.dropStudent(K130.getBestStudent());

System.out.println("Task - 18");

        K130.list();

System.out.println("Task - 19");

        System.out.println(K130.getYoungestStudent());

System.out.println("Task - 20");

        System.out.println(K129.toString());
        System.out.println(K130.toString());

















    }
}
