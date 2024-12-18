package com.BookStore.App.Controller;

import com.BookStore.App.Controller.POJO.PublisherRequest;
import com.BookStore.App.Model.Publisher;
import com.BookStore.App.Service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookStore/api/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    // Convert PublisherRequest to Publisher
    private Publisher convertToPublisher(PublisherRequest publisherRequest) {
        Publisher publisher = new Publisher();
        publisher.setFirstName(publisherRequest.getFirstName());
        publisher.setLastName(publisherRequest.getLastName());
        publisher.setAddress(publisherRequest.getAddress());
        return publisher;
    }

    // Convert Publisher to PublisherRequest
    private PublisherRequest convertToPublisherRequest(Publisher publisher) {
    	PublisherRequest publisherRequest = new PublisherRequest();
    	publisherRequest.setFirstName(publisher.getFirstName());
    	publisherRequest.setLastName(publisher.getLastName());
    	publisherRequest.setAddress(publisher.getAddress());
    	
        return publisherRequest;
    }

    // Convert List<Publisher> to List<PublisherRequest>
    private List<PublisherRequest> convertToPublisherRequestList(List<Publisher> publishers) {
        return publishers.stream().map(this::convertToPublisherRequest).toList();
    }

    // Get all publishers
    @GetMapping("/getAll")
    public ResponseEntity<List<PublisherRequest>> getAllPublishers() {
        List<Publisher> publishers = publisherService.getAllPublishers();
        List<PublisherRequest> publisherRequests = convertToPublisherRequestList(publishers);
        return new ResponseEntity<>(publisherRequests, HttpStatus.OK);
    }

    // Get publisher by ID
    @GetMapping("/{id}")
    public ResponseEntity<PublisherRequest> getPublisher(@PathVariable int id) {
        Publisher publisher = publisherService.getPublisherById(id);
        if (publisher != null) {
            PublisherRequest publisherRequest = convertToPublisherRequest(publisher);
            return new ResponseEntity<>(publisherRequest, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Add new publisher
    @PostMapping("/add")
    public ResponseEntity<String> addPublisher(@RequestBody PublisherRequest publisherRequest) {
        Publisher publisher = convertToPublisher(publisherRequest);
        publisherService.addPublisher(publisher);
        return new ResponseEntity<>("Publisher added successfully", HttpStatus.CREATED);
    }

    // Update publisher
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePublisher(@PathVariable int id, @RequestBody PublisherRequest publisherRequest) {
        Publisher publisher = convertToPublisher(publisherRequest);
        publisherService.updatePublisher(id, publisher);
        return new ResponseEntity<>("Publisher updated successfully", HttpStatus.OK);
    }

    // Delete publisher
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePublisher(@PathVariable int id) {
        publisherService.deletePublisher(id);
        return new ResponseEntity<>("Publisher deleted successfully", HttpStatus.NO_CONTENT);
    }
}
