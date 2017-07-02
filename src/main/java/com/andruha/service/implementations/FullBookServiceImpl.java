package com.andruha.service.implementations;

import com.andruha.model.entity.FullBook;
import com.andruha.repository.FullBookRepository;
import com.andruha.service.interfaces.FullBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andrusha on 24.06.17.
 */
@Service
public class FullBookServiceImpl implements FullBookService {
    private FullBookRepository fullBookRepository;

    @Autowired
    public void setFullBookRepository(FullBookRepository fullBookRepository) {
        this.fullBookRepository = fullBookRepository;
    }

    @Override
    public void createFullBook(FullBook fullBook) {
        fullBookRepository.save(fullBook);
    }

    @Override
    public void editFullBook(FullBook fullBook) {
        FullBook dbFullBook = fullBookRepository.findOne(fullBook.getId());
        dbFullBook.setPageCount(fullBook.getPageCount());
        dbFullBook.setAuthor_id(fullBook.getAuthor_id());
        dbFullBook.setGenre_id(fullBook.getGenre_id());
        dbFullBook.setId(fullBook.getId());
        dbFullBook.setIsbn(fullBook.getIsbn());
        dbFullBook.setName(fullBook.getName());
        dbFullBook.setPublisher_id(fullBook.getPublisher_id());
        dbFullBook.setPublishYear(fullBook.getPublishYear());
        dbFullBook.setImage(fullBook.getImage());
        dbFullBook.setContent(fullBook.getContent());
        fullBookRepository.saveAndFlush(fullBook);
    }

    @Override
    public FullBook getFullBook(long id) {
        return fullBookRepository.findOne(id);
    }

    @Override
    public List<FullBook> getAll() {
        return fullBookRepository.findAll();
    }
}
