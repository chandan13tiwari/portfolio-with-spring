package com.poc.portfolio.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@Slf4j
public class PortfolioController {

    private static final String RESUME_FILENAME = "chandan-resume.pdf";
    private static final String RESUME_FILE_PATH = "src/main/resources/static/file/chandan-resume.pdf";
    private static final String RESUME_MEDIA_TYPE = "application/pdf";

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping(path = "/download")
    public ResponseEntity<Resource> download() throws IOException {
        File file = new File(RESUME_FILE_PATH);
        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + RESUME_FILENAME + "\"")
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType(RESUME_MEDIA_TYPE))
                .body(resource);
    }

}
