package university;

public class University {
    private String name;
    private String rectorFirstName;
    private String rectorLastName;
    private Student[] students;
    private Course[] courses;

    private int studentIdCounter=10000;
    private int courseCodeCounter=10;

    /**
     * Constructor
     * @param name name of the university
     */
    public University(String name){
        this.name = name;
        students = new Student[10];
        courses = new Course[10];
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
        this.rectorFirstName = first;
        this.rectorLastName = last;
    }

    /**
     * Retrieves the rector of the university
     *
     * @return
     */
    public String getRector(){
        return rectorFirstName+" "+rectorLastName;
    }

    /**
     * Enroll a student in the university
     *
     * @param first first name of the student
     * @param last last name of the student
     * @return
     */
    public int enroll(String first, String last){
        if ((studentIdCounter-10000)>=students.length){
            Student[] temp = new Student[students.length*2];
            for (int i = 0; i < temp.length; i++) {
                System.arraycopy(students, 0, temp, 0, students.length);
            }
            students=temp;
        }
        Student student = new Student(studentIdCounter,first,last);
        students[studentIdCounter-10000] = student;
        studentIdCounter++;
        return student.getId();
    }

    /**
     * Retrieves the information for a given student
     *
     * @param id the id of the student
     * @return information about the student
     */
    public String student(int id){
        Student student = students[id-10000];
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
        if ((courseCodeCounter-10000)>=courses.length){
            Course[] temp = new Course[courses.length*2];
            for (int i = 0; i < temp.length; i++) {
                System.arraycopy(courses, 0, temp, 0, courses.length);
            }
            courses=temp;
        }
        Course course = new Course(courseCodeCounter,title,teacher);
        courses[courseCodeCounter-10] = course;
        courseCodeCounter++;
        return course.getCode();
    }

    /**
     * Retrieve the information for a given course
     *
     * @param code unique code of the course
     * @return information about the course
     */
    public String course(int code){
        Course course = courses[code-10];
        return course.toString();
    }

    /**
     * Register a student to attend a course
     * @param studentID id of the student
     * @param courseCode id of the course
     */
    public void register(int studentID, int courseCode){
        Student student = students[studentID-10000];
        Course course =courses[courseCode-10];
        course.register(student);
    }

    /**
     * Retrieve a list of attendees
     *
     * @param courseCode unique id of the course
     * @return list of attendees separated by "\n"
     */
    public String listAttendees(int courseCode){
        Course course = courses[courseCode-10];
        return course.listAttendees();
    }

    /**
     * Retrieves the study plan for a student
     *
     * @param studentID id of the student
     * @return list of courses the student is registered for
     */
    public String studyPlan(int studentID){
        Student student = students[studentID-10000];
        return student.studyPlan();
    }


}
