package com.heygis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.heygis.beans.ForumThread;
import com.heygis.beans.ForumsThreadPage;
import com.heygis.dao.interfaces.ForumThreadDAO;
import com.heygis.service.AddPostService;
import com.lovegis.pojo.ForumPost;

public class ForumThreadDAOImpl extends DAOSupport implements ForumThreadDAO {

	@Override
	public boolean addThread(ForumThread thread, ForumPost post) {
		String sql = "insert into forum_thread (fid,typeid,sortid,author,author_uid,"
				+ "author_account,subject,dateline,lastpost,attachment)values(?,?,?,?,?,?,?,?,?,?);";
		this.openConn();
		if(this.execUpdate(sql, thread.getFid(),thread.getTypeid(),thread.getSortid(),thread.getAuthor(),
				thread.getAuthorUid(),thread.getAuthorAuthor(),thread.getSubject(),new Date().getTime(),
				new Date().getTime(),thread.getAttachment())==1){
			int tid = this.LAST_INSERT_ID();
//			System.out.println(tid);
			this.close();
			post.setTid(tid);
			AddPostService aps = AddPostService.getInstance();
			aps.getFpdi().addPost(post);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean delThread(int tid) {
		String sql = "update forum_thread display=0 where tid=?;";
		this.openConn();
		if(this.execUpdate(sql,tid) == 1){
			this.close();
			return true;
		}else{
			this.close();
			return false;
		}
	}

	@Override
	public ForumsThreadPage getThreadPage(int fid, int page) {
		int begin = (page-1) * 30;
		int end = 30 ;
		String sql = "select forum_thread.*,users_info.nickname from forum_thread,users_info "
				+ "where forum_thread.author_uid=users_info.uid and fid=? and display=1 order by lastpost DESC limit ?,?;";
		this.openConn();
		ForumsThreadPage threadPage = new ForumsThreadPage(fid,page);  //一页的bean//也是就是送到前端的数据对象
		ResultSet count = this.execQuery("select count(*) from forum_thread where fid=? and display=1",fid);//获取该页的所有数据
		try {
			while(count.next()){
				threadPage.setTotalThreadNum(count.getInt(1));//设置页数
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ResultSet rs = this.execQuery(sql, fid, begin, end);//参数分别是区域，开始数和结束的数//限量从数据库中读取
		int i = 0;
		try{
			while(rs.next()){
				threadPage.setThread(i, new ForumThread(  //放入数据 ：生成匿名bean对象（一行数据的bean）放到threadpage（一页数据的bean）
						rs.getInt(1), 
						rs.getInt(2), 
						rs.getInt(3), 
						rs.getInt(4), 
						rs.getString(18), 
						rs.getInt(6), 
						rs.getString(7), 
						rs.getString(8), 
						new Date(rs.getLong(9)),
						new Date(rs.getLong(10)),
						rs.getString(11), 
						rs.getInt(12), 
						rs.getInt(13), 
						rs.getInt(14), 
						rs.getInt(15), 
						rs.getInt(16), 
						rs.getInt(17)));
				i++;
			}
//			System.out.println("has closed");
			this.close();
			return threadPage;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(!this.conn.isClosed()){
					System.out.println("finallclose");}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public ForumsThreadPage getThreadPageByUid(int uid, int page) {
		int begin = (page-1) * 30;
		int end = 30 ;
		String sql = "select forum_thread.*,users_info.nickname from forum_thread,users_info "
				+ "where forum_thread.author_uid=users_info.uid and author_uid=? and display=1 order by dateline desc limit ?,?;";
		this.openConn();
		ResultSet rs = this.execQuery(sql, uid, begin, end);
		ForumsThreadPage threadPage = new ForumsThreadPage(0,page);
		int i = 0;
		try{
			while(rs.next()){
				threadPage.setThread(i, new ForumThread(
						rs.getInt(1), 
						rs.getInt(2), 
						rs.getInt(3), 
						rs.getInt(4), 
						rs.getString(18), 
						rs.getInt(6), 
						rs.getString(7), 
						rs.getString(8), 
						new Date(rs.getLong(9)),
						new Date(rs.getLong(10)),
						rs.getString(11), 
						rs.getInt(12), 
						rs.getInt(13), 
						rs.getInt(14), 
						rs.getInt(15), 
						rs.getInt(16), 
						rs.getInt(17)));
				i++;
			}
//			System.out.println("has closed");
			this.close();
			return threadPage;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(!this.conn.isClosed()){
					System.out.println("finallclose");}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
