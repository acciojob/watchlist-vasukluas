package com.driver;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MovieSerivce {

   @Autowired

   MovieRepository movieRepository;
    public void addMovie(Movie movie) {
        movieRepository.saveMovie(movie);
    }

    public void addDirector(Director director) {
        movieRepository.saveDirector(director);
    }

    public void createMovieDirectorPair(String movie, String director) {
        if(Objects.nonNull(movieRepository.findMovie(movie))&&Objects.nonNull(movieRepository.findDirector(director))){
            movieRepository.saveMovieDirectorPair(movie,director);
        }
        movieRepository.saveMovieDirectorPair(movie,director);
    }

    public Movie findMovie(String movieName) {
        return (Movie) movieRepository.findMovie(movieName);
    }

    public Director findDirector(String DirectorName) {
        return (Director) movieRepository.findDirector(DirectorName);
    }

    public List<String> findMoviesfromDirector(String director) {
        return movieRepository.findMoviesFromDirector(director);
    }

    public List<String> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public void deleteDirector(String director) {
        List<String> movies=new ArrayList<>();
        List<String> moviesToDelete=movieRepository.findMoviesFromDirector(director);
        movieRepository.removeDirector(director);
        for(String moviename:moviesToDelete){
            movieRepository.removeMovies(moviename);
        }
    }

    public void deleteAllDirectors() {
        List<String> directors=movieRepository.getAllDirectors();
        for(String directorName:directors){
            deleteDirector(directorName);
        }

    }
}
