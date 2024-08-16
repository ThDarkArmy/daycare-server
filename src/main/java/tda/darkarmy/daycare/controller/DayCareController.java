package tda.darkarmy.daycare.controller;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tda.darkarmy.daycare.dto.DayCareDto;
import tda.darkarmy.daycare.service.DayCareService;

import java.io.IOException;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/v1/daycare")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DayCareController {
    @Autowired
    private DayCareService dayCareService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return status(200).body(dayCareService.getAll());
    }

    @GetMapping("/my-daycare/{id}")
    public ResponseEntity<?> getMyDaycare(@PathVariable Long id){
        return status(200).body(dayCareService.getMyDaycare(id));
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return status(200).body(dayCareService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@ModelAttribute DayCareDto dayCareDto) throws MessagingException, IOException {
        return status(200).body(dayCareService.save(dayCareDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return status(200).body(dayCareService.delete(id));
    }

}
