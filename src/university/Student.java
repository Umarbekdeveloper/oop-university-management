package university;

public class Student {
    private int id;
    private String firstName;
    private String lastName;

    private Course[] courses;
    private int courseCount = 0;

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        courses = new Course[25];
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
        courses[courseCount++] = course;
    }

    public String studyPlan() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < courseCount; i++) {
            Course course = courses[i];
            sb.append(course.toString()).append('\n');
        }
        return sb.toString();
    }
}
