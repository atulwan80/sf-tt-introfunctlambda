package student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class School2 {
    public static void processStudents(List<Student> ls, Consumer<Student> operation ) {
        for (Student s : ls) {
            operation.accept(s);
        }
    }

    public static List<Student> selectStudentsByCriterion(List<Student> ls, Predicate<Student> crit) {
        List<Student> out = new ArrayList<>();
        for (Student s : ls) {
            if (crit.test(s)) {
                out.add(s);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        List<Student> school = new ArrayList<>(Arrays.asList(
                new Student("Fred", 2.8, "Math", "Physics", "Chemistry"),
                new Student("Jim", 3.2, "Art", "History"),
                new Student("Sheila", 3.7, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
        ));

        System.out.println("Enthusiastic by lambda");
        processStudents(selectStudentsByCriterion(school, s -> s.getCourses().size() > 3),
                s -> System.out.println("> " + s));

//        int s;
        school.forEach(s -> System.out.println(">> " + s));
        school.replaceAll(s ->
                new Student(s.getName().toUpperCase(),
                        s.getGrade() + 0.3,
                        s.getCourses().toArray(new String[0])));
        school.forEach(s -> System.out.println("-- " + s));
    }
}
