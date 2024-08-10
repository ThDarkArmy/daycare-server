package tda.darkarmy.daycare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String time;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "daycare_id")
    private DayCare dayCare;

    public Activity() {
    }

    public Activity(Long id, String title, String description, String time) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public DayCare getDayCare() {
        return dayCare;
    }

    public void setDayCare(DayCare dayCare) {
        this.dayCare = dayCare;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", topic='" + title + '\'' +
                ", description='" + description + '\'' +
                ", timing='" + time + '\'' +
                '}';
    }
}
