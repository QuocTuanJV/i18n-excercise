package com.tuanlq.midexam.repositories;

import com.tuanlq.midexam.model.Book;
import com.tuanlq.midexam.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.domain.Pageable;

public interface BookRepository extends PagingAndSortingRepository<Book,Long> {
    Iterable<Book> findAllByCategory(Category category);
    Page<Book> findAllByNameContaining(String name, Pageable pageable);
}
