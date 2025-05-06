package MovieDirectoryBacked.MovieDirectoryBacked.repository;

import MovieDirectoryBacked.MovieDirectoryBacked.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
