package com.andruha.service.implementations;

import com.andruha.model.entity.Author;
import com.andruha.repository.AuthorRepository;
import com.andruha.service.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by andrusha on 19.06.17.
 */

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    /**
     * It downloads author name by id.
     * @param id
     * @return
     */
    @Override
    public String getNameById(long id) {
        Author tempAuthor = authorRepository.findOne(id);
        return tempAuthor.getAllNames();
    }
}
