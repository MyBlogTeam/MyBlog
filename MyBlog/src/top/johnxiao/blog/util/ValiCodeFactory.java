package top.johnxiao.blog.util;

import java.util.Random;

public class ValiCodeFactory {

	public static String CreateValidCode(int length){
		String str = "0,1,2,3,4,5,6,7,8,9," 
					+"a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z," 
					+"A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
		String[] codeList = str.split(",");
		String code = "";
		Random rd = new Random();
		for (int i = 0; i < length; i++) {
			code += codeList[rd.nextInt(codeList.length)];
		}
		return code;
	}
}
