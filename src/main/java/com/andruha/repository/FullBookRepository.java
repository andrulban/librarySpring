package com.andruha.repository;

import com.andruha.model.entity.FullBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by andrusha on 24.06.17.
 */
@Service
public interface FullBookRepository extends JpaRepository<FullBook, Long> {


}
