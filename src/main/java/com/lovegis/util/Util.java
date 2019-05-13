package com.lovegis.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.swing.Spring;
import org.apache.log4j.Logger;

import com.lov.service.LoginService;

public class Util {
	public static Logger logger=Logger.getLogger(LoginService.class);
	public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		 //确定计算方法
		// MessageDigest md5=MessageDigest.getInstance("MD5");
		
	    // BASE64Encoder base64en = new BASE64Encoder(); 
		 Base64.Encoder encoder = Base64.getEncoder();//sfy 
		 
		 //加密后的字符串
		 //String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
		 
		 String newstr = encoder.encodeToString(str.getBytes("utf-8"));//sfy 
		 return newstr;
	 }
	public static boolean base64ToImg(String base64,String icon_imgPath){
	
		Base64.Decoder decoder = Base64.getDecoder();
		try {
			if (base64 == null) { // 
	            throw new Exception("图像数据为空");
			}
			// Base64解码
			byte[] bytes = decoder.decode(base64);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			// 生成jpeg图片
			OutputStream out = new FileOutputStream(icon_imgPath);
			out.write(bytes);
			out.flush();
			out.close();
				return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
