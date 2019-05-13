package com.heygis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.heygis.beans.ForumPostPage;
import com.heygis.dao.interfaces.ForumPostDAO;
import com.lovegis.pojo.ForumPost;

public class ForumPostDAOImpl extends DAOSupport implements ForumPostDAO {

	@Override
	public synchronized int addPost(ForumPost post) {
		String sql = "select count(pid) from forum_post;";
		this.openConn();
		ResultSet rs = this.execQuery(sql);
		int pid = 0;
		try {
			if(rs.next())
				pid = rs.getInt(1)+1;  //根据查询的pid（最后一个序号）+1作为新的序号（sfy为什么不设置成自增）
//			System.out.println("pid="+pid);
			sql = "insert into forum_post (pid,fid,tid,first,author,author_uid,author_account"
					+ ",subject,dateline,message,userip,attachment) values (?,?,?,?,?,?,?,?,?,?,?,?);";
			if(this.execUpdate(sql, pid ,post.getFid(),post.getTid(),post.getFirst(),post.getAuthor(),
					post.getAuthorUid(),post.getAuthorAccount(),post.getSubject(),new Date().getTime(),post.getMessage(),
					post.getUserip(),post.getAttchment()) == 1){//如果插入成功
				sql = "update forum_thread SET lastpost=? ,lastposter=? ,replies=replies+1 where tid=?;";//更新帖子的最后一个提交者
				this.execUpdate(sql, new Date().getTime(),post.getAuthor(),post.getTid());
				int posi = this.LAST_INSERT_ID();//返回最后一个主键
				this.close();
				return posi;
			}else{
				this.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(!this.conn.isClosed())
					this.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public boolean delPost(int pid) {
		String sql = "update forum_post set message=? where pid=?;";
		this.openConn();
		if(this.execUpdate(sql, "此楼被删除", pid) == 1){
			this.close();
			return true;
		}else{
			this.close();
			return false;
		}
	}

	//@SuppressWarnings("finally")
	@Override
	public ForumPostPage getPostPage(int tid, int page) {
		int begin = (page-1) * 30;
		int end = 30;
		String sql = "select forum_post.*,users_info.nickname,users_info.icon_img "
				+ "from forum_post,users_info "
				+ "where forum_post.author_uid=users_info.uid and tid =? limit ?,?;";
		this.openConn();
		ForumPostPage postPage = new ForumPostPage(tid,page);
		ResultSet count = this.execQuery("select count(*) from forum_post where tid =?", tid);
		try {
			while(count.next()){
				postPage.setTotalPostNum(count.getInt(1));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ResultSet rs = this.execQuery(sql, tid, begin, end);
		postPage.setTid(tid);
		int i = 0;
		try {
			while(rs.next()){
				postPage.setPost(i, new ForumPost(
						rs.getInt(1), 
						rs.getInt(2), 
						rs.getInt(3), 
						rs.getInt(4), 
						rs.getString(14),
						rs.getInt(6), 
						rs.getString(7),
						rs.getString(8),
						new Date(rs.getLong(9)),
						rs.getString(10),
						rs.getString(11),
						rs.getInt(12),
						rs.getInt(13),
						rs.getString(15)));
				i++;
//				System.out.println(i+","+begin+","+end);
			}
			sql = "update forum_thread SET views=views+1 where tid=?;";
			this.execUpdate(sql, tid);
			this.close();
			return postPage;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(!this.conn.isClosed())
					this.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public String getPostMessage(int pid) {
		String sql = "select message from forum_post where pid = ?";
		this.openConn();
		ResultSet rs = this.execQuery(sql, pid);
		String message = null;
		try {
			while(rs.next()){
				message = rs.getString("message");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(!this.conn.isClosed())
					this.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//		this.close();
		return message;
	}
	
}
