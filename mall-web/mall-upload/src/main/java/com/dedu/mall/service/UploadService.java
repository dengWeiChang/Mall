package com.dedu.mall.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class UploadService {

//    @Autowired
//    private FastFileStorageClient storageClient;//文件上传的最终地址


    @Value("#{'${image.types}'.split(',')}")
    private List<String> ALLOWTYPES;

    @Value("${image.path}")
    private String IMAGEPATH;

    @Value("${image.url.prefix}")
    private String IMAGEURLPRE;

    private static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public String uploadImage(MultipartFile file) throws Exception {
        //校验格式
        String contentType = file.getContentType();
        if(!ALLOWTYPES.contains(contentType)){
            throw new Exception("无此图片类型");
        }
        try {
            //校验内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if(image == null){
                throw new Exception("无效图片");
            }
            String filename = LocalDateTime.now().format(df) + "-" + file.getOriginalFilename();
            //准备目标路径
            File local = new File(IMAGEPATH, filename);
            //保存到本地
            file.transferTo(local);

            //返回路径
            return IMAGEURLPRE + filename;

        } catch (Exception e) {
            log.error("文件上传失败", e);
            throw new Exception("上传失败");
        }
    }
}
