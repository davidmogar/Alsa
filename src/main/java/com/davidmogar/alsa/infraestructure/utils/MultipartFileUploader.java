package com.davidmogar.alsa.infraestructure.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MultipartFileUploader {

    private static final Logger LOGGER = LoggerFactory.getLogger(MultipartFileUploader.class);

    public static String uploadFile(MultipartFile multipartFile, String directory, HttpServletRequest request)
            throws IOException {
        LOGGER.debug("Uploading file " + multipartFile.getOriginalFilename());

        byte[] bytes = multipartFile.getBytes();

        /* Get path and create directory if not exists */
        String absolutePath = request.getSession().getServletContext().getRealPath("/") + directory;
        File destination = new File(absolutePath);
        if (!destination.exists()) {
            LOGGER.debug("Directory " + absolutePath + " created");
            destination.mkdir();
        }

        LOGGER.debug("Uploading to " + absolutePath);

        /* Copy image to places directory */
        File file = new File(absolutePath + multipartFile.getOriginalFilename());
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
        stream.write(bytes);
        stream.close();

        LOGGER.debug("File " + multipartFile.getOriginalFilename() + " uploaded");

        return directory + multipartFile.getOriginalFilename();
    }
}
