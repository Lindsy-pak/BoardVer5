package com.Lindsy.board5.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Lindsy.board5.DBUtils;

public class CmtDAO {
	public static void insCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "INSERT INTO t_board_cmt (iboard, iuser, cmt)"
				+ " VALUES (?, ?, ?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			ps.setString(3, param.getCmt());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static List<CmtVO> selCmtList(int iboard) { //어느글의 댓글인지 알아야하므로 iboard가 필요하다 
		List<CmtVO> list = new ArrayList(); //댓글 담는 객체 
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; //select 문은 rs가 있어야함. (update는 결과를 가져올 필요가 없다.기능이 실행이 되기만 하면 되기 때문이다.
		
		String sql = "SELECT A.icmt, A.cmt, A.regdate, B.unm"
				+ " FROM t_board_cmt A"
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser"
				+ " WHERE iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			while(rs.next()) {
				CmtVO vo =  new CmtVO();
				list.add(vo);
				
				vo.setIcmt(rs.getInt("icmt")); // 서로 다른 테이블에 같은 컬럼이름의 컬럼이 있으면 알리아스를 무조건 적어줘야한다. 
				vo.setCmt(rs.getString("cmt"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setUnm(rs.getString(("unm")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}
	public static void delCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM t_board_cmt"
				+ " WHERE icmt = ? AND iuser = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			ps.setString(3, param.getCmt());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
}
