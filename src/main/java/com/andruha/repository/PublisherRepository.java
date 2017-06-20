package com.andruha.repository;

import com.andruha.model.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by andrusha on 20.06.17.
 */
@Service
/**
 * Just a repository of publishers.
 */
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
