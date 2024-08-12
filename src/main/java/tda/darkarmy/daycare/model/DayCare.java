package tda.darkarmy.daycare.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class DayCare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String fullAddress;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String aboutUs;
    private String contactNumber;
    private Integer lowerAgeLimit;
    private Integer higherAgeLimit;
    private Long registrationFee=500l;

    private String imagePath;

    @OneToMany(mappedBy = "dayCare", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Kid> kids = new HashSet<>();

    @OneToMany(mappedBy = "dayCare", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Activity> activities = new HashSet<>();

    @OneToMany(mappedBy = "dayCare", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Review> reviews = new HashSet<>();

    @OneToOne(mappedBy = "dayCare", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    public DayCare() {
    }

    public DayCare(Long id, String name, String city, String fullAddress, String aboutUs, String contactNumber, Integer lowerAgeLimit, Integer higherAgeLimit, Long registrationFee, String imagePath, User user) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.fullAddress = fullAddress;
        this.aboutUs = aboutUs;
        this.contactNumber = contactNumber;
        this.lowerAgeLimit = lowerAgeLimit;
        this.higherAgeLimit = higherAgeLimit;
        this.registrationFee = registrationFee;
        this.imagePath = imagePath;
        this.user = user;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public Integer getLowerAgeLimit() {
        return lowerAgeLimit;
    }

    public void setLowerAgeLimit(Integer lowerAgeLimit) {
        this.lowerAgeLimit = lowerAgeLimit;
    }

    public Integer getHigherAgeLimit() {
        return higherAgeLimit;
    }

    public void setHigherAgeLimit(Integer higherAgeLimit) {
        this.higherAgeLimit = higherAgeLimit;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Set<Kid> getKids() {
        return kids;
    }

    public void setKids(Set<Kid> kids) {
        this.kids = kids;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(Long registrationFee) {
        this.registrationFee = registrationFee;
    }

    public String getAboutUs() {
        return aboutUs;
    }

    public void setAboutUs(String aboutUs) {
        this.aboutUs = aboutUs;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "DayCare{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                ", aboutUs='" + aboutUs + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", lowerAgeLimit=" + lowerAgeLimit +
                ", higherAgeLimit=" + higherAgeLimit +
                ", registrationFee=" + registrationFee +
                ", imagePath='" + imagePath + '\'' +
                ", kids=" + kids +
                ", activities=" + activities +
                ", reviews=" + reviews +
                ", user=" + user +
                '}';
    }
}
