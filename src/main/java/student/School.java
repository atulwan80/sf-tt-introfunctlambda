package student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
interface StudentCriterion {
    boolean test(Student s);
//    void doStuff();
}

@FunctionalInterface
interface Odd {
    boolean test2(Student s);
}

class SmartStudentCriterion implements StudentCriterion {
    @Override
    public boolean test(Student s) {
        return s.getGrade() > 3.0;
    }
}

class EnthusiasticStudentCriterion implements StudentCriterion {
    @Override
    public boolean test(Student s) {
        return s.getCourses().size() > 2;
    }
}

public class School {
    public static void showSmartStudents(List<Student> ls, double threshold) {
        for (Student s : ls) {
            if (s.getGrade() > threshold) {
                System.out.println(s);
            }
        }
        System.out.println("------------------------");
    }

    public static void showEnthusiastiStudents(List<Student> ls, int threshold) {
        for (Student s : ls) {
            if (s.getCourses().size() > threshold) {
                System.out.println(s);
            }
        }
        System.out.println("------------------------");
    }

    // Passing an object as an argument for the benefit of the *behavior* it contains
    // is called the Command pattern.
    // second argument was StudentCriterion!
    public static void showStudentsByCriterion(List<Student> ls, Predicate<Student> crit) {
        for (Student s : ls) {
            if (crit.test(s)) { // NOT crit(s) [nor test(s)]
                System.out.println(s);
            }
        }
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        List<Student> school = new ArrayList<>(Arrays.asList(
                new Student("Fred", 2.8, "Math", "Physics", "Chemistry"),
                new Student("Jim", 3.2, "Art", "History"),
                new Student("Sheila", 3.7, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
        ));
        showSmartStudents(school, 3.2);
        showSmartStudents(school, 3.0);
        System.out.println("More than 2 courses");
        showEnthusiastiStudents(school, 2);

//        System.out.println("Enthusiastic by criterion");
//        showStudentsByCriterion(school, new EnthusiasticStudentCriterion());
//        System.out.println("Smart by criterion");
//        showStudentsByCriterion(school, new SmartStudentCriterion());

//        System.out.println("Enthusiastic by anonymous inner class");
//        showStudentsByCriterion(school, new /* remove explicit class name */
//        /*class EnthusiasticStudentCriterion implements */ StudentCriterion() {
//            @Override
//            public boolean test(Student s) {
//                return s.getCourses().size() > 3;
//            }
//        });

//        System.out.println("Enthusiastic by lambda");
//        showStudentsByCriterion(school, /*new StudentCriterion() {*/
//            /*@Override
//            public boolean test*/(Student s) -> {
//                return s.getCourses().size() > 3;
//            }
//        /*}*/);

//        System.out.println("Enthusiastic by lambda");
//        showStudentsByCriterion(school,
//                // make one instance
//                // In a class that implements StudentCriterion
//                /*public boolean test*/(Student s) -> { return s.getCourses().size() > 3; }
//                );

//        System.out.println("Enthusiastic by lambda");
//        showStudentsByCriterion(school,
//                (Student s) -> { return s.getCourses().size() > 3; }
//                (Student s) -> s.getCourses().size() > 3
//                (s) -> s.getCourses().size() > 3
//                s -> s.getCourses().size() > 3
//                );

        System.out.println("Enthusiastic by lambda");
//        Object c = s -> s.getCourses().size() > 3;
//        StudentCriterion studentIsEnthusiasticCriterion;
        Predicate<Student> studentIsEnthusiasticCriterion;
        studentIsEnthusiasticCriterion = s -> s.getCourses().size() > 3;
        showStudentsByCriterion(school, studentIsEnthusiasticCriterion);

        ((StudentCriterion)(s -> s.getCourses().size() > 3))
                .test(new Student("Alice", 2.2));
    }
}
