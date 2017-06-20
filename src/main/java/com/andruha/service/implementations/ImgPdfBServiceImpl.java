package com.andruha.service.implementations;

import com.andruha.repository.ImgPdfBRepository;
import com.andruha.service.interfaces.ImgPdfBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by andrusha on 20.06.17.
 */
@Service
public class ImgPdfBServiceImpl implements ImgPdfBService {
    private ImgPdfBRepository imgPdfBRepository;

    @Autowired
    public void setImgPdfBRepository(ImgPdfBRepository imgPdfBRepository) {
        this.imgPdfBRepository = imgPdfBRepository;
    }


    @Override
    public byte[] getImageByBookId(long id) {
        return imgPdfBRepository.findImgPdfBById(id).getImage();
    }

    @Override
    public byte[] getContentByBookId(long id) {
        return imgPdfBRepository.findImgPdfBById(id).getContent();
    }
}
