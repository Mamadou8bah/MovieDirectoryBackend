package MovieDirectoryBacked.MovieDirectoryBacked.service;

import MovieDirectoryBacked.MovieDirectoryBacked.dto.MovieDTO;
import MovieDirectoryBacked.MovieDirectoryBacked.model.Movie;
import MovieDirectoryBacked.MovieDirectoryBacked.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository repo;
    public List<MovieDTO> getMovies(){
        List<Movie> movies=repo.findAll();

        List<MovieDTO> movieDTOS=new ArrayList<>();
        for (Movie movie:movies){
            movieDTOS.add(new MovieDTO(movie.getId(), movie.getTitle(), movie.getDescription(), movie.getReleasedYear(), movie.getRating()));

        }
        return movieDTOS;
    }

    public List<MovieDTO> getMoviesByGenre(String genre){
        List<Movie> movies=repo.findAllByGenre_Title(genre);
        List<MovieDTO> movieDTOS=new ArrayList<>();
        for (Movie movie:movies){
            movieDTOS.add(new MovieDTO(movie.getId(), movie.getTitle(), movie.getDescription(), movie.getReleasedYear(), movie.getRating()));
        }
        return movieDTOS;
    }

    public MovieDTO addMovie(Movie movie){
        Movie movie1= repo.save(movie);
        return new MovieDTO(movie1.getId(), movie1.getTitle(), movie1.getDescription(), movie1.getReleasedYear(), movie1.getRating());
    }
    public MovieDTO updateDescription(Long id, String description){
        Movie movie=repo.findById(id).orElseThrow(()->new RuntimeException("Movie not found"));

        movie.setDescription(description);

        return new MovieDTO(movie.getId(), movie.getTitle(), movie.getDescription(), movie.getReleasedYear(), movie.getRating());
    }

    public List<MovieDTO>searchMovies(String query){
        List<Movie> movies=repo.findByTitleContainingIgnoreCase(query);
        List<MovieDTO>movieDTOS=new ArrayList<>();

        for (Movie movie:movies){
            movieDTOS.add(new MovieDTO(movie.getId(), movie.getTitle(), movie.getDescription(), movie.getReleasedYear(), movie.getRating()));
        }
        return movieDTOS;
    }

    public void deleteMovie(Long id){
        Movie movie=repo.findById(id).orElseThrow(()->new RuntimeException("Movie not found"));
        repo.delete(movie);
    }
}
