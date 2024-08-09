package tda.darkarmy.daycare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tda.darkarmy.daycare.model.FeePayment;
import tda.darkarmy.daycare.service.FeePaymentService;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/v1/fee-payment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FeePaymentController {
    @Autowired
    private FeePaymentService feePaymentService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return status(200).body(feePaymentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByKid(@PathVariable Long id){
        return status(200).body(feePaymentService.getByKid(id));
    }


    @PostMapping("/{userId}")
    public ResponseEntity<?> add(@RequestBody FeePayment feePayment, @PathVariable Long userId){
        return status(200).body(feePaymentService.payFee(feePayment, userId));
    }
}
