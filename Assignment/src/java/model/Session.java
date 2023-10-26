/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.ArrayList;
/**
 *
 * @author DUC
 */
public class Session {
    private int seid;
    private Group group;
    private int index;
    private Date date;
    private Instructor instructor;
    private Room room;
    private Subject subject;
    private TimeSlot time;
    private boolean isAtt;
    private ArrayList<Attendance> attlist = new ArrayList<>();

    public Session() {
    }

    public Session(int seid, Group group, int index, Date date, Instructor instructor, Room room, Subject subject, TimeSlot time, boolean isAtt) {
        this.seid = seid;
        this.group = group;
        this.index = index;
        this.date = date;
        this.instructor = instructor;
        this.room = room;
        this.subject = subject;
        this.time = time;
        this.isAtt = isAtt;
    }

    public ArrayList<Attendance> getAttlist() {
        return attlist;
    }

    public void setAttlist(ArrayList<Attendance> attlist) {
        this.attlist = attlist;
    }

    public boolean isIsAtt() {
        return isAtt;
    }

    public void setIsAtt(boolean isAtt) {
        this.isAtt = isAtt;
    }

    public int getSeid() {
        return seid;
    }

    public void setSeid(int seid) {
        this.seid = seid;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public TimeSlot getTime() {
        return time;
    }

    public void setTime(TimeSlot time) {
        this.time = time;
    }
    
}
