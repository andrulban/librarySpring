package com.andruha.service.interfaces;

import org.springframework.stereotype.Service;

/**
 * Created by andrusha on 19.06.17.
 */
@Service
public interface AuthorService {
    String getNameById(long id);
}
