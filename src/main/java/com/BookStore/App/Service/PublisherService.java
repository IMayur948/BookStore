package com.BookStore.App.Service;

import com.BookStore.App.Model.Publisher;

import java.util.List;

public interface PublisherService {

    List<Publisher> getAllPublishers();

    Publisher getPublisherById(int id);

    Publisher addPublisher(Publisher publisher);

    Publisher updatePublisher(int id, Publisher publisher);

    void deletePublisher(int id);
}
