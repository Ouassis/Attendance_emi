package com.example.modal;

public class Subject {
    private String id;
    private String name;
    private Teacher teacher;
    private Classes classes;

    public Subject(String name, Teacher teacher, Classes classes) {
        this.name = name;
        this.teacher = teacher;
        this.classes = classes;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
