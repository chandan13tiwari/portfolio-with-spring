package com.poc.portfolio.controller;

import com.poc.portfolio.enums.*;
import com.poc.portfolio.experience.TechExperience;
import com.poc.portfolio.img.arrow.ArrowImgTag;
import com.poc.portfolio.img.client.ClientImgTag;
import com.poc.portfolio.img.project.ProjectImgTag;
import com.poc.portfolio.img.social.SocialMediaImgTag;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.poc.portfolio.enums.BackendTech.*;
import static com.poc.portfolio.enums.Clients.*;
import static com.poc.portfolio.enums.DatabaseTech.*;
import static com.poc.portfolio.enums.Designations.*;
import static com.poc.portfolio.enums.DevOpsTech.*;
import static com.poc.portfolio.enums.FrontendTech.*;
import static com.poc.portfolio.enums.Titles.*;
import static com.poc.portfolio.utils.Constants.*;

@Controller
public class PortfolioController {

  @GetMapping("/")
  public String portfolio(Model model) {
    model.addAttribute("myName", MY_NAME);
    model.addAttribute("myExpInYear", MY_EXPERIENCE_IN_YEARS);
    model.addAttribute("myEmail", MY_EMAIL_ID);
    model.addAttribute("titles", getTitles());
    model.addAttribute("social", getSocialMediaImgTagAttributes());
    model.addAttribute("projects", getProjectImgTagAttributes());
    model.addAttribute("profilepic", PROFILE_PIC_ASSET_URL);
    model.addAttribute("aboutpic", ABOUT_PIC_ASSET_URL);
    model.addAttribute("experience", EXPERIENCE_ASSET_URL);
    model.addAttribute("education", EDUCATION_ASSET_URL);
    model.addAttribute("arrow", getArrowImgTagAttributes());
    model.addAttribute("checkmark", CHECKMARK_ASSET_URL);
    model.addAttribute("clients", getClientImgTagAttributes());
    model.addAttribute("frontend", getFrontendDevelopmentExperience());
    model.addAttribute("backend", getBackendDevelopmentExperience());
    model.addAttribute("cloud", getCloudExperience());
    model.addAttribute("database", getDatabaseExperience());
    model.addAttribute("devops", getDevOpsExperience());
    model.addAttribute("youtube", YOUTUBE_URL);
    model.addAttribute("banner", POC_BANNER_URL);
    model.addAttribute("linkedin", LINKEDIN_URL);
    model.addAttribute("mailtoemail", MAIL_TO_EMAIL);
    model.addAttribute("email", EMAIL_ASSET_URL);
    model.addAttribute("linkedinpic", LINKEDIN_ASSET_URL);

    return "index";
  }

