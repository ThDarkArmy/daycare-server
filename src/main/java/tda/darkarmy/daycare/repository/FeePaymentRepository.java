package tda.darkarmy.daycare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tda.darkarmy.daycare.model.FeePayment;
import tda.darkarmy.daycare.model.Kid;

import java.util.List;

public interface FeePaymentRepository extends JpaRepository<FeePayment, Long> {
    List<FeePayment> findByKid(Kid kid);
}
