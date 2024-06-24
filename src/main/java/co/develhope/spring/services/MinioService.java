package co.develhope.spring.services;

import co.develhope.spring.exceptions.MinIOFileUploadException;
import co.develhope.spring.utils.TinyURL;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import io.minio.http.Method;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Service
public class MinioService {
    private final MinioClient minioClient;


    @Autowired
    public MinioService(MinioClient minioClient) {
        this.minioClient = minioClient;
    }


    public Map<String, String> uploadFile(MultipartFile file, String newFileName, String destinationFolderName, String bucketName) {
        String extension = Objects.requireNonNull(FilenameUtils.getExtension(file.getOriginalFilename())).toLowerCase();
        String objectFullName = destinationFolderName + "/" + UUID.randomUUID() +
                "_" + LocalDate.now() + "_" + newFileName + "." + extension;

        String contentType = file.getContentType();
        InputStream fileInputStream = null;

        // Dimensione max di un pezzo (uploader divide i file a pezzi da 10MB
        // ad.es.: dimensione di file = 100mb, dim. di ogni pezzo per = 10)
        long maxPartSize = 10485760L;

        Map<String, String> newObject = new HashMap<>();
        try {

            fileInputStream = file.getInputStream();

            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(objectFullName)
                    .stream(fileInputStream, -1, maxPartSize)
                    .contentType(contentType)
                    .build());

            String objectFullLink = minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(Method.GET)
                            .bucket(bucketName)
                            .object(objectFullName)
                            .build()
            );
            var shortUrl = TinyURL.shortUrl(objectFullLink);
            newObject.put("fullLink", shortUrl);
            newObject.put("objectName", objectFullName);

            return newObject;

        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException |
                 InvalidResponseException | ServerException | XmlParserException |
                 IOException | NoSuchAlgorithmException exception) {

            throw new MinIOFileUploadException("[File upload error] " + exception.getMessage());

        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
