package com.poc.portfolio.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
@Slf4j
public class PortfolioController {

    private static final String RESUME_FILENAME = "chandan-resume.pdf";
    private static final String RESUME_FILE_PATH = "/src/main/resources/static/file";
    private static final String PATH_DELIMETER = "/";
    private static final String RESUME_MEDIA_TYPE = "application/pdf";

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/download")
    @ResponseBody
    public ResponseEntity<Object> download() throws IOException {
        File resume = new ClassPathResource("static/file" + PATH_DELIMETER + RESUME_FILENAME).getFile();

        try (FileInputStream fileInputStream = new FileInputStream(resume)) {

            InputStreamResource inputStreamResource = new InputStreamResource(fileInputStream);

           return ResponseEntity.ok()
                   .contentType(MediaType.parseMediaType(RESUME_MEDIA_TYPE))
                   .contentLength(Files.size(Paths.get(resume.getPath())))
                   .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + RESUME_FILENAME + "\"")
                   .body(inputStreamResource);
        }
    }
}
