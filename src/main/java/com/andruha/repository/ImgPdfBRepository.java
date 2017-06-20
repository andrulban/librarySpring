package com.andruha.repository;

import com.andruha.model.entity.ImgPdfB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by andrusha on 20.06.17.
 */
@Service
/**
 * Just a repository of book's images and contents.
 */
public interface ImgPdfBRepository extends JpaRepository<ImgPdfB,Long> {

    ImgPdfB findImgPdfBById(long id);
}
