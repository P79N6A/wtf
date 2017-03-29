package cn.tc.ulife.platform.util.payutil;



import cn.tc.ulife.platform.util.ConfigUtil;
import cn.tc.ulife.platform.util.localthread.SimpleThreadLocal;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Date;
import java.util.Random;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.util.payutil
 * </p>
 * User: wangyue
 * </p>
 * Date: 2011/3/22 0022
 * </p>
 * Time: 下午 2:20
 * </p>
 * Detail:  用于生成二维码,暂时用途为生成微信扫码支付
 * </p>
 */
public class WxPayCodeUtil {


    private static Logger logger = Logger.getLogger(WxPayCodeUtil.class);

    private final static String base = "0123456789";
    private static String datePaten = "yyyyMMddHHmmss";

    public static String getUrl(String urlStr) {
        if (null == urlStr) {
            return null;
        }

        String path = WxPayCodeUtil.builderPath();

        boolean flag = WxPayCodeUtil.encoderQRCode(urlStr, path);
        if (flag) {
            return path.replace(ConfigUtil.getProperties("WXPAY_FILE_PATH"), "");
        }
        return null;
    }


    public static String builderPath() {
        String fristPath = ConfigUtil.getProperties("WXPAY_FILE_PATH");
        String secondPath = ConfigUtil.getProperties("WXPAY_CODE_FILE_PATH");

        String date = SimpleThreadLocal.format(new Date(), datePaten);


        Random random = new Random();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 6; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }


        String codePath = fristPath + secondPath  + date + sb.toString() + ".jpg";


        return codePath;
    }


    public static boolean encoderQRCode(String content, String imgPath) {

        QRCode qrCode = QRCode.from(content);
        qrCode.withSize(500, 900);
        ByteArrayOutputStream out = qrCode.to(ImageType.PNG).stream();
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(new File(
                    imgPath));

            fout.write(out.toByteArray());


        } catch (FileNotFoundException e) {
            logger.error("文件路径找不到:{}" + "imgPath:" + imgPath + ",content:" + content, e);
        } catch (IOException e) {
            logger.error("IO异常:{}" + "imgPath:" + imgPath + ",content:" + content, e);
        } finally {
            if (null != out) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    logger.error("IO异常:{}" + "imgPath:" + imgPath + ",content:" + content, e);
                }
            }
            if (null != fout) {
                try {
                    fout.flush();
                    fout.close();
                } catch (IOException e) {
                    logger.error("IO异常:{}" + "imgPath:" + imgPath + ",content:" + content, e);
                }
            }
        }


        return true;
    }

}
