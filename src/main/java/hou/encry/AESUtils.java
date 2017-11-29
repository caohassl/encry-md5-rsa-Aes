package hou.encry;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/11/29.
 */
public class AESUtils {
    public static String key="Caomr";

    public static SecretKeySpec getKey(String key) throws UnsupportedEncodingException {
        byte[] bytes=key.getBytes("UTF-8");
        byte[] tem=new byte[16];
        for(int i=0;i<bytes.length&&i<tem.length;i++){
            tem[i]=bytes[i];
        }
        SecretKeySpec secretKeySpec=new SecretKeySpec(tem,"AES");
        return secretKeySpec;
    }

    public static String encry(String data,String key) throws NoSuchPaddingException, NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec=getKey(key);
        IvParameterSpec in=new IvParameterSpec("1111222233334444".getBytes());
        cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec,in);
        byte[] bytes=cipher.doFinal(data.getBytes("UTF-8"));
        return  new BASE64Encoder().encode(bytes);
    }

    public static String decry(String encry,String key) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeyException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException {
        byte[] bytes=new BASE64Decoder().decodeBuffer(encry);
        Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec=getKey(key);
        IvParameterSpec in=new IvParameterSpec("1111222233334444".getBytes());
        cipher.init(Cipher.DECRYPT_MODE,secretKeySpec,in);
        byte[] bytes1=cipher.doFinal(bytes);
        return new String(bytes1,"UTF-8");
    }

    public static void main(String args[]) throws NoSuchPaddingException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, IOException, InvalidKeyException {
        String data="i am Caomr";
        String encry=encry(data,key);
        System.out.println("the encry is :"+encry);
        System.out.println("............");
        String decry=decry(encry,key);
        System.out.println("the decry is :"+decry);
        if(data.equals(decry)){
            System.out.println("the check result is true!");
        }
    }
}
