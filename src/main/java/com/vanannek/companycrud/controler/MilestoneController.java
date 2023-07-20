package com.vanannek.companycrud.controler;

import com.vanannek.companycrud.entity.Milestone;
import com.vanannek.companycrud.service.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/milestone")
public class MilestoneController {

    @Autowired
    private MilestoneService mstService;

    @PostMapping("/add")
    public String addMst(@RequestBody Milestone mst) {
        mstService.addMst(mst);
        return "success add milestone";
    }

    @DeleteMapping("/delete-by-mst")
    public ResponseEntity<Void> deleteMst(@RequestParam Long id) {
        mstService.deleteMst(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete-by-proj-id")
    public ResponseEntity<Void> deleteByProjectID(@RequestParam Long projId) {
        mstService.deleteByProjID(projId);
        return  ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateMst(@RequestParam Long id, @RequestBody Milestone mst) {
        mstService.updateMst(id, mst);
            return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-by-mst")
    public Milestone getMst(@RequestParam Long id) { return mstService.getMst(id); }

    @GetMapping("/get-by-proj-id")
    public List<Milestone> getByProjectID(@RequestParam Long projId) { return mstService.findByProjectID(projId); }
}
