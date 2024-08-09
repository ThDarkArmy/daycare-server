package tda.darkarmy.daycare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tda.darkarmy.daycare.model.Kid;
import tda.darkarmy.daycare.service.KidService;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/v1/kids")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class KidController {
    @Autowired
    private KidService kidService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return status(200).body(kidService.getAll());
    }

    @GetMapping("/my-kids")
    public ResponseEntity<?> getById(){
        return status(200).body(kidService.getMyKids());
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Kid kid){
        return status(200).body(kidService.add(kid));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Kid kid){
        return status(200).body(kidService.update(id, kid));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return status(200).body(kidService.delete(id));
    }
}
