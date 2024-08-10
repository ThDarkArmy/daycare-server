package tda.darkarmy.daycare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tda.darkarmy.daycare.model.Activity;
import tda.darkarmy.daycare.service.ActivityService;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/v1/activities")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return status(200).body(activityService.getAll());
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return status(200).body(activityService.getById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> add(@PathVariable Long id, @RequestBody Activity activity){
        return status(200).body(activityService.add(id, activity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Activity activity){
        return status(200).body(activityService.update(id, activity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return status(200).body(activityService.delete(id));
    }
}
