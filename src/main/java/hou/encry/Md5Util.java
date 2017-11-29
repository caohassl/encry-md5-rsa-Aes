package hou.encry;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/11/29.
 */
public class Md5Util {

    private static final char[] HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String md5encry(String data) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md=MessageDigest.getInstance("MD5");
        byte[] bytes=md.digest(data.getBytes("UTF-8"));

        return new String(encodeHex(bytes)).toUpperCase();
//        return new BigInteger(1, bytes).toString(16);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String bizData=md5encry("i am Caomr");
        //a7931fddc426e530fd1dce02c4b43fa2
        //A7931FDDC426E530FD1DCE02C4B43FA2
        System.out.println(bizData);
    }

    private static char[] encodeHex(byte[] bytes) {
        char[] chars = new char[32];

        for (int i = 0; i < chars.length; i += 2) {
            byte b = bytes[i / 2];
            chars[i] = HEX_CHARS[b >>> 4 & 15];
            chars[i + 1] = HEX_CHARS[b & 15];
        }
        return chars;
    }
}
