package org.xiaoxz.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author
 * 2017��2��23��  
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
				 System.out.println("��Ŀ���:"+prjId+" : "+rs.getString("seq")+"��"+rs.getString("attach_name")+rs.getString("full_name"));
			 }
			 System.out.println("��ѯ���!");
		 }catch(Exception e){
			 System.out.println("�������ݿ��쳣");
			 e.printStackTrace();
		 }finally{
			 System.out.println("�ر�������Դ...............");
			 DBManager.closeConnection(conn,state,rs);
		 }
		 
	}
}
