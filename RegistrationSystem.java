import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private List<String> schedule;

    public Course(String courseCode, String title, String description, int capacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<String> getSchedule() {
        return schedule;
    }

    public void addSchedule(String dayAndTime) {
        schedule.add(dayAndTime);
    }

    @Override
    public String toString() {
        return "Course Code: " + courseCode + ", Title: " + title
                + ", Description: " + description + ", Capacity: " + capacity + ", Schedule: " + schedule;
    }
}

class Student {
    private String studentId;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
    }
}

public class RegistrationSystem {
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Course c1 = new Course("CS101", "Introduction to Computer Science", "An introductory course covering the basics of computer science.", 50);
        c1.addSchedule("Monday, 10:00 AM - 12:00 PM");
        c1.addSchedule("Wednesday, 10:00 AM - 12:00 PM");

        Course c2 = new Course("KCS073", "Artificial Intelligence", "A course on Artificial Intelligence and its applications.", 40);
        c2.addSchedule("Tuesday, 2:00 PM - 4:00 PM");
        c2.addSchedule("Thursday, 2:00 PM - 4:00 PM");

        courses.add(c1);
        courses.add(c2);

        boolean exit = false;
        while (!exit) {
            System.out.println("1. List Courses\n2. Register Student\n3. Display Registered Courses of a Student\n4. Register Course for a Student\n5. Drop Course for a Student\n6. Exit");
            System.out.println("Enter Your choice");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    listCourses();
                    break;
                case 2:
                    registerStudent();
                    break;
                case 3:
                    displayRegisteredCourses();
                    break;
                case 4:
                    registerCourseForStudent();
                    break;
                case 5:
                    dropCourseForStudent();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void listCourses() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private static void registerStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter student name: ");
        String name = scanner.next();
        Student student = new Student(studentId, name);
        students.add(student);
        System.out.println("Student registered successfully");
    }

    private static void displayRegisteredCourses() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                List<Course> registeredCourses = student.getRegisteredCourses();
                if (registeredCourses.isEmpty()) {
                    System.out.println("Student has not registered for any courses yet.");
                } else {
                    System.out.println("Registered courses for " + student.getName() + ":");
                    for (Course course : registeredCourses) {
                        System.out.println(course.getTitle());
                    }
                }
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void registerCourseForStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter course code: ");
        String courseCode = scanner.next();
        Course course = findCourse(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }
        Student student = findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        if (student.getRegisteredCourses().size() >= 3) {
            System.out.println("Student can't register for more than 3 courses.");
            return;
        }
        student.registerCourse(course);
        System.out.println("Course registered successfully for " + student.getName());
    }

    private static void dropCourseForStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter course code: ");
        String courseCode = scanner.next();
        Course course = findCourse(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }
        Student student = findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        student.dropCourse(course);
        System.out.println("Course dropped successfully for " + student.getName());
    }

    private static Course findCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        return null;
    }

    private static Student findStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null;
    }
}

