package com.andruha.service.implementations;

import com.andruha.model.entity.Publisher;
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

    /**
     * It downloads publisher's name by id.
     * @param id
     * @return
     */
    @Override
    public String getPublisherNameById(long id) {
        return publisherRepository.findOne(id).getNameP();
    }

    @Override
    public Publisher getPublisherByName(String name) {
        return publisherRepository.findPublisherByNameP(name);
    }

    @Override
    public Long getIdByName(String name) {
        return publisherRepository.getIdByName(name);
    }
}
