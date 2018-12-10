package student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class School {
    public static void main(String[] args) {
        List<Student> school = new ArrayList<>(Arrays.asList(
                new Student("Fred", 3.2, "Math", "Physics", "Chemistry"),
                new Student("Jim", 2.8, "Art", "History"),
                new Student("Sheila", 3.7, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
        ));
    }
}
