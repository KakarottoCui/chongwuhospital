package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 上传控制器
 */
@Controller
public class UploadController extends BaseController{

    /**
     * 上传文件
     * @param fujian
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/upload_re")
    public String Upload(MultipartFile fujian) throws Exception
    {
        String fileName = fujian.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID()+suffixName;
        String filePath = getFolder("upload");

        try{
            File file = new File(getPhysicalPath(filePath)+"/"+fileName);
            fujian.transferTo(file);
            request.setAttribute("url",filePath+"/"+fileName);
            if(isAjax())
            {
                return jsonResult(request.getAttribute("url"));
            }
            return "upload";
        }catch (Exception e){
            return showError(e.getMessage());
        }
    }

    private String getFolder(String path) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
        path += "/" + formater.format(new Date());
        File dir = new File(this.getPhysicalPath(path));
        if (!dir.exists()) {
            try {
                dir.mkdirs();
            } catch (Exception e) {
                return "";
            }
        }
        return path;
    }

    /**
     * 根据传入的虚拟路径获取物理路径
     *
     * @param path
     * @return
     */
    private String getPhysicalPath(String path) {
        String servletPath = this.request.getServletPath();
        String realPath = this.request.getSession().getServletContext()
                .getRealPath(servletPath);
        return new File(realPath).getParent() +"/" +path;
    }
}
