package university;

import list.MyArrayList;
import list.MyList;

public class University {
    private String name;
    private Rector rector;
    private MyList students;
    private MyList courses;

    /**
     * Constructor
     * @param name name of the university
     */
    public University(String name){
        this.name = name;
        students = new MyArrayList();
        courses = new MyArrayList();
    }

    /**
     * Getter for the name of the university
     * @return name of university
     */
    public String getName(){
        return name;
    }

    /**
     * Defines the rector for the university
     *
     * @param first
     * @param last
     */
    public void setRector(String first, String last){
        this.rector = new Rector(first,last);
    }

    /**
     * Retrieves the rector of the university
     *
     * @return
     */
    public String getRector(){
        return rector.toString();
    }

    /**
     * Enroll a student in the university
     *
     * @param first first name of the student
     * @param last last name of the student
     * @return
     */
    public int enroll(String first, String last){
        Student student = new Student(students.size()+10000, first,last);
        students.add(student);
        return student.getId();
    }

    /**
     * Retrieves the information for a given student
     *
     * @param id the id of the student
     * @return information about the student
     */
    public String student(int id){
        Student student = getStudentById(id);
        return student.toString();
    }

    /**
     * Activates a new course with the given teacher
     *
     * @param title title of the course
     * @param teacher name of the teacher
     * @return the unique code assigned to the course
     */
    public int activate(String title, String teacher){
        Course course = new Course(courses.size()+10,title,teacher);
        courses.add(course);
        return course.getCode();
    }

    /**
     * Retrieve the information for a given course
     *
     * @param code unique code of the course
     * @return information about the course
     */
    public String course(int code){
        Course course = getCourseByCode(code);
        return course.toString();
    }

    /**
     * Register a student to attend a course
     * @param studentID id of the student
     * @param courseCode id of the course
     */
    public void register(int studentID, int courseCode){
        Student student = getStudentById(studentID);
        Course course =getCourseByCode(courseCode);
        course.register(student);
    }

    /**
     * Retrieve a list of attendees
     *
     * @param courseCode unique id of the course
     * @return list of attendees separated by "\n"
     */
    public String listAttendees(int courseCode){
        Course course = getCourseByCode(courseCode);
        return course.listAttendees();
    }

    /**
     * Retrieves the study plan for a student
     *
     * @param studentID id of the student
     * @return list of courses the student is registered for
     */
    public String studyPlan(int studentID){
        Student student = getStudentById(studentID);
        return student.studyPlan();
    }

    private  Student getStudentById(int studentID){
        return (Student) students.get(studentID-10000);
    }

    private  Course getCourseByCode(int courseCode){
        return (Course) courses.get(courseCode-10);
    }

}
