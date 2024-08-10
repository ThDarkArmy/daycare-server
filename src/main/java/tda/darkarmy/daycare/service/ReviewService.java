package tda.darkarmy.daycare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tda.darkarmy.daycare.exception.ResourceNotFoundException;
import tda.darkarmy.daycare.model.DayCare;
import tda.darkarmy.daycare.model.Review;
import tda.darkarmy.daycare.repository.DayCareRepository;
import tda.darkarmy.daycare.repository.ReviewRepository;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private DayCareRepository dayCareRepository;

    public List<Review> getAll(){
        return reviewRepository.findAll();
    }

    public Review add(Long dayCareId, Review review){
        DayCare dayCare = dayCareRepository.findById(dayCareId).orElseThrow(()-> new ResourceNotFoundException("DayCare not found"));
        review.setDayCare(dayCare);
        review.setReviewDate(new Date().toString());
        return reviewRepository.save(review);
    }

    public Review update(Long id, Review review){
        reviewRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Review not found"));
        review.setId(id);
        return reviewRepository.save(review);
    }

    public String delete(Long id){
        reviewRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Review not found"));
        reviewRepository.deleteById(id);
        return "Review deleted successfully";
    }

    public List<Review> getByDaycare(Long id) {
        return null;
    }
}
