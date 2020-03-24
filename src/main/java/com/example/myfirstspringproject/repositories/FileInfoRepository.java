package com.example.myfirstspringproject.repositories;


import com.example.myfirstspringproject.models.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 01.12.2017
 * FileInfoRepository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
    FileInfo findOneByStorageFileName(String storageFileName);
}

