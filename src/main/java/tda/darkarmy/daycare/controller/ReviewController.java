package tda.darkarmy.daycare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tda.darkarmy.daycare.model.Review;
import tda.darkarmy.daycare.service.ReviewService;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return status(200).body(reviewService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Review review){
        return status(200).body(reviewService.add(review));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Review review){
        return status(200).body(reviewService.update(id, review));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return status(200).body(reviewService.delete(id));
    }
}
