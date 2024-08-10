package tda.darkarmy.daycare.dto;

import org.springframework.web.multipart.MultipartFile;

public class DayCareDto {
    private String name;
    private String city;
    private String fullAddress;
    private Integer lowerAgeLimit;
    private Integer higherAgeLimit;
    private Long registrationFee=500l;
    private String aboutUs;
    private String contactNumber;

    private MultipartFile image;

    public DayCareDto() {
    }

    public DayCareDto(String name, String city, String fullAddress, Integer lowerAgeLimit, Integer higherAgeLimit, Long registrationFee, String aboutUs, String contactNumber, MultipartFile image) {
        this.name = name;
        this.city = city;
        this.fullAddress = fullAddress;
        this.lowerAgeLimit = lowerAgeLimit;
        this.higherAgeLimit = higherAgeLimit;
        this.registrationFee = registrationFee;
        this.aboutUs = aboutUs;
        this.contactNumber = contactNumber;
        this.image = image;
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

    public Long getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(Long registrationFee) {
        this.registrationFee = registrationFee;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
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
        return "DayCareDto{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                ", lowerAgeLimit=" + lowerAgeLimit +
                ", higherAgeLimit=" + higherAgeLimit +
                ", registrationFee=" + registrationFee +
                ", aboutUs='" + aboutUs + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", image=" + image +
                '}';
    }
}
