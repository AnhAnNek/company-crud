package com.vanannek.companycrud.service;

import com.vanannek.companycrud.entity.Milestone;

import java.util.List;

public interface MilestoneService {

    Milestone addMst(Milestone mst);
    boolean deleteMst(Long id);
    boolean deleteByProjID(Long projId);
    Milestone updateMst(Long id, Milestone mst);
    Milestone getMst(Long id);
    List<Milestone> findByProjectID(Long projId);
}
