package com.knifestone.hyena.currency;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 文件格式适配器
 * github:https://github.com/KnifeStone/Hyena
 * Created by KnifeStone on 2017-11-9.
 */
public class FileAdapter {

    // mFileTypes.put("FFD8FF", "jpg");
    // mFileTypes.put("89504E47", "png");
    // mFileTypes.put("47494638", "gif");
    // mFileTypes.put("49492A00", "tif");
    // mFileTypes.put("424D", "bmp");
    // //
    // mFileTypes.put("41433130", "dwg"); //CAD
    // mFileTypes.put("38425053", "psd");
    // mFileTypes.put("7B5C727466", "rtf"); //日记本
    // mFileTypes.put("3C3F786D6C", "xml");
    // mFileTypes.put("68746D6C3E", "html");
    // mFileTypes.put("44656C69766572792D646174653A", "eml"); //邮件
    // mFileTypes.put("D0CF11E0", "doc");
    // mFileTypes.put("5374616E64617264204A", "mdb");
    // mFileTypes.put("252150532D41646F6265", "ps");
    // mFileTypes.put("255044462D312E", "pdf");
    // mFileTypes.put("504B0304", "zip");
    // mFileTypes.put("52617221", "rar");
    // mFileTypes.put("57415645", "wav");
    // mFileTypes.put("41564920", "avi");
    // mFileTypes.put("2E524D46", "rm");
    // mFileTypes.put("000001BA", "mpg");
    // mFileTypes.put("000001B3", "mpg");
    // mFileTypes.put("6D6F6F76", "mov");
    // mFileTypes.put("3026B2758E66CF11", "asf");
    // mFileTypes.put("4D546864", "mid");
    // mFileTypes.put("1F8B08", "gz");

    /**
     * 获得文件类型
     * @param filePath 文件路径
     * @return 类型
     */
    public static String getImageType(String filePath) {
        FileInputStream is = null;
        String value = null;
        try {
            is = new FileInputStream(filePath);
            byte[] b = new byte[3];
            is.read(b, 0, b.length);
            value = bytesToHexString(b);
        } catch (Exception e) {
        } finally {
            if(null != is) {
                try {
                    is.close();
                } catch (IOException e) {}
            }
        }
        if("FFD8FF".equals(value)){
            return "jpg";
        } else if("89504E".equals(value)){
            return "png";
        } else if("474946".equals(value)){
            return "gif";
        } else if("424D".equals(value)){
            return "bmp";
        }
        return value;
    }

    /**
     * 获得文件类型
     * @param bytes 二进制数组
     * @return  类型
     */
    private static String bytesToHexString(byte[] bytes){
        StringBuilder builder = new StringBuilder();
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        String hv;
        for (int i = 0; i < bytes.length; i++) {
            hv = Integer.toHexString(bytes[i] & 0xFF).toUpperCase();
            if (hv.length() < 2) {
                builder.append(0);
            }
            builder.append(hv);
        }
        return builder.toString();
    }


}
