package com.company;
import java.util.Date;

public class Student {
    private int id_ST;
    private String name, password, group;

    public void setName(String n) { this.name = n; }
    public String getName() { return name; }
    public void setId_ST(int id) { this.id_ST = id; }
    public int getId_ST() { return id_ST; }
    public void setGroup(String g) { this.group = g; }
    public String getGroup() { return group; }
    public void setPassword(String p) { this.password = p; }
    public String getPassword() { return password; }

    public Response responseToTask(Task task, String text, Date date) {
        Response r = new Response();
        r.setIdTask(task.getId());
        r.setResponseText(text);
        r.setStudentName(this.name);
        r.setResponseDate(date);
        return r;
    }
}
