package com.example.modal;

import java.util.Date;

public class Session {
    private String id;
    private String qrCode;
    private Date date;
    private Subject subject;

    public Session(String qrCode, Date date, Subject subject) {
        this.qrCode = qrCode;
        this.date = date;
        this.subject = subject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
