package com.tuanlq.midexam.repositories;

import com.tuanlq.midexam.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
