package tda.darkarmy.daycare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tda.darkarmy.daycare.model.DayCare;
import tda.darkarmy.daycare.model.User;

public interface DayCareRepository extends JpaRepository<DayCare, Long> {
    @Query("SELECT d FROM DayCare d WHERE d.user = :user")
    DayCare findByUser(User user);
}
