package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.codec.StringDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieSerivce movieSerivce;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieSerivce.addMovie(movie);
        return new ResponseEntity<>("New movie added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieSerivce.addDirector(director);
        return new ResponseEntity<>("New director added successfully",HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie,@RequestParam("director") String director){
        movieSerivce.createMovieDirectorPair(movie,director);
        return new ResponseEntity<>("New movie-director pair added successfully",HttpStatus.CREATED);
    }
   @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movie=movieSerivce.findMovie(name);
        return new ResponseEntity<>(movie,HttpStatus.OK);
   }

   @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director=movieSerivce.findDirector(name);
        return new ResponseEntity<>(director,HttpStatus.OK);
   }

   @GetMapping("/get-movies-by-director-name/{director}")

    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
      List<String> movies=movieSerivce.findMoviesfromDirector(director);
      return new ResponseEntity<>(movies,HttpStatus.OK);
   }
   @GetMapping("/get-all-movies")

    public ResponseEntity<List<String>> getAllMovies(){
        List<String> movies=movieSerivce.findAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.OK);
   }
   @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
        movieSerivce.deleteDirector(director);
        return new ResponseEntity<>(director+" removed successfully",HttpStatus.OK);
   }
   @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieSerivce.deleteAllDirectors();
        return new ResponseEntity<>("All directors deleted successfully",HttpStatus.OK);
   }
}
