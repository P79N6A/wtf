package cn.tc.ulife.platform.util;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 通用app端上传图片方法 接受二进制流
 *
 * @author wy
 */
public class UploadFileUtil {
    public static Map<String, String> ftype = new HashMap<String, String>();

    static {
        ftype.put("jpg", "");
        ftype.put("jpeg", "");
        ftype.put("bmp", "");
        ftype.put("gif", "");
        ftype.put("png", "");
    }

    /**
     * 上传文件
     * @param request
     * @param name 文件名
     * @param path1 文件根目录
     * @param path2 文件上级目录
     * @return
     */
    public static String upload(HttpServletRequest request, String name,
                                String path1, String path2) {
        //        path1 = ConfigUtil.getProperties(path1);
        //        path2 = ConfigUtil.getProperties(path2);

        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest servletRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = servletRequest.getFile(name);

            if (null != multipartFile.getOriginalFilename() || !""
                    .equals(multipartFile.getOriginalFilename())) {
                return getFile(multipartFile, path1, path2);
            }
        } else {
            if (request.getParameter(name) != null || !""
                    .equals(request.getParameter(name))) {
                return getFile(name, request.getParameter(name), path1, path2);
            }
        }
        return null;
    }

    /**
     * @return
     */
    private static String getFile(MultipartFile multipartFile, String path1,
                                  String path2) {
        StringBuffer fpath = new StringBuffer();
        String fileName = multipartFile.getOriginalFilename();
        String ext = fileName
                .substring(fileName.lastIndexOf(".") + 1, fileName.length());
        ext = ext.toLowerCase();
        File file = null;
        if (ftype.containsKey(ext)) {
            file = creatFolder(path1, path2, fileName, ext);
            try {
                try {
                    multipartFile.transferTo(file);
                    fpath/* .append(path1).append(File.separator) */
                            .append(path2).append("/").append(file.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        return fpath.toString();
    }

    private static String getFile(String fileName, String base64String, String path1,
                                  String path2) {
        StringBuffer fpath = new StringBuffer();
        String ext = fileName
                .substring(fileName.lastIndexOf(".") + 1, fileName.length());
        ByteArrayInputStream bais = null;
        try {
            byte[] bytes1 = new sun.misc.BASE64Decoder()
                    .decodeBuffer(base64String);
            bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 = ImageIO.read(bais);
            File w2 = creatFolder(path1, path2, fileName, ext);
            fpath.append(path2).append("/").append(w2.getName());
            ImageIO.write(bi1, "jpg", w2);//不管输出什么格式图片，此处不需改动
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fpath.toString();
    }

    /**
     * @param typeName
     * @param brandName
     * @param fileName
     *
     * @return
     */
    private static File creatFolder(String typeName, String brandName,
                                    String fileName, String ext) {

        File file = null;
        // typeName = typeName.replaceAll("/", ""); // 去掉"/"
        typeName = typeName.trim();// .replaceAll(" ", ""); // 替换半角空格
        // typeName = typeName.replaceAll(" ", ""); // 替换全角空格

        // brandName = brandName.replaceAll("/", ""); // 去掉"/"
        brandName = brandName.trim();// replaceAll(" ", ""); // 替换半角空格
        // brandName = brandName.replaceAll(" ", ""); // 替换全角空格

        File firstFolder = new File(/*
                                     * ConfigUtil.getProperties("FILE_PATH") +
									 */typeName); // 一级文件夹
        File secondFolder = null;
        if (firstFolder.exists()) { // 如果一级文件夹存在，则检测二级文件夹
            secondFolder = new File(firstFolder, brandName);
            if (!secondFolder.exists()) {
                // 如果二级文件夹不存在，则创建二级文件夹
                secondFolder.mkdir();
            }
        } else {
            // 如果一级不存在，则创建一级文件夹
            firstFolder.mkdir();
            secondFolder = new File(firstFolder, brandName);
            if (!secondFolder.exists()) {
                // 如果二级文件夹不存在，则创建二级文件夹
                secondFolder.mkdir();
            }
        }

        file = new File(secondFolder, getRandomString(8) + "." + ext); // 创建完二级文件夹后，再合建文件

        return file;

    }

    public static String getRandomString(int length) { // length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String getFilePath(File file) {
        String path = null;
        if (null != file) {
            path = file.getPath().replace("\\", "/")
                    .replace("D:/apache-tomcat-7.0.56/webapps",
                             "http://192.168.0.151:8080");
        }
        return path;
    }

//    /**
//     *
//     * @param request
//     * @param response
//     * @param domainPath 文件域路径
//     * @param rootDir 文件根目录
//     * @param parentDir 文件上级目录，完整的服务器文件名=文件根目录+文件上级目录+文件名
//     * @return
//     */
//    public static Map<String, Object> upload(HttpServletRequest request,
//                                HttpServletResponse response, String domainPath,
//                                String rootDir, String parentDir) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        Random random = new Random();
//        response.setContentType("text/html; charset=UTF-8"); // 转码
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        factory.setSizeThreshold(4096);// 设置上传文件时用于临时存放文件的内存大小,这里是4K.多于的部分将临时存在硬盘
//        ServletFileUpload fileUpload = new ServletFileUpload(factory);
//        fileUpload.setSizeMax(5 * 1024 * 1024);// 文件最大4MB;
//        try {
//            String domain = domainPath;// 访问路径
//            String url = rootDir + parentDir;
//            List<FileItem> items = fileUpload.parseRequest(request);
//            Iterator it = items.iterator();
//            while (it.hasNext()) {
//                FileItem item = (FileItem) it.next();
//                if (item.getName() != null && !item.getName().equals("")) {// 防止抛出空指针，判断一下是否为空
//                    DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
//                    Calendar calendar = Calendar.getInstance();
//                    // 文件名前缀按系统规则重新生成
//                    String imageName = df.format(calendar.getTime()) + "_" + random
//                            .nextInt(999999);
//                    String filename = item.getName();
//                    // 文件名后缀
//                    String fname = filename
//                            .substring(filename.lastIndexOf(".") + 1);
//                    // 文件名 = 前缀 + 后缀
//                    String name = imageName + "." + fname;
//                    File file = new File(url, name);
//                    item.write(file);
//                    map.put("data", domain + parentDir + name);
//                    map.put("imgUrl", name);
//                }
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        return map;
//    }
}

