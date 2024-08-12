package tda.darkarmy.daycare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String comment;
    private Integer rating;
    private String reviewDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "daycare_id")
    private DayCare dayCare;

    public Review() {
    }

    public Review(Long id, String name, String comment, Integer rating, String reviewDate) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.rating = rating;
        this.reviewDate = reviewDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DayCare getDayCare() {
        return dayCare;
    }

    public void setDayCare(DayCare dayCare) {
        this.dayCare = dayCare;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", rating=" + rating +
                ", reviewDate='" + reviewDate + '\'' +
                '}';
    }
}
