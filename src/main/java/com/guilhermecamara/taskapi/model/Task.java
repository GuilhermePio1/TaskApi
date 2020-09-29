package com.guilhermecamara.taskapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    private String title;
    private String details;

    @NotBlank
    private Boolean isAllDay;

    @NotBlank
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime firstTime;

    private String repeat;

    @ManyToOne
    @JoinColumn(name = "usert_id", nullable = false)
    private UserT userT;

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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Boolean getAllDay() {
        return isAllDay;
    }

    public void setAllDay(Boolean allDay) {
        isAllDay = allDay;
    }

    public LocalDateTime getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(LocalDateTime firstTime) {
        this.firstTime = firstTime;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public UserT getUserT() {
        return userT;
    }

    public void setUserT(UserT userT) {
        this.userT = userT;
    }

}
