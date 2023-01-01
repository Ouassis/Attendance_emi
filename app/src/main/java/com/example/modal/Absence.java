package com.example.modal;

import java.util.Date;

public class Absence {
    private String id;
    private Student student;
    private Session session;
    private boolean isAbsent;
    private Date date;

    public Absence(Student student, Session session, boolean isAbsent, Date date) {
        this.student = student;
        this.session = session;
        this.isAbsent = isAbsent;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public boolean isAbsent() {
        return isAbsent;
    }

    public void setAbsent(boolean absent) {
        isAbsent = absent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
