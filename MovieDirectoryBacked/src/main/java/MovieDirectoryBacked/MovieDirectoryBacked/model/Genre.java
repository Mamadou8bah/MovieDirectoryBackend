package MovieDirectoryBacked.MovieDirectoryBacked.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Genre {

    @Id
    private long id;
    @Column(nullable = false)
    private String name;
    private String description;

    private List<Movie>movies;



}
