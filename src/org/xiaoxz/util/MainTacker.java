package org.xiaoxz.util;

import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author
 * 2017年2月24日  
 * TODO
 *
 */
public class MainTacker extends TimerTask{

	public static void main(String[] args){
		 String time = PropsUtils.getTime();
		 Timer timer = new Timer();
		 timer.schedule(new MainTacker() ,0,1000*60*10);
	}

	@Override
	public void run() {
		long time = Long.valueOf(PropsUtils.getTime());
		System.out.println("每隔 10 分钟查询一次项目附件表!");
		 ITasker tasker = new TaskerImpl();
			MyInvocationHandler handler = new MyInvocationHandler(tasker);
			ITasker task = (ITasker) Proxy.newProxyInstance(handler.getClass().getClassLoader(), 
					tasker.getClass().getInterfaces(), handler);
			task.execute();
	}
}
