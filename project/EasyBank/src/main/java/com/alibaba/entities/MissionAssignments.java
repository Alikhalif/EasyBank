package com.alibaba.entities;

import java.util.Date;

public class MissionAssignments {
    private Date startDate;
    private Date endDate;
    private Employee employee;
    private Mission mission;


    public MissionAssignments(Date startDate, Date endDate, Employee employee, Mission mission) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
        this.mission = mission;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }


    @Override
    public String toString() {
        return "MissionAssignments{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", employee=" + employee +
                ", mission=" + mission +
                '}';
    }
}