  @GetMapping(path = "/download")
  public ResponseEntity<Resource> downloadResume() throws IOException {
    File file = new File(RESUME_FILE_PATH);
    Path path = Paths.get(file.getAbsolutePath());
    ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + RESUME_FILENAME + "\"")
        .contentLength(file.length()).contentType(MediaType.parseMediaType(RESUME_MEDIA_TYPE)).body(resource);
  }

  private static List<String> getTitles() {
    List<String> listOfTitles = new ArrayList<>();

    Arrays.stream(Titles.values()).forEach(title -> {
      listOfTitles.add(title.getValue());
    });

    return listOfTitles;
  }

  private static List<SocialMediaImgTag> getSocialMediaImgTagAttributes() {
    List<SocialMediaImgTag> imgTagList = new ArrayList<>();

    imgTagList.add(SocialMediaImgTag.builder().assetUrl(YOUTUBE_ASSET_URL).altName("My YouTube profile")
        .onClickAction(YOUTUBE_URL).build());
    imgTagList.add(SocialMediaImgTag.builder().assetUrl(LINKEDIN_ASSET_URL).altName("My LinkedIn profile")
        .onClickAction(LINKEDIN_URL).build());
    imgTagList.add(SocialMediaImgTag.builder().assetUrl(GITHUB_ASSET_URL).altName("My Github profile")
        .onClickAction(GITHUB_URL).build());
    imgTagList.add(SocialMediaImgTag.builder().assetUrl(LEETCODE_ASSET_URL).altName("My Leetcode profile")
        .onClickAction(LEETCODE_URL).build());

    return imgTagList;
  }

  private static List<ProjectImgTag> getProjectImgTagAttributes() {
    List<ProjectImgTag> imgTagList = new ArrayList<>();

    imgTagList.add(ProjectImgTag.builder().assetUrl(LIBRBARY_ASSET_URL).altName(LIBRBARY).projectName(LIBRBARY)
        .onGithubClickAction(LIBRBARY_GITHUB_URL).onLiveDemoClickAction(LIBRBARY_LIVE_DEMO_URL).build());

    imgTagList.add(ProjectImgTag.builder().assetUrl(SECURE_FILE_UPLOAD_ASSET_URL).altName(SECURE_FILE_UPLOAD)
        .projectName(SECURE_FILE_UPLOAD).onGithubClickAction(SECURE_FILE_UPLOAD_GITHUB_URL)
        .onLiveDemoClickAction(SECURE_FILE_UPLOAD_LIVE_DEMO_URL).build());

    imgTagList.add(ProjectImgTag.builder().assetUrl(GEHU_ONLINE_ASSET_URL).altName(GEHU_ONLINE)
        .projectName(GEHU_ONLINE).onGithubClickAction(GEHU_ONLINE_GITHUB_URL)
        .onLiveDemoClickAction(GEHU_ONLINE_LIVE_DEMO_URL).build());

    return imgTagList;
  }

  private static ArrowImgTag getArrowImgTagAttributes() {
    return ArrowImgTag.builder().assetUrl(ARROW_ASSET_URL).altName("Arrow icon").build();
  }

  private static List<ClientImgTag> getClientImgTagAttributes() {
    List<ClientImgTag> imgTagList = new ArrayList<>();

    imgTagList.add(ClientImgTag.builder().assetUrl(ORACLE_LOGO_URL).altName("oracle-logo")
        .clientName(ORACLE.getValue()).designation(SDE_2.getValue()).draggable(false).build());
    imgTagList.add(ClientImgTag.builder().assetUrl(MACQUARIE_LOGO_URL).altName("mcq-logo")
        .clientName(MCQ.getValue()).designation(CONSULTANT.getValue()).draggable(false).build());
    imgTagList.add(ClientImgTag.builder().assetUrl(AMEX_LOGO_URL).altName("amex-logo").clientName(AMEX.getValue())
        .designation(SDE_1.getValue()).draggable(false).build());
    imgTagList.add(ClientImgTag.builder().assetUrl(EY_LOGO_URL).altName("ey-logo").clientName(EY.getValue())
        .designation(SENIOR_CONSULTANT.getValue()).draggable(false).build());
    imgTagList.add(ClientImgTag.builder().assetUrl(HSBC_LOGO_URL).altName("hsbc-logo").clientName(HSBC.getValue())
        .designation(SDE_1.getValue()).draggable(false).build());
    imgTagList.add(ClientImgTag.builder().assetUrl(CAPGEMINI_LOGO_URL).altName("capg-logo")
        .clientName(CAPG.getValue()).designation(SENIOR_ANALYST.getValue()).draggable(false).build());
    imgTagList.add(ClientImgTag.builder().assetUrl(INFOSYS_LOGO_URL).altName("infy-logo")
        .clientName(INFOSYS.getValue()).designation(CONSULTANT.getValue()).draggable(false).build());

    return imgTagList;
  }

  private static List<TechExperience> getFrontendDevelopmentExperience() {
    List<TechExperience> imgTagList = new ArrayList<>();

    Arrays.stream(FrontendTech.values()).forEach(tech -> {
      imgTagList.add(TechExperience.builder().technology(tech.getTechnology()).expLevel(tech.getExperienceLevel())
          .build());
    });

    return imgTagList;
  }

  private static List<TechExperience> getBackendDevelopmentExperience() {
    List<TechExperience> imgTagList = new ArrayList<>();

    Arrays.stream(BackendTech.values()).forEach(tech -> {
      imgTagList.add(TechExperience.builder().technology(tech.getTechnology()).expLevel(tech.getExperienceLevel())
          .build());
    });

    return imgTagList;
  }

  private static List<TechExperience> getCloudExperience() {
    List<TechExperience> imgTagList = new ArrayList<>();

    Arrays.stream(CloudTech.values()).forEach(tech -> {
      imgTagList.add(TechExperience.builder().technology(tech.getTechnology()).expLevel(tech.getExperienceLevel())
          .build());
    });

    return imgTagList;
  }

  private static List<TechExperience> getDatabaseExperience() {
    List<TechExperience> imgTagList = new ArrayList<>();

    Arrays.stream(DatabaseTech.values()).forEach(tech -> {
      imgTagList.add(TechExperience.builder().technology(tech.getTechnology()).expLevel(tech.getExperienceLevel())
          .build());
    });

    return imgTagList;
  }

  private static List<TechExperience> getDevOpsExperience() {
    List<TechExperience> imgTagList = new ArrayList<>();

    Arrays.stream(DevOpsTech.values()).forEach(tech -> {
      imgTagList.add(TechExperience.builder().technology(tech.getTechnology()).expLevel(tech.getExperienceLevel())
          .build());
    });

    return imgTagList;
  }

}
