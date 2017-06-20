package com.andruha.service.implementations;

import com.andruha.repository.PublisherRepository;
import com.andruha.service.interfaces.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by andrusha on 20.06.17.
 */
@Service
public class PublisherServiceImpl implements PublisherService {

    private PublisherRepository publisherRepository;

    @Autowired
    public void setPublisherRepository(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public String getPublisherNameById(long id) {
        return publisherRepository.findOne(id).getPublisherName();
    }
}
