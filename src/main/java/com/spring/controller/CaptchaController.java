package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.DESUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.Random;

/**
 * 验证码控制器
 */
@Controller
public class CaptchaController extends BaseController {
    /**
     * 输出验证码图片,并记录session “random” 里等待登录时写入
     */
    @RequestMapping("/captcha")
    public String Index()
    {
        // 把验证码字符串写入session 中，保存待下次验证时使用
        String sRand = createRandomString(4);

        try {
            // 输出渲染好的内容到前端浏览器
            if(isAjax()){
                String result = null;
                do {
                    try{
                        result = DESUtil.encrypt("CaptchControllerPassword",sRand);
                    }catch (Exception e){
                        result = null;
                    }
                    if(result!= null){
                        if(!sRand.equals(DESUtil.decrypt("CaptchControllerPassword" , result))){
                            result = null; // 解不出来所以出错
                        }
                    }
                }while (result == null);

                assign("url" , "/randtocaptch?captchToken="+  urlencode(result));
                assign("token" , result);
                return json();
            }else{
                //byte[] img = xxx;
                response.setContentType("image/jpeg"); // 定义输出类型为 图片
                response.setHeader("Pragma","No-cache");   // 设置为无缓存
                response.setHeader("Cache-Control","no-cache");  // 设置为无缓存
                response.setDateHeader("Expires", 0);  // 设置缓存时间为0秒后过期
                request.getSession().setAttribute("random",sRand);
                ServletOutputStream stream = response.getOutputStream();
                createCaptch(sRand,stream);
                stream.flush();
                stream.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }


    /**
     * url 编码，中文要进行编码输出
     * @param str
     * @return
     */
    public static String urlencode(Object str)
    {
        try{
            return java.net.URLEncoder.encode(String.valueOf(str), "UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return str.toString();
    }

    /**
     * 使用上面的加密字符串生成验证码
     * @return
     */
    @RequestMapping("/randtocaptch")
    public String getCaptch() throws IOException {
        String captchToken = request.getParameter("captchToken");
        String sRand = DESUtil.decrypt("CaptchControllerPassword" , captchToken);
        HttpSession session = request.getSession();
        {
            //byte[] img = xxx;
            response.setContentType("image/jpeg"); // 定义输出类型为 图片
            response.setHeader("Pragma","No-cache");   // 设置为无缓存
            response.setHeader("Cache-Control","no-cache");  // 设置为无缓存
            response.setDateHeader("Expires", 0);  // 设置缓存时间为0秒后过期
            ServletOutputStream stream = response.getOutputStream();
            createCaptch(sRand,stream);
            stream.flush();
            stream.close();
        }
        return "success";
    }


    private String createRandomString(int len)
    {
        // 生成随机数类
        Random random = new Random();
        String result = "";
        for (int i=0;i<len;i++){
            String rand = String.valueOf(random.nextInt(10));
            result += rand;
        }
        return result;
    }

    private void createCaptch(String randomstr , OutputStream stream)
    {
        int width=60, height=20;   // 定义图片宽为 60  高度为 20

        // 创建图片缓冲区
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 获取渲染画板
        Graphics g = image.getGraphics();

        // 生成随机数类
        Random random = new Random();

        // 设置颜色
        g.setColor(getRandColor(200,250));

        // 绘制矩形
        g.fillRect(0, 0, width, height);

        // 设置字体信息
        g.setFont(new Font("Times New Roman",Font.PLAIN,18));

        // 设置颜色信息
        g.setColor(getRandColor(160,200));

        // 写入干扰线
        for (int i=0;i<155;i++)
        {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x,y,x+xl,y+yl);
        }

        // 写入验证码字符串
        for (int i=0;i<randomstr.length();i++){
            String rand = randomstr.substring(i,i+1); //String.valueOf(random.nextInt(10));

            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(rand,13*i+6,16);
        }
        g.dispose();  // 释放画板

        try {
            // 输出渲染好的内容到前端浏览器

            ImageIO.write(image, "JPEG", stream);
            stream.flush();
            stream.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }




    /**
     * 获取随机颜色
     * @param fc
     * @param bc
     * @return
     */
    protected Color getRandColor(int fc, int bc)
    {
        Random random = new Random();
        if(fc>255) fc=255;
        if(bc>255) bc=255;
        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
    }
}
