package com.jd.utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.jcajce.provider.BouncyCastlePQCProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.tree.TreeNode;
import java.nio.charset.StandardCharsets;
import java.security.Security;
import java.util.Base64;

public class AESUtils {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS7Padding";

    public static String encrypt(String data, String key) throws Exception {
        //生成AES密钥
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM);
        //初始化Cipher
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        //加密数据
        byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedData, String key) throws Exception {
        // Base64 解码
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);

        // 提取 IV（与前端一致）
        byte[] iv = "1234567890123456".getBytes(StandardCharsets.UTF_8); // 16字节的IV

        // 生成 AES 密钥
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

        // 初始化 Cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(iv));

        // 解密数据
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}
