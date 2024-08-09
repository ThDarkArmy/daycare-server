package tda.darkarmy.daycare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tda.darkarmy.daycare.exception.ResourceNotFoundException;
import tda.darkarmy.daycare.model.FeePayment;
import tda.darkarmy.daycare.model.Kid;
import tda.darkarmy.daycare.repository.FeePaymentRepository;
import tda.darkarmy.daycare.repository.KidRepository;

import java.util.Date;
import java.util.List;

@Service
public class FeePaymentService {
    @Autowired
    private FeePaymentRepository feePaymentRepository;
    @Autowired
    private KidRepository kidRepository;

    public List<FeePayment> getAll(){
        return feePaymentRepository.findAll();
    }

    public List<FeePayment> getByKid(Long id){
        Kid kid = kidRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Kid not found"));
        return feePaymentRepository.findByKid(kid);
    }

    public FeePayment payFee(FeePayment feePayment, Long kidId){
        Kid kid = kidRepository.findById(kidId).orElseThrow(()-> new ResourceNotFoundException("Kid not found"));
        feePayment.setKid(kid);
        feePayment.setPaymentDate(new Date().toString());
        return feePaymentRepository.save(feePayment);
    }
}
