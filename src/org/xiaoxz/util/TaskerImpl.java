package org.xiaoxz.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author
 * 2017年2月23日  
 * TODO
 *
 */
public class TaskerImpl implements ITasker{
	
	@Override
	public  void execute() {
		 String sql = PropsUtils.getSql();
	     Connection conn = DBManager.getConnection();
	     PreparedStatement state = null;
	     ResultSet rs = null;
	     String prjId = PropsUtils.getPrjId();
	     System.out.println(prjId);
		 try{
			 state = (PreparedStatement) conn.prepareStatement(sql);
			 state.setString(1,prjId);
			 rs = state.executeQuery();
			 while(rs.next()){
				 System.out.println("项目编号:"+prjId+" : "+rs.getString("seq")+"、"+rs.getString("attach_name")+rs.getString("full_name"));
			 }
			 System.out.println("查询完成!");
		 }catch(Exception e){
			 System.out.println("连接数据库异常");
			 e.printStackTrace();
		 }finally{
			 System.out.println("关闭所有资源...............");
			 DBManager.closeConnection(conn,state,rs);
		 }
		 
	}
}
