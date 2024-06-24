package co.develhope.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public class ImageService {

    @Autowired
    private MinioService minioService;

    public Map<String, String> uploadImage(MultipartFile file, String newFileName, String destinationFolderName, String bucketName) {
        return minioService.uploadFile(file, newFileName, destinationFolderName, bucketName);
    }
}

