package com.codechampions.easytravel.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import com.codechampions.easytravel.model.FileEntity;
import com.codechampions.easytravel.repository.FileRepository;

@Controller
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestPart("file") MultipartFile file) {
        // Handle file upload logic here
        // Save file details to the database
        return "redirect:/";
    }

    @GetMapping("/files")
    public String getFiles(Model model) {
        // Retrieve file details from the database
        Iterable<FileEntity> files = fileRepository.findAll();

        // Set the list of files in the model
        model.addAttribute("files", files);

        return "files";
    }
}