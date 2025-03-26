package university;

import list.MyArrayList;
import list.MyList;

public class Student {
    private int id;
    private String firstName;
    private String lastName;

    private MyList courses;

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        courses = new MyArrayList();
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return getId()+ " " + getFullName();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public String studyPlan() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < courses.size(); i++) {
            Course course = (Course) courses.get(i);
            sb.append(course.toString()).append('\n');
        }
        return sb.toString();
    }
}
