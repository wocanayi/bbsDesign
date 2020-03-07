package com.qtt.bbs.common.util;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;

/**
 * Project name：bbsDesign
 * Class name：AesCbcUtil
 * description：TODO
 * date：2020/2/22 11:01
 *
 * @author ：XC
 */
public class AesCbcUtil {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * AES解密
     * @param data 密文，被加密的数据
     * @param key 密钥
     * @param iv 偏移量
     * @param encodingFormat 解密后的结果需要进行的编码
     * @return
     */
    public static String decrypt(String data, String key, String iv, String encodingFormat) {
        byte[] dataBytes = Base64.decodeBase64(data);
        byte[] keyBytes = Base64.decodeBase64(key);
        byte[] ivBytes = Base64.decodeBase64(iv);

        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            SecretKeySpec spec = new SecretKeySpec(keyBytes, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivBytes));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);
            byte[] resultByte = cipher.doFinal(dataBytes);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, encodingFormat);
                return result;
            }
            return null;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException | InvalidKeyException | UnsupportedEncodingException | InvalidParameterSpecException e) {
            e.printStackTrace();
        }
        return null;
    }
}
