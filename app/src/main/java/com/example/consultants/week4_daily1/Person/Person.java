package com.example.consultants.week4_daily1.Person;

public class Person {
    String nationality;
    String first;
    String last;
    String gender;
    String title;

    public Person(String nationality, String first, String last, String gender, String title) {
        this.nationality = nationality;
        this.first = first;
        this.last = last;
        this.gender = gender;
        this.title = title;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Person{" +
                "title='" + title + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
