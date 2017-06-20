package com.andruha.service.interfaces;

import org.springframework.stereotype.Service;

/**
 * Created by andrusha on 20.06.17.
 */
@Service
public interface PublisherService {
    String getPublisherNameById(long id);
}
