package com.vanannek.companycrud.service.impl;

import com.vanannek.companycrud.entity.Milestone;
import com.vanannek.companycrud.repository.MilestoneRepository;
import com.vanannek.companycrud.service.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MilestoneServiceImpl implements MilestoneService {

    @Autowired
    private MilestoneRepository repos;

    @Override
    public Milestone addMst(Milestone mst) {
        try {
            return repos.save(mst);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteMst(Long id) {
        Optional<Milestone> optMst = repos.findById(id);

        if(optMst.isEmpty())
            return false;

        try {
            Milestone mst = optMst.get();
            repos.delete(mst);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteByProjID(Long projId) {
        List<Milestone> lstMiles = repos.findByProjId(projId);

        if(lstMiles.isEmpty())
            return false;

        try {
            lstMiles.stream().forEach(miles -> repos.delete(miles));
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Milestone updateMst(Long id, Milestone mst) {
        repos
            .findById(id)
            .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, ("Invalid milestone id = " + id)));
        mst.setId(id);
        return  repos.save(mst);
    }

    @Override
    public Milestone getMst(Long id) {
        return repos
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, ("Invalid milestone id = " + id)));
    }

    @Override
    public List<Milestone> findByProjectID(Long projId) {
        return repos.findByProjId(projId);
    }
}
