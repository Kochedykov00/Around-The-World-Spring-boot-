package com.example.myfirstspringproject.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 01.12.2017
 * FileStorageService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface FileStorageService {
    // сохраняет файл на сервере
    String saveFile(MultipartFile file);
    // отправляет файл по запросу
    void writeFileToResponse(String fileName, HttpServletResponse response);
}

