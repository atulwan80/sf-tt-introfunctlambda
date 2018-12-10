package student;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Student {
    private String name;
    private double grade;
    private Set<String> courses = new HashSet<>();

    public Student(String name, double grade, String ... courses) {
        this.name = name;
        this.grade = grade;
        this.courses = new HashSet<>(Arrays.asList(courses));
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public Set<String> getCourses() {
        return Collections.unmodifiableSet(courses);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", courses=" + courses +
                '}';
    }
}
