package tda.darkarmy.daycare.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tda.darkarmy.daycare.model.Kid;
import tda.darkarmy.daycare.model.User;

import java.util.List;

public interface KidRepository extends JpaRepository<Kid, Long> {
    List<Kid> findByUser(User user);
}
