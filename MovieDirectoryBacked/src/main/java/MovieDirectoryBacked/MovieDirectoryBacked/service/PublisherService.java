package MovieDirectoryBacked.MovieDirectoryBacked.service;


import MovieDirectoryBacked.MovieDirectoryBacked.dto.PublisherDTO;
import MovieDirectoryBacked.MovieDirectoryBacked.model.Publisher;
import MovieDirectoryBacked.MovieDirectoryBacked.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    @Autowired
    PublisherRepository publisherRepository;

    public PublisherDTO getPublisherById(Long id){
        Publisher publisher=publisherRepository.findById(id).orElseThrow(()->new RuntimeException("Publisher not found"));
        return new PublisherDTO(publisher.getId(), publisher.getName(), publisher.getContactInfo());
    }
    public void deletePublisher(Long id){
        publisherRepository.deleteById(id);
    }
    public Publisher addPublisher(Publisher publisher){
       return publisherRepository.save(publisher);
    }
}
