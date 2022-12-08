package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
//@RequestMapping("/api/autha")
//@PreAuthorize("hasRole('ADMIN')")
public class UploadResource {

    @GetMapping("/api/auth/helloWord")
    public String hello123() {
        return "hell OK";
    }

    //上傳圖片
    //C:\Users\User\Desktop\Spring_Vue\src\main\resources\static
    private static final String UPLOAD_PATH = "C:\\Users\\User\\Desktop\\Spring_Vue\\src\\main\\resources\\static\\";

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        try {
            byte[] bytes = file.getBytes();
            String imageFileName = file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_PATH + imageFileName);
            Files.write(path, bytes);
            return imageFileName;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    //讀取圖片1
    @GetMapping("/getImage/{name}")

    public void getImage(HttpServletResponse response, @PathVariable("name") String name) throws IOException {

        response.setContentType("image/jpeg;charset=utf-8");
        response.setHeader("Content-Disposition", "inline; filename=girls.png");
        ServletOutputStream outputStream = response.getOutputStream();
        System.out.println("static" + name);
        outputStream.write(Files.readAllBytes(Paths.get(UPLOAD_PATH).resolve(name)));
        outputStream.flush();
        outputStream.close();
    }
}
