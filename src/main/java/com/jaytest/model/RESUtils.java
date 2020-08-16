package com.jaytest.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class RESUtils {

    /**
     * 加密
     * @param message
     * @param key
     * @return
     * @throws Exception
     */
    public static String desEncrypt(String message, String key)
            throws Exception {
        String jiami = URLEncoder.encode(message, "utf-8").toLowerCase();
        jiami = encryptBASE64(jiami);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(1, secretKey, iv);
        byte[] bs = cipher.doFinal(jiami.getBytes("UTF-8"));
        return toHexString(bs);
    }

    /**
     * 解密
     * @param message
     * @param key
     * @return
     * @throws Exception
     */
    public static String desDecrypt(String message, String key)
            throws Exception {
        byte[] bytesrc = convertHexString(message);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(2, secretKey, iv);
        byte[] retByte = cipher.doFinal(bytesrc);
        String ret = new String(retByte, "UTF-8");

        ret = URLDecoder.decode(decryptBASE64(ret).toLowerCase(), "utf-8");
        return ret;
    }

    public static byte[] convertHexString(String ss) {
        byte[] digest = new byte[ss.length() / 2];
        for (int i = 0; i < digest.length; i++) {
            String byteString = ss.substring(2 * i, 2 * i + 2);
            int byteValue = Integer.parseInt(byteString, 16);
            digest[i] = ((byte) byteValue);
        }
        return digest;
    }

    public static String toHexString(byte[] b) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String plainText = Integer.toHexString(0xFF & b[i]);
            if (plainText.length() < 2) {
                plainText = "0" + plainText;
            }
            hexString.append(plainText);
        }
        return hexString.toString();
    }

    public static String encryptBASE64(String s) {
        String ret = "";
        byte[] b = s.getBytes();
        try {
            ret = new String(Base64.encodeBase64(b), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static String decryptBASE64(String s) {
        byte[] ret = new byte[0];
        try {
            ret = Base64.decodeBase64(s.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            return new String(ret, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 压缩
     * @param primStr
     * @return
     */
    public static String gzipString(String primStr) {
        if ((primStr == null) || (primStr.length() == 0)) {
            return primStr;
        }
        ByteArrayOutputStream out = null;
        GZIPOutputStream gout = null;
        try {
            out = new ByteArrayOutputStream();
            gout = new GZIPOutputStream(out);
            gout.write(primStr.getBytes("UTF-8"));
            gout.flush();
        } catch (IOException e) {
            return null;
        } finally {
            if (gout != null) {
                try {
                    gout.close();
                } catch (IOException localIOException3) {
                }
            }
        }
        return new BASE64Encoder().encode(out.toByteArray());
    }

    /**
     * 解压
     * @param compressedStr
     * @return
     */
    public static final String ungzipString(String compressedStr) {
        if (compressedStr == null) {
            return null;
        }
        ByteArrayOutputStream out = null;
        ByteArrayInputStream in = null;
        GZIPInputStream gin = null;
        String decompressed = null;
        try {
            byte[] compressed = new BASE64Decoder().decodeBuffer(compressedStr);
            out = new ByteArrayOutputStream();
            in = new ByteArrayInputStream(compressed);
            gin = new GZIPInputStream(in);
            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = gin.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed = out.toString("UTF-8");
        } catch (IOException e) {
            decompressed = null;
        } finally {
            if (gin != null) {
                try {
                    gin.close();
                } catch (IOException localIOException7) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException localIOException8) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException localIOException9) {
                }
            }
        }
        return decompressed;
    }
}