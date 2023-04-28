package com.driver;

public class Director {
    private String name;
    private int numberOfMovies;
    private double imdb;

    public Director(String name, int numberOfMovies, double imdb) {
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdb = imdb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }
}
