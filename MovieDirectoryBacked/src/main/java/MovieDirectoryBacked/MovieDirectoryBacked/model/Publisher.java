package MovieDirectoryBacked.MovieDirectoryBacked.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Publisher {
    @Id
    private long id;
    private String name;
    private String contactInfo;
    @OneToMany(mappedBy = "publisher",cascade = CascadeType.ALL)
    private List<Movie>movies;

}
