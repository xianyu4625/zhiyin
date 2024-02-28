package org.example.controller;

import org.example.pojo.Result;
import org.example.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController

public class FileUploadController {
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
//        将照片存储到本地的磁盘上面
        String originalfilename=file.getOriginalFilename();
//        实现名字的不重复，唯一性，防止文件的覆盖,加上后面的后缀名
        String filename= UUID.randomUUID().toString()+originalfilename.substring(originalfilename.lastIndexOf("."));
//       file.transferTo(new File("C:\\Workspace\\loaclhostimage\\"+filename));
        String url=AliOssUtil.uploadFile(filename,file.getInputStream());
       return Result.success(url);
    }
}
