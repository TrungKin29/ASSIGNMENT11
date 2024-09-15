package Person;

import java.util.ArrayList;

class StudentList {

    private ArrayList<Student> studentList;

    public StudentList() {
        this.studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void deleteStudentById(String id) {
        studentList.removeIf(student -> student.getId().equals(id));
    }

    public Student findStudentByID(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null; // Not found
    }

    public void displayAllStudents() {
        for (Student student : studentList) {
            student.displayInfo();
        }
    }

    public Student findTopStudent() {
        return studentList.stream()
                .max((s1, s2) -> Float.compare(s1.getGpa(), s2.getGpa()))
                .orElse(null);
    }
}
