package tda.darkarmy.daycare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tda.darkarmy.daycare.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
