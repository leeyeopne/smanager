package co.yedam.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.yedam.vo.GYMVo;
import co.yedam.vo.StudentVo;

// 목록, 등록, 수정, 삭제
// 주의 : DAO 메세지(sysou)가 없음.
public class GYMDAO extends GYMDAO2{

	// 등록기능.
	public boolean insertMember(GYMVo svo) {
		String sql = "insert into GYM(memberId, memberName, age, memberSex, phone,address,trainer)";
		sql += "values(seq.NEXTVAL, ?,?,?,?,?)";
		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, 1);
			psmt.setString(2, svo.getMemberName());
			psmt.setInt(3, svo.getAge());
			psmt.setInt(4, svo.getMemberSex());
			psmt.setString(5, svo.getPhone());
			psmt.setString(6, svo.getAddress());
			psmt.setString(7, svo.getTrainer());
			
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
//	private String memberId; //std_no
//	private String memberName; 
//	private int age; 
//	private int memberSex; 
//	private int phone; 
//	private String address; 
//	private Date startDay;
//	private String trainer; 
	// 목록반환기능.
	public List<GYMVo> selectList(){
		String sql = "select * from GYM order by memberId";
		List<GYMVo> list = new ArrayList<>();
		
		conn = getConn();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				GYMVo svo = new GYMVo();
				svo.setMemberId(rs.getInt("memberId"));
				svo.setMemberName(rs.getString("memberName"));
				svo.setAge(rs.getInt("age"));
				svo.setMemberSex(rs.getInt("memberSex"));
				svo.setPhone(rs.getString("phone"));
				svo.setAddress(rs.getString("address"));
				svo.setStartDay(rs.getDate("startDay"));
				svo.setTrainer(rs.getString("trainer"));
				list.add(svo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}// end
	
	//단건조회.
	public int selectExists(String sno) {
		String sql = "select count(1) from tbl_student";
		sql += "	where std_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sno);
			rs = psmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	// 수정기능
    public boolean modStu(StudentVo svo) {
		String sql = "update tbl_student";
		sql += " set std_phone = ?";
		sql += " 	 ,address = ?";
		sql += "  	 where std_no = ?";
		List<StudentVo> list = new ArrayList<>();
		
		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(3, svo.getStdNo());
			psmt.setString(1, svo.getStdPhone());
			psmt.setString(2, svo.getStdAddress());
			int r = psmt.executeUpdate();
			if(r == 1) {
				return true; // 정상처리
			}					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

//        Connection conn = getConn();
//        String sql = "UPDATE tbl_student";
//        sql += " set    std_name = nvl('" + svo.getStdName() + "', std_name)";
//        sql += ",         std_phone = nvl('" + svo.getStdPhone() + "', std_phone)";
//        sql += ",         std_address = nvl('" + svo.getStdAddress() + "', std_address)";
//        sql += ",        birth_date = nvl('" + svo.getBirthDate() + "', birth_date)";
//        sql += "WHERE     std_no = '" + svo.getStdNo() + "'";
//        try {
//            Statement stmt = conn.createStatement();
//           int r = stmt.executeUpdate(sql); // insert, update, delete => 처리된 건수를 리턴해준다.
//			if(r == 1) {
//				return true; // 정상처리
//			}
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
    }
	//삭제기능
	public boolean removeStudent(String stdNo) {
		Connection conn = getConn();
		String sql = "delete from tbl_student where std_no='"+stdNo+"'";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);	
			if(r == 1) {
				return true; // 정상처리
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}	
}
