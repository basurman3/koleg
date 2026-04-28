package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        CourseManagment cm = new CourseManagment();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        // Даты для задания
        Date dBegin = df.parse("01/10/2023");
        Date dEnd = df.parse("30/10/2023");

        // 1. Админ создает учителя и студента
        cm.adminCreateTeacher("Oleg", "Java Core", "pass123");
        cm.adminCreateStudent("vlad", "AUBP-19-1", "vlad-pass");

        // Достаем их из списков для работы
        Teacher teacher = cm.teachers.get(0);
        Student student = cm.students.get(0);

        // 2. Учитель создает задание (ID задания: 101)
        cm.teacherCreateTask(teacher, 101, "Lab 1", "Write code", "AUBP-19-1", dBegin, dEnd);
        Task task = cm.tasks.get(0);

        // 3. Студент отвечает на это задание
        cm.studentResponseToTask(student, task, 1, "My solution is here", dBegin);
        Response response = cm.responses.get(0);

        // 4. Учитель оценивает ответ студента
        cm.teacherRateTask(teacher, response, "5", "Great work!", dEnd, student.getName());

        // ВЫВОД РЕЗУЛЬТАТОВ
        System.out.println("--- Список Студентов ---");
        cm.printStudents();

        System.out.println("\n--- Оценки за задачи ---");
        cm.printMarks();

        // 5. Тест удаления через админа
        System.out.println("\n--- Удаление студента 'vlad' ---");
        Admin admin = new Admin();
        admin.delStudent(cm.students, 1, "vlad");

        System.out.println("Студентов в системе: " + cm.students.size());
    }
}
