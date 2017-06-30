package com.andruha.service.interfaces;

import org.springframework.stereotype.Service;

/**
 * Created by andrusha on 20.06.17.
 */
public interface ImgPdfBService {

    byte[] getImageByBookId(long id);
    byte[] getContentByBookId(long id);
}
