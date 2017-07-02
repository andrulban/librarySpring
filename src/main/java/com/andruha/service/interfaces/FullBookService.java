package com.andruha.service.interfaces;

import com.andruha.model.entity.FullBook;

import java.util.List;

/**
 * Created by andrusha on 24.06.17.
 */
public interface FullBookService {
    void createFullBook(FullBook fullBook);
    void editFullBook (FullBook fullBook);
    FullBook getFullBook(long id);
    List<FullBook> getAll();
}
