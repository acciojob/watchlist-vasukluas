package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    private HashMap<String,Movie> movieMap;
    private HashMap<String,Director> directorMap;

    private HashMap<String, List<String>> directorMovieMapping;

    public MovieRepository() {
        this.movieMap = new HashMap<String,Movie>();
        this.directorMap=new HashMap<String,Director>();
        this.directorMovieMapping=new HashMap<String,List<String>>();

    }

    public  List<String> getAllDirectors() {
        return new ArrayList<>(directorMap.keySet());
    }

    public void saveMovie(Movie movie) {
     movieMap.put(movie.getName(), movie);
    }

    public void saveDirector(Director director) {
        directorMap.put(director.getName(), director);
    }

    public void saveMovieDirectorPair(String movie, String director) {
     List<String> currentMoviesByDirector=new ArrayList<>();
     if(directorMovieMapping.containsKey(director)){
         currentMoviesByDirector=directorMovieMapping.get(director);
         currentMoviesByDirector.add(movie);

         directorMovieMapping.put(director,currentMoviesByDirector);
     }
    }

    public Object findMovie(String movie) {
        return movieMap.get(movie);
    }

    public Object findDirector(String director) {
        return directorMap.get(director);
    }

    public List<String> findMoviesFromDirector(String director) {
        List<String> movieList=new ArrayList<>();
        if(directorMovieMapping.containsKey(director)){
            movieList=directorMovieMapping.get(director);
        }
        return movieList;
    }

    public List<String> findAllMovies() {
        return new ArrayList<>(movieMap.keySet());
    }


    public void removeDirector(String director) {
        directorMap.remove(director);
        directorMovieMapping.remove(director);
    }

    public void removeMovies(String moviename) {
        movieMap.remove(moviename);
    }
}
