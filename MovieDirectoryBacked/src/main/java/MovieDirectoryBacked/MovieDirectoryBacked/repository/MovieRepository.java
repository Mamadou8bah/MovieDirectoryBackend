package MovieDirectoryBacked.MovieDirectoryBacked.repository;

import MovieDirectoryBacked.MovieDirectoryBacked.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByGenre_Title(String genre);

    List<Movie> findByTitleContainingIgnoreCase(String query);
}
