package tda.darkarmy.daycare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class FeePayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long admissionFee;
    private Long tuitionFee;
    private Long culturalActivityFee;
    private Long otherFee;
    private String category;
    private String status="Paid";
    private String month;
    private Long year;
    private String paymentDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "kid_id")
    private Kid kid;

    public FeePayment() {
    }

    public FeePayment(Long id, Long admissionFee, Long tuitionFee, Long culturalActivityFee, Long otherFee, String category, String status, String month, Long year, String paymentDate) {
        this.id = id;
        this.admissionFee = admissionFee;
        this.tuitionFee = tuitionFee;
        this.culturalActivityFee = culturalActivityFee;
        this.otherFee = otherFee;
        this.category = category;
        this.status = status;
        this.month = month;
        this.year = year;
        this.paymentDate = paymentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdmissionFee() {
        return admissionFee;
    }

    public void setAdmissionFee(Long admissionFee) {
        this.admissionFee = admissionFee;
    }

    public Long getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(Long tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public Long getCulturalActivityFee() {
        return culturalActivityFee;
    }

    public void setCulturalActivityFee(Long culturalActivityFee) {
        this.culturalActivityFee = culturalActivityFee;
    }

    public Long getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(Long otherFee) {
        this.otherFee = otherFee;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Kid getKid() {
        return kid;
    }

    public void setKid(Kid kid) {
        this.kid = kid;
    }

    @Override
    public String toString() {
        return "FeePayment{" +
                "id=" + id +
                ", admissionFee=" + admissionFee +
                ", tuitionFee=" + tuitionFee +
                ", culturalActivityFee=" + culturalActivityFee +
                ", otherFee=" + otherFee +
                ", category='" + category + '\'' +
                ", status=" + status +
                ", month='" + month + '\'' +
                ", year=" + year +
                ", paymentDate='" + paymentDate + '\'' +
                ", kid=" + kid +
                '}';
    }
}
