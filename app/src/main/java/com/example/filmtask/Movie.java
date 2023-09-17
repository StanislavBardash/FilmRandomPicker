package com.example.filmtask;

public class Movie {

    private String title;
    private int year;
    private String genre;
    private String country;
    private String director;
    private float score;
    private String description;

    public Movie(String title, int year, String genre, String country, String director, float score, String description) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.country = country;
        this.director = director;
        this.score = score;
        this.description = description;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getCountry() {
        return country;
    }

    public String getDirector() {
        return director;
    }

    public float getScore() {
        return score;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", country='" + country + '\'' +
                ", director='" + director + '\'' +
                ", score=" + score +
                ", description='" + description + '\'' +
                '}';
    }


}