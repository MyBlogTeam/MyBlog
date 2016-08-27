package top.johnxiao.blog.encrypt;

import com.softeem.encrypt.MD5;

/**
 * MD5加密封装
 * @author 肖伟
 *
 */
public class StrToMD5 {
	
/**
 * MD5加密
 * @param str：输入需要加密的字符串
 * @return：返回MD5加密后的字符串
 */
	public static String getMd5Str(String str){
		MD5 md5=new MD5();
		String md5Str=getMd5Str(str);
		return md5Str;
	}

}
