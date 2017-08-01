package com.andruha.controller.rest;

import com.andruha.service.implementations.PublisherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by andrusha on 01.08.17.
 */
@RestController
public class PublisherRestController {
    private PublisherServiceImpl publisherService;

    @Autowired
    public void setPublisherService(PublisherServiceImpl publisherService) {
        this.publisherService = publisherService;
    }

    /**
     * It downloads publisher name by its id.
     * @param id
     * @return
     */
    @RequestMapping(value = "/publisherName/{id}", method = RequestMethod.GET)
    public String getPublisherName(@PathVariable long id){
        return publisherService.getPublisherNameById(id);
    }

}
