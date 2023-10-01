package com.alibaba.controller;

import com.alibaba.entities.Account;
import com.alibaba.entities.Employee;
import com.alibaba.entities.Mission;
import com.alibaba.entities.MissionAssignments;
import com.alibaba.service.MissionAssignmentsDAOImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class MissionAssignmentsController {

    MissionAssignments missionAssignments = new MissionAssignments();
    MissionController missionController = new MissionController();
    MissionAssignmentsDAOImpl missionAssignmentsDAO = new MissionAssignmentsDAOImpl();
    public void addMissionOpmloyee(LocalDateTime startDate){
        Scanner sc = new Scanner(System.in);
        System.out.println("save mission");
        System.out.println("Enter Matricule Employee :");
        int matricule = sc.nextInt();

        missionController.AllMission();
        System.out.println("Enter Code mission");
        int code = sc.nextInt();

        LocalDateTime EndDate = LocalDateTime.now();

        missionAssignments.setStartDate(startDate);
        missionAssignments.setEndDate(EndDate);
        Employee employee = new Employee();
        employee.setMatricule(matricule);
        missionAssignments.setEmployee(employee);
        Mission mission = new Mission();
        mission.setCode(code);
        missionAssignments.setMission(mission);

        missionAssignmentsDAO.MissionEmployee(missionAssignments);
    }

    public void getMissionByEmployee(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number Account");
        int matricule = sc.nextInt();

        List<MissionAssignments> assignments = missionAssignmentsDAO.getMissionEmployee(matricule);
        for(MissionAssignments assignments1 : assignments){
            System.out.println(assignments1.getMission().getName()+" | "+assignments1.getStartDate()+" | "+assignments1.getEndDate()+" | "+assignments1.getEmployee().getMatricule()+" | "+assignments1.getMission().getCode());
        }
    }

}
