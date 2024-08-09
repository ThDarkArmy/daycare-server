package tda.darkarmy.daycare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tda.darkarmy.daycare.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
