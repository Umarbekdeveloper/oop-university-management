package university;

public class Course {
    private String title;
    private String teacher;
    private int code;

    private Student[] students;

    private int studentCount = 0;

    public Course(int code, String title, String teacher) {
        this.title = title;
        this.teacher = teacher;
        this.code = code;
        students = new Student[50];
    }

    public String getTitle() {
        return title;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getCode() {
        return code;
    }

    void register(Student student){
        students[studentCount++] = student;
        student.addCourse(this);
    }

    @Override
    public String toString() {
        return code + " "+title +" "+ teacher;
    }

    public String listAttendees() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < studentCount; i++) {
            Student student = students[i];
            sb.append(student.toString()).append('\n');
        }
        return sb.toString();
    }
}
