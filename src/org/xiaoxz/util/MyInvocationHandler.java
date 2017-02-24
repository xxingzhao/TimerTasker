package org.xiaoxz.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author
 * 2017��2��24��  
 * TODO
 *
 */
public class MyInvocationHandler implements InvocationHandler{

	private Object target;
	
	public MyInvocationHandler(Object target){
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		String now = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //��ȡ��ǰϵͳʱ��
		long startTimes = System.currentTimeMillis();        //��ȡ��ǰִ�з���ǰ������
		Object retVal = method.invoke(target, args);         //ִ��Ŀ�귽��
		long endTimes = System.currentTimeMillis();           //��ȡִ�з����������
		now = df.format(new Date());
		String content = now + "��ѯ APPR_PROJ_ATTACHMENT ��Ŀ������ ���ķ��� "+(endTimes-startTimes)+"���롢 "+((endTimes-startTimes)/1000)+"��"+System.getProperty("line.separator");
		wirteData(content);
		return retVal;
	}
	
	private static void wirteData(String content) throws Exception{
		String path = System.getProperty("user.dir");
		OutputStream out = new FileOutputStream(path+File.separator+"data.txt",true);
		out.write(content.getBytes());
		out.close();
	}

}
