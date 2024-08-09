package tda.darkarmy.daycare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Kid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String sex;
    private String address;
    private String contact;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // Parent

    @OneToMany(mappedBy = "kid", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<FeePayment> feePayments = new HashSet<>();

    public Kid() {
    }

    public Kid(Long id, String name, Integer age, String sex, String address, String contact, User user, Set<FeePayment> feePayments) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.contact = contact;
        this.user = user;
        this.feePayments = feePayments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<FeePayment> getFeePayments() {
        return feePayments;
    }

    public void setFeePayments(Set<FeePayment> feePayments) {
        this.feePayments = feePayments;
    }

    @Override
    public String toString() {
        return "Kid{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", user=" + user +
                ", feePayments=" + feePayments +
                '}';
    }
}
