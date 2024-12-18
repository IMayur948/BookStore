package com.BookStore.App.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookStore.App.Model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>  {
	
}
