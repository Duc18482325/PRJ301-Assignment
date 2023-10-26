/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author DUC
 */
public class Group {
    private int gid;
    private String name;
    private ArrayList<Student> students = new ArrayList<>();
    private Instructor supervior;
    private Subject subject;

    public Group() {
    }

    public Group(int gid, String name, Instructor supervior, Subject subject) {
        this.gid = gid;
        this.name = name;
        this.supervior = supervior;
        this.subject = subject;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Instructor getSupervior() {
        return supervior;
    }

    public void setSupervior(Instructor supervior) {
        this.supervior = supervior;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    
    
}
