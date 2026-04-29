import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;
    private int studentID;
    private double gpa;

    public Student(String name, int studentID, double gpa) {
        this.name = name;
        this.gpa = gpa;
        this.studentID = studentID;
    }

    public int getstudentID() {
        return studentID;
    }

    public String getname() {
        return name;
    }

    public double getgpa() {
        return gpa;
    }

    public void setstudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setgpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Name: " + name + " , Student ID: " + studentID + " , GPA: " + gpa;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.studentID, other.studentID);

    }

    public void PrintInfo() {
        System.out.println(name + " " + gpa + " " + studentID);
    }

}

class EnrollmentDemo {
    public static void main(String[] args) {
        Student a = new Student("Halilişko", 3125678, 2.45);
        Student b = new Student("Mükremin Gezgin DİVA", 202567867, 3.12);
        Student c = new Student("Eröl Yıldırım", 564536625, 1.55);
        Student t = new Student("idil", 2445667, 2.89);
        Student k = new Student("Ali", 34526783, 1.95);
        Course d = new Course(223, "MATH");
        d.addStudent(k);
        d.addStudent(t);
        d.addStudent(a);
        d.addStudent(b);
        d.addStudent(c);
        d.searchByName("ali");
        //d.filterProbation();
        //System.out.println(d.getenrolledStudents().size());
        //Collections.sort(d.getenrolledStudents());
        //System.out.println("By ID: " + d.getenrolledStudents());
        //System.out.println();
        //Collections.sort(d.getenrolledStudents() ,new GpaComparator());
        //System.out.println("By GPA: " + d.getenrolledStudents());
        System.out.println();


        a.PrintInfo();
        b.PrintInfo();
        c.PrintInfo();

    }
}

class Course {
    private int courseCode;
    private String courseName;
    private ArrayList<Student> enrolledStudents;
    private ArrayList<Student> probationList;

    public Course(int courseCode, String courseName) {
        enrolledStudents = new ArrayList<>();
        probationList = new ArrayList<>();
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public ArrayList<Student> getenrolledStudents() {
        return enrolledStudents;
    }

    public void setenrolledStudents(ArrayList<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public void addStudent(Student s) {
        enrolledStudents.add(s);
    }

    public void displayEnrolledStudents() {
        for (int i = 0; i < enrolledStudents.size(); i++) {
            enrolledStudents.get(i).PrintInfo();
            return;
        }
    }

    public void removeStudentByID(int id) {
        for (int i = 0; i < enrolledStudents.size(); i++) {
            if (enrolledStudents.get(i).getstudentID() == id) {
                enrolledStudents.remove(i);
                System.out.println(id + " has been removed");
                return;

            }
        }
        System.out.println("Student not found");
    }


    public void filterProbation() {
        for (int i = enrolledStudents.size() - 1; i >= 0; i--) {
            if (2.0 > enrolledStudents.get(i).getgpa()) {
                probationList.add(enrolledStudents.get(i));
                enrolledStudents.remove(i);
            }
        }
    }

    public void searchByName(String keyword) {
        ArrayList<Student> results;
        results = new ArrayList<>();
        for (int i = 0; i < enrolledStudents.size(); i++) {
            if (enrolledStudents.get(i).getname().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(enrolledStudents.get(i));
            }
            for (int a = 0; i < probationList.size(); a++) {

                if (probationList.get(a).getname().toLowerCase().contains(keyword.toLowerCase())) {
                    results.add(probationList.get(a));
                }
            }

        }
        System.out.println(results);
    }
}

class GpaComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s1.getgpa(), s2.getgpa());

    }
}



