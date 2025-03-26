package university;

import list.MyArrayList;
import list.MyList;

public class Course {
    private String title;
    private String teacher;
    private int code;

    private MyList students;

    public Course(int code, String title, String teacher) {
        this.title = title;
        this.teacher = teacher;
        this.code = code;
        students = new MyArrayList();
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
        students.add(student);
        student.addCourse(this);
    }

    @Override
    public String toString() {
        return code + " "+title +" "+ teacher;
    }

    public String listAttendees() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < students.size(); i++) {
            Student student = (Student) students.get(i);
            sb.append(student.toString()).append('\n');
        }
        return sb.toString();
    }
}
