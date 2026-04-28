package com.company;

import java.util.Date;

public class Teacher {
    private int id;
    private String name;
    private String password;
    private String course;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Task createTask(int id, String name, String text, String group, Date begin, Date end) {
        Task newTask = new Task();
        newTask.setId(id);
        newTask.setBegin(begin);
        newTask.setGroup(group);
        newTask.setEnd(end);
        newTask.setText(text);
        newTask.setName(name);
        return newTask;
    }

    public Response markTask(Response response, String result, String comment, Date date, String studentName) {
        Response teacherResponse = new Response();
        // ВАЖНО: берем ID задачи из ответа и НЕ затираем его ID учителя
        teacherResponse.setIdTask(response.getIdTask());
        teacherResponse.setResult(result);
        teacherResponse.setComments(comment);
        teacherResponse.setStudentName(studentName);
        teacherResponse.setTeacherName(this.name);
        teacherResponse.setResponseDate(date);
        return teacherResponse;
    }
}
