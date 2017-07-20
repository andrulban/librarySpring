package com.andruha.service.interfaces;

import com.andruha.model.entity.Publisher;
import org.springframework.stereotype.Service;

/**
 * Created by andrusha on 20.06.17.
 */
public interface PublisherService {
    String getPublisherNameById(long id);
    Publisher getPublisherByName(String name);
    Long getIdByName(String name);
}
