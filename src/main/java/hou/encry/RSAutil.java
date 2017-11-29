package hou.encry;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/28.
 */
public class RSAutil {

    /**
     * 初始化私钥公钥
     * @param keysize
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static Map init(int keysize) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen= KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(keysize);
        KeyPair keyPair=keyPairGen.generateKeyPair();
        Key privateKey= keyPair.getPrivate();
        Key publicKey= keyPair.getPublic();
        Map<String,String> map=new HashMap<String,String>();
        map.put("privateKey", new BASE64Encoder().encode(privateKey.getEncoded()));
        map.put("publicKey", new BASE64Encoder().encode(publicKey.getEncoded()));
        return map;
    }

    /**
     * 签名
     * @param data
     * @param key
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     * @throws InvalidKeySpecException
     * @throws InvalidKeyException
     * @throws SignatureException
     */
    public static String sign(String data,String key) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, InvalidKeyException, SignatureException {

        PKCS8EncodedKeySpec pkcs8=new PKCS8EncodedKeySpec(new BASE64Decoder().decodeBuffer(key));
        PrivateKey privateKey =  KeyFactory.getInstance("RSA").generatePrivate(pkcs8);
        Signature signit= Signature.getInstance("SHA1withRSA");
        signit.initSign(privateKey);
        signit.update(data.getBytes("utf-8"));
        return new BASE64Encoder().encode(signit.sign());
    }

    public boolean verify(String data,String sign,String publickey) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        X509EncodedKeySpec x509Encode=new X509EncodedKeySpec(new BASE64Decoder().decodeBuffer(publickey));
        PublicKey publicKey= KeyFactory.getInstance("RSA").generatePublic(x509Encode);
        Signature signit=Signature.getInstance("SHA1withRSA");
        signit.initVerify(publicKey);
        signit.update(data.getBytes("UTF-8"));
        System.out.println(String.format("the check result is %s",signit.verify(new BASE64Decoder().decodeBuffer(sign))));
        return false;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, SignatureException, InvalidKeySpecException, InvalidKeyException, IOException {
//        testPublicAndPrivate();
//        testSign();
          testVerify();
    }

    private static void testVerify() throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        Map map=init(1024);
        //hxFRK3EzBNbDKqxHBvfg4pbDk7H6YC6kev4lhYmC60a5wadx+wDKK+oNc4jaQt4UPSQh1FworkBZYQewt20THKAjwlGfr0jUA2K2xWMnOFEfKYt1Poehd87h7vH6B9xHEZMtsarWPXsKAVCfMTeTSH0wd0WtQ3+53nbrTgf66xg=
//        String sign=sign("i love u",(String) map.get("privateKey"));
        String sign="ZLwLXgRDbh/SstrTFSiJRiXJO5TEMNl+qQ43hOjUKG96x5jx7Bnn5uEgn5d1ZvHb3Jz1Cv+XSk5u\r\n" +
                "xNEGi+XO6Z33QFRH5MEbI5bz89++LvtfI9cOTvUDog9yl1NJEB9zrEYrBHSF369xpiJ/gUSPlL5L\r\n" +
                "Mb3Firw7yMY+pduwAf0=";
        System.out.println(sign+"...."+sign.length());

        X509EncodedKeySpec x509Encode=new X509EncodedKeySpec(new BASE64Decoder().decodeBuffer((String) map.get("publicKey")));
        PublicKey publicKey= KeyFactory.getInstance("RSA").generatePublic(x509Encode);
        Signature signit=Signature.getInstance("SHA1withRSA");
        signit.initVerify(publicKey);
        signit.update("i love u".getBytes("UTF-8"));
        System.out.println(String.format("the check result is %s",signit.verify(new BASE64Decoder().decodeBuffer(sign))));
    }

    private static void testSign() throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        Map map=init(1024);
        System.out.println(String.format("跳入data：%s,填入key :%s","i love u",map.get("privateKey")));
        String signString=sign("i love u",(String) map.get("privateKey"));
        System.out.println(String.format("签名为%s",signString));
    }

    private static void testPublicAndPrivate() throws NoSuchAlgorithmException {
        Map map=init(1024);
        System.out.println(String.format("公钥-----》%s",map.get("publicKey")));
        System.out.println("=====我也是有底线的=====");
        System.out.println(String.format("私钥-----》%s",map.get("privateKey")));
    }
}
