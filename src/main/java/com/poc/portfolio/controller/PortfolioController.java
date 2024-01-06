package com.poc.portfolio.controller;

import com.poc.portfolio.img.project.ProjectImgTag;
import com.poc.portfolio.img.social.SocialMediaImgTag;
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
import org.springframework.ui.Model;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class PortfolioController {

    private static final String RESUME_FILENAME = "chandan-resume.pdf";
    private static final String RESUME_FILE_PATH = "src/main/resources/static/file/chandan-resume.pdf";
    private static final String RESUME_MEDIA_TYPE = "application/pdf";
    private static final String YOUTUBE_ASSET_URL = "/assets/youtube.png";
    private static final String LINKEDIN_ASSET_URL = "/assets/linkedin.png";
    private static final String GITHUB_ASSET_URL = "/assets/github.png";
    private static final String LEETCODE_ASSET_URL = "/assets/leetcode.png";
    private static final String YOUTUBE_URL = "https://www.youtube.com/channel/UCUCTbkGwNK5tUut7wJKqbaA";
    private static final String LINKEDIN_URL = "https://www.linkedin.com/in/chandan-tiwari-uk/";
    private static final String GITHUB_URL = "https://github.com/chandan13tiwari";
    private static final String LEETCODE_URL = "https://leetcode.com/chantiwa/";
    private static final String LIBRBARY_ASSET_URL = "/assets/librbary.png";
    private static final String SECURE_FILE_UPLOAD_ASSET_URL = "/assets/secure-file-upload-project.jpeg";
    private static final String GEHU_ONLINE_ASSET_URL = "/assets/gehu-online.png";
    private static final String LIBRBARY = "Librbary";
    private static final String SECURE_FILE_UPLOAD = "Secure File Upload";
    private static final String GEHU_ONLINE = "GEHU Online";
    private static final String LIBRBARY_GITHUB_URL = "https://github.com/librbary";
    private static final String LIBRBARY_LIVE_DEMO_URL = "https://librbary.github.io/librbary-buy-feature/";
    private static final String SECURE_FILE_UPLOAD_GITHUB_URL = "https://github.com/chandan13tiwari/secure-file-upload";
    private static final String SECURE_FILE_UPLOAD_LIVE_DEMO_URL = "https://github.com/chandan13tiwari/secure-file-upload";
    private static final String GEHU_ONLINE_GITHUB_URL = "https://github.com/chandan13tiwari/GEHU_Online_Project";
    private static final String GEHU_ONLINE_LIVE_DEMO_URL = "https://github.com/chandan13tiwari/GEHU_Online_Project";
    private static final String PROFILE_PIC_ASSET_URL = "/assets/profile-pic.png";



    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("titles", getTitles());
        model.addAttribute("social", getSocialMediaImgTag());
        model.addAttribute("projects", getProjectImgTag());
        model.addAttribute("profilepic", PROFILE_PIC_ASSET_URL);

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

    private static List<String> getTitles() {
        List<String> listOfTitles = new ArrayList<>();
        listOfTitles.add("Software Development Engineer");
        listOfTitles.add("Content Creator");
        listOfTitles.add("Music Producer");

        return listOfTitles;
    }

    private static List<SocialMediaImgTag> getSocialMediaImgTag() {
        List<SocialMediaImgTag> imgTagList = new ArrayList<>();

        imgTagList.add(SocialMediaImgTag.builder()
                .assetUrl(YOUTUBE_ASSET_URL).altName("My YouTube profile").onClickAction(YOUTUBE_URL).build());
        imgTagList.add(SocialMediaImgTag.builder()
                .assetUrl(LINKEDIN_ASSET_URL).altName("My LinkedIn profile").onClickAction(LINKEDIN_URL).build());
        imgTagList.add(SocialMediaImgTag.builder()
                .assetUrl(GITHUB_ASSET_URL).altName("My Github profile").onClickAction(GITHUB_URL).build());
        imgTagList.add(SocialMediaImgTag.builder()
                .assetUrl(LEETCODE_ASSET_URL).altName("My Leetcode profile").onClickAction(LEETCODE_URL).build());

        return imgTagList;
    }

    private static List<ProjectImgTag> getProjectImgTag() {
        List<ProjectImgTag> imgTagList = new ArrayList<>();

        imgTagList.add(ProjectImgTag.builder()
                .assetUrl(LIBRBARY_ASSET_URL).altName(LIBRBARY).projectName(LIBRBARY)
                .onGithubClickAction(LIBRBARY_GITHUB_URL)
                .onLiveDemoClickAction(LIBRBARY_LIVE_DEMO_URL).build());

        imgTagList.add(ProjectImgTag.builder()
                .assetUrl(SECURE_FILE_UPLOAD_ASSET_URL).altName(SECURE_FILE_UPLOAD).projectName(SECURE_FILE_UPLOAD)
                .onGithubClickAction(SECURE_FILE_UPLOAD_GITHUB_URL)
                .onLiveDemoClickAction(SECURE_FILE_UPLOAD_LIVE_DEMO_URL).build());

        imgTagList.add(ProjectImgTag.builder()
                .assetUrl(GEHU_ONLINE_ASSET_URL).altName(GEHU_ONLINE).projectName(GEHU_ONLINE)
                .onGithubClickAction(GEHU_ONLINE_GITHUB_URL)
                .onLiveDemoClickAction(GEHU_ONLINE_LIVE_DEMO_URL).build());

        return imgTagList;
    }

}
