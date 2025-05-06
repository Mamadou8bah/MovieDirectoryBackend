package MovieDirectoryBacked.MovieDirectoryBacked.repository;

import MovieDirectoryBacked.MovieDirectoryBacked.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {
}
