package com.BookStore.App.Service.Impl;

import com.BookStore.App.Model.Publisher;
import com.BookStore.App.Repository.PublisherRepository;
import com.BookStore.App.Service.PublisherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public List<Publisher> getAllPublishers() {
        // Use JPA's built-in findAll method
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getPublisherById(int id) {
        // Handle Optional to avoid exceptions
        return publisherRepository.findById(id).orElse(null);
    }

    @Override
    public Publisher addPublisher(Publisher publisher) {
        // Save the new publisher
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher updatePublisher(int id, Publisher publisher) {
        // Ensure the publisher exists
        Publisher existingPublisher = publisherRepository.findById(id).orElse(null);

        // Update fields as necessary
        existingPublisher.setFirstName(publisher.getFirstName());
        existingPublisher.setLastName(publisher.getLastName());
        existingPublisher.setAddress(publisher.getAddress());

        // Save updated publisher
        return publisherRepository.save(existingPublisher);
    }

    @Override
    public void deletePublisher(int id) {
        publisherRepository.deleteById(id);
    }
}
