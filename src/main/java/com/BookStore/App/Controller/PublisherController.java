package com.BookStore.App.Controller;

import com.BookStore.App.Controller.POJO.GetPublisherResponse;
import com.BookStore.App.Controller.POJO.PublisherRequest;
import com.BookStore.App.Controller.POJO.PublisherResponse;
import com.BookStore.App.Model.Publisher;
import com.BookStore.App.Service.PublisherService;
import com.BookStore.App.Service.Exception.AddressNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookStore/api/publisher")
public class PublisherController {

	@Autowired
	private PublisherService publisherService;

	// Get all publishers
	@GetMapping
	public ResponseEntity<GetPublisherResponse> getAllPublishers() {
		List<Publisher> publishers = publisherService.getAllPublishers();
		List<PublisherResponse> publisherResponseList = publishers.stream()
				.map(publisher -> new PublisherResponse(publisher.getId(), publisher.getFirstName(),
						publisher.getLastName(), publisher.getAddress().getAddressString()))
				.collect(Collectors.toList());

		return new ResponseEntity<>(new GetPublisherResponse(publisherResponseList), HttpStatus.OK);
	}

	// Get publisher by ID
	@GetMapping("/{id}")
	public ResponseEntity<GetPublisherResponse> getPublisher(@PathVariable int id) {
		Publisher newPublisher = publisherService.getPublisherById(id);
		if (newPublisher != null) {

			PublisherResponse publisherResponse = new PublisherResponse(newPublisher.getId(),
					newPublisher.getFirstName(), newPublisher.getLastName(), newPublisher.getAddress().getAddressString());

			List<PublisherResponse> publisherResponseList = Collections.singletonList(publisherResponse);

			return new ResponseEntity<>(new GetPublisherResponse(publisherResponseList), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// Add new publisher
	@PostMapping
	public ResponseEntity<GetPublisherResponse> addPublisher(@RequestBody PublisherRequest publisherRequest) throws AddressNotFoundException {
		Publisher publisher = new Publisher(publisherRequest.getFirstName(), publisherRequest.getLastName(),null);
		Publisher newPublisher = publisherService.addPublisher(publisher, publisherRequest.getAddressId());
		
		PublisherResponse publisherResponse = new PublisherResponse(
				newPublisher.getId(), 
				newPublisher.getFirstName(),
				newPublisher.getLastName(), 
				newPublisher.getAddress().getAddressString());
		List<PublisherResponse> publisherResponseList = Collections.singletonList(publisherResponse);
		return new ResponseEntity<>(new GetPublisherResponse(publisherResponseList), HttpStatus.CREATED);
	}

	// Update publisher
	@PutMapping("/{id}")
	public ResponseEntity<GetPublisherResponse> updatePublisher(@PathVariable int id, @RequestBody PublisherRequest publisherRequest) {
		Publisher publisher = new Publisher(publisherRequest.getFirstName(), publisherRequest.getLastName(),null);

		
		Publisher newPublisher = publisherService.updatePublisher(id, publisher);
		
		PublisherResponse publisherResponse = new PublisherResponse(
				newPublisher.getId(), 
				newPublisher.getFirstName(),
				newPublisher.getLastName(), 
				newPublisher.getAddress().getAddressString());
		
		List<PublisherResponse> publisherResponseList = Collections.singletonList(publisherResponse);
		return new ResponseEntity<>(new GetPublisherResponse(publisherResponseList), HttpStatus.OK);
	}

	// Delete publisher
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePublisher(@PathVariable int id) {
		
		boolean isDeleted = publisherService.deletePublisher(id);
		
		if(isDeleted) {
			return new ResponseEntity<>("Publisher with id " + id + " deleted successfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("Publisher with id : " + id +" not found" , HttpStatus.NOT_FOUND);
	}
}
