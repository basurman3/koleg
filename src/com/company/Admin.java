package com.company;

import java.util.ArrayList;

public class Admin {
    private static int studentCounter = 0;
    private static int teacherCounter = 0;

    public static int getStudentCounter() {
        return studentCounter;
    }

    public static int getTeacherCounter() {
        return teacherCounter;
    }

    public Student createStudent(String name, String group, String password) {
        // Проверка: имя не пустое и содержит только буквы латиницы
        if (name != null && name.matches("[a-zA-Z]+")) {
            studentCounter++;
            Student newStudent = new Student();
            newStudent.setGroup(group);
            newStudent.setId_ST(studentCounter);
            newStudent.setName(name);
            newStudent.setPassword(password);
            return newStudent;
        }
        // Если имя не прошло проверку, возвращаем null
        System.out.println("Ошибка: Некорректное имя студента.");
        return null;
    }

    public Teacher createTeacher(String name, String course, String password) {
        teacherCounter++;
        Teacher newTeacher = new Teacher();
        newTeacher.setCourse(course);
        newTeacher.setId(teacherCounter);
        newTeacher.setName(name);
        newTeacher.setPassword(password);
        return newTeacher;
    }

    public void delStudent(ArrayList<Student> students, int id, String name) {
        // Элегантный способ удаления по условию без ошибок с индексами
        students.removeIf(student -> student.getId_ST() == id && student.getName().equals(name));
    }

    public void delTeacher(ArrayList<Teacher> teachers, int id, String name) {
        teachers.removeIf(teacher -> teacher.getId() == id && teacher.getName().equals(name));
    }
}
