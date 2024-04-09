package jdbcBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.DatabaseConnection;


public class BoardDAOImpl implements DAO {
	
	private Connection conn;
	private PreparedStatement pst;
	private String query="";
	public BoardDAOImpl() {
		DatabaseConnection dbc=DatabaseConnection.getInstance();
		conn=dbc.getConnection();
	}
	
	

	@Override
	public int insert(BoardVO b) {
		System.out.println("insert DAOImpl succes!!");
		query = "insert into board(title, writer, content) values(?, ?, ?)";
		try {
			pst=conn.prepareStatement(query);
			pst.setString(1, b.getTitle());
			pst.setString(2, b.getWriter());
			pst.setString(3, b.getContent());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert error");
			e.printStackTrace();
		}
		return 0;
	}



	@Override
	public BoardVO serach(int bno) {
		System.out.println("serach DAOIlmpl succes!!");
		query="select*from board where bno=?";
		try {
			pst=conn.prepareStatement(query);
			pst.setInt(1, bno);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				return new BoardVO(
						rs.getInt("bno"),
						rs.getString("title"),
						rs.getString("writer"),
						rs.getString("content"),
						rs.getString("regdate"),
						rs.getString("moddate")
						);
			}
		} catch (Exception e) {
			System.out.println("serach error!");
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public int update(BoardVO b) {
		System.out.println("update DAOImplu sucess");
		query="update board set title=?, writer=?,content=?,"
				+ "modate=now() where bno=?";
		
		try {
			pst=conn.prepareStatement(query);
			pst.setString(1, b.getTitle());
			pst.setString(2, b.getWriter());
			pst.setString(3, b.getContent());
			pst.setInt(4, b.getBno());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update error!!");
			e.printStackTrace();
		}
		return 0;
	}



	@Override
	public int delete(int bno) {
		System.out.println("delete DAOImpuls succes");
		query="delete from board where bno=?";
		try {
			pst=conn.prepareStatement(query);
			pst.setInt(1, bno);
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("delete error");
			e.printStackTrace();
		}
		return 0;
	}



	@Override
	public List<BoardVO> list() {
		System.out.println("list DAOIMPULS SUCCESS");
		query="select*from board order by bno desc";
		List<BoardVO> list=new ArrayList<>();
		try {
			pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				list.add(new BoardVO(rs.getInt("bno"), rs.getString("title"), rs.getString("writer"), rs.getString("content"), rs.getString("regdate"), rs.getString("moddate")));
			}
			return list;
			
		} catch (Exception e) {
			System.out.println("list error");
			e.printStackTrace();
		}
		return null;
	}

}
