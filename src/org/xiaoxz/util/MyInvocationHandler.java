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
 * 2017年2月24日  
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
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //获取当前系统时间
		long startTimes = System.currentTimeMillis();        //获取当前执行方法前毫秒数
		Object retVal = method.invoke(target, args);         //执行目标方法
		long endTimes = System.currentTimeMillis();           //获取执行方法后毫秒数
		now = df.format(new Date());
		String content = now + "查询 APPR_PROJ_ATTACHMENT 项目附件表 共耗费了 "+(endTimes-startTimes)+"毫秒、 "+((endTimes-startTimes)/1000)+"秒"+System.getProperty("line.separator");
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
