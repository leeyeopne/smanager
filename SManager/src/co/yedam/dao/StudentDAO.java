package co.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.vo.StudentVo;

// 목록, 등록, 수정, 삭제
// 주의 : DAO 메세지(sysou)가 없음.
public class StudentDAO extends DAO{
	
	// 등록기능.
	public boolean insertStudent(StudentVo svo) {
		String sql = "insert into tbl_student(std_no, std_name, std_phone, std_address, birth_date)";
		sql += "values(?,?,?,?,?)";
		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, svo.getStdNo());
			psmt.setString(2, svo.getStdName());
			psmt.setString(3, svo.getStdPhone());
			psmt.setString(4, svo.getStdAddress());
			psmt.setString(5, svo.getBirthDate());
			
			int r = psmt.executeUpdate();//쿼리실행
			if(r == 1) {
				return true; // 정상처리
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false; // 비정상처리
	}
	
	// 목록반환기능.
	public List<StudentVo> selectList(){
		String sql = "select * from tbl_student order by std_no";
		List<StudentVo> list = new ArrayList<>();
		
		conn = getConn();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				StudentVo svo = new StudentVo();
				svo.setStdAddress(rs.getString("std_address"));
				svo.setBirthDate(rs.getString("birth_date"));
				svo.setCreationDate(rs.getDate("creation_date"));
				svo.setStdName(rs.getString("std_name"));
				svo.setStdNo(rs.getString("std_no"));
				svo.setStdPhone(rs.getString("std_phone"));
				list.add(svo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}// end
}
