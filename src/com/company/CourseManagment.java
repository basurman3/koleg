package com.company;

import java.util.ArrayList;
import java.util.Date;

public class CourseManagment {
    // Делаем public, чтобы Main мог их видеть (исправляет ошибку private access)
    public ArrayList<Student> students = new ArrayList<>();
    public ArrayList<Teacher> teachers = new ArrayList<>();
    public ArrayList<Task> tasks = new ArrayList<>();
    public ArrayList<Response> responses = new ArrayList<>();
    public ArrayList<Response> marks = new ArrayList<>();

    private Admin admin = new Admin();

    public void adminCreateTeacher(String name, String course, String password) {
        Teacher t = admin.createTeacher(name, course, password);
        if (t != null) {
            teachers.add(t);
        }
    }

    public void adminCreateStudent(String name, String group, String password) {
        Student s = admin.createStudent(name, group, password);
        if (s != null) {
            students.add(s);
        }
    }

    public void teacherCreateTask(Teacher teacher, int id, String name, String text, String group, Date begin, Date end) {
        tasks.add(teacher.createTask(id, name, text, group, begin, end));
    }

    public void teacherRateTask(Teacher teacher, Response response, String result, String comment, Date date, String studentName) {
        marks.add(teacher.markTask(response, result, comment, date, studentName));
    }

    public void studentResponseToTask(Student student, Task task, int id, String text, Date date) {
        responses.add(student.responseToTask(task, text, date));
    }

    public void printStudents() {
        for (Student s : students) {
            System.out.println(s.getId_ST() + " " + s.getName() + " " + s.getGroup());
        }
    }

    public void printTeachers() {
        for (Teacher t : teachers) {
            System.out.println(t.getId() + " " + t.getName() + " " + t.getCourse());
        }
    }

    public void printTasks() {
        for (Task t : tasks) {
            System.out.println("Задача ID: " + t.getId() + " | Название: " + t.getName() + " | Группа: " + t.getGroup());
        }
    }

    public void printResponses() {
        for (Response r : responses) {
            System.out.println("Ответ на задачу ID: " + r.getIdTask() + " | От студента: " + r.getStudentName());
        }
    }

    public void printMarks() {
        for (Response m : marks) {
            System.out.println("Студент: " + m.getStudentName() + " | Оценка: " + m.getResult() + " | Коммент: " + m.getComments());
        }
    }
}

