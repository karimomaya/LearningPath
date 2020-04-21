package com.learning.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by karim on 4/16/20.
 */
@NoRepositoryBean
public interface GenericRepository<T,IDT> extends PagingAndSortingRepository<T,IDT> {
}
