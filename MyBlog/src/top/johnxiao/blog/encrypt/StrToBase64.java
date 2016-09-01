package top.johnxiao.blog.encrypt;

import it.sauronsoftware.base64.Base64;

/**
 * Base64加密与解密
 * @author 肖伟
 *
 */
public class StrToBase64 {
	
	/**
	 * 获取加密后的字符
	 * @param str：输入待加密的字符
	 * @return：返回已加密字符
	 */
	public static String getEnCodeStr(String str){
		String encStr = Base64.encode(str);
		return encStr;
	}
	
	/**
	 * 获取解密字符
	 * @param encStr:输入已加密字符
	 * @return：返回解密后的字符
	 */
	public static String getDeCodeStr(String encStr){
		String decStr =Base64.decode(encStr);
		return decStr;
	}

}
