package com.example.prescribe;

public class Medicine {
    private String med_name;
    private String time;
    private String duration;
    private String meal_time;

    public Medicine(String med_name, String time, String duration, String meal_time) {
        this.med_name = med_name;
        this.time = time;
        this.duration = duration;
        this.meal_time = meal_time;
    }

    public String getMed_name() {
        return med_name;
    }

    public void setMed_name(String med_name) {
        this.med_name = med_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getMeal_time() {
        return meal_time;
    }

    public void setMeal_time(String meal_time) {
        this.meal_time = meal_time;
    }

    @Override
    public String toString() {
        return "" + med_name + "  " + time + "  " + duration + "  " + meal_time;
    }
}
