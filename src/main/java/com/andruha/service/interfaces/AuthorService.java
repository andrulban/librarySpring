package com.andruha.service.interfaces;


import com.andruha.model.entity.Author;

/**
 * Created by andrusha on 19.06.17.
 */
public interface AuthorService {
    String getNameById(long id);
    Author getAuthorByName(String name);
    Long getIdByName(String name);
}
