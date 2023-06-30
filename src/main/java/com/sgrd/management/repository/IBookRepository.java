package com.sgrd.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgrd.management.model.Book;

public interface IBookRepository extends JpaRepository<Book, Long> {

}
