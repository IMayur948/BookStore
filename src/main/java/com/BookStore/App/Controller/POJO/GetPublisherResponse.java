package com.BookStore.App.Controller.POJO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPublisherResponse {

	List<PublisherResponse> publisherResponse;
	 
}