package com.alibaba.dao;

import com.alibaba.entities.MissionAssignments;

import java.util.List;

public interface MissionEmployeeDAO {
    void MissionEmployee(MissionAssignments missionAssignments);
    List<MissionAssignments> getMissionEmployee(int matricule);
}
