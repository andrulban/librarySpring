package com.andruha.controller;

import com.andruha.service.interfaces.ImgPdfBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * Created by andrusha on 20.06.17.
 */

@Controller
public class ImgPdfBController {

    private ImgPdfBService imgPdfBService;

    @Autowired
    public void setImgPdfBService(ImgPdfBService imgPdfBService) {
        this.imgPdfBService = imgPdfBService;
    }

    /**
     * Method which gets image like BLOP in DB and then shows images on index.html.
     * @param id
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/image/{id}")
    public @ResponseBody
    void image(@PathVariable long id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        OutputStream out = response.getOutputStream();

        byte[] image = imgPdfBService.getImageByBookId(id);
        response.setContentLength(image.length);
        out.write(image);
    }

    /**
     * Method which gets pdf like BLOP in DB and then shows or downloads it.
     * @param id
     * @param action
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/content/{action}")
    public @ResponseBody
    void content(@RequestParam(name = "id") long id, @PathVariable String action, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();

        if(action.equals("download")) {
            response.setHeader("Content-Disposition", "attachement; filename="+ URLEncoder.encode(String.valueOf(id), "UTF-8")+".pdf");
        }
        byte[] image = imgPdfBService.getContentByBookId(id);
        response.setContentLength(image.length);
        out.write(image);
    }
}
