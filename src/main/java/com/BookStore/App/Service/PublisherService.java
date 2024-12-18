package com.BookStore.App.Service;

import com.BookStore.App.Model.Publisher;
import com.BookStore.App.Service.Exception.AddressNotFoundException;

import java.util.List;

public interface PublisherService {

    List<Publisher> getAllPublishers();

    Publisher getPublisherById(int id);

    Publisher addPublisher(Publisher publisher, int addressId) throws AddressNotFoundException;

    Publisher updatePublisher(int id, Publisher publisher);

    void deletePublisher(int id);
}
