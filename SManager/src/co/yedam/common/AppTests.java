package co.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import co.yedam.vo.StudentVo;

public class AppTests {
	public static Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String user="jsp";
		String pass = "jsp";
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pass);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 드라이버 없음.");
			e.printStackTrace();
			return null;
		}
		return conn;

	}
	public static void main(String[] args) {
		// 1) Oracle JDBC Driver 자바라이브러리.
		// 2) Connection 객체.
		Scanner scn = new Scanner(System.in);
//		System.out.print(">학생번호 입력 : ");
//		String sno = scn.nextLine();
//		System.out.print(">학생이름 입력 : ");
//		String sname = scn.nextLine();
//		System.out.print(">연락처 입력 : ");
//		String phon = scn.nextLine();
//		addStudent(sno,sname,phon);
//		System.out.print(">수정할 컬럼 : ");
//		String up1 = scn.nextLine();
//		System.out.print(">수정할 데이터 : ");
//		String up2 = scn.nextLine();
//		System.out.print(">수정할 대상의 컬럼 : ");
//		String where = scn.nextLine();
//		System.out.print(">수정할 대상 : ");
//		String where2 = scn.nextLine();		
		System.out.print(">학생번호 입력 : ");
		String sno = scn.nextLine();
		System.out.print(">학생이름 입력 : ");
		String sname = scn.nextLine();
		System.out.print(">연락처 입력 : ");
		String phon = scn.nextLine();
		System.out.print(">주소 입력 : ");
		String add = scn.nextLine();
		System.out.print(">생일 입력 : ");
		String birth = scn.nextLine();		
//		god();
//		modStudent(up1, up2, where,where2);
//		 // 입력.
		StudentVo std = new StudentVo();
		std.setStdNo(sno);
		std.setStdName(sname);
		std.setStdPhone(phon);;
		std.setStdAddress(add);
		std.setBirthDate(birth);;
		modStu(std);
		search();  // 목록조회
	}
	//삭제기능
	public static void removeStudent(String stdNo) {
		Connection conn = getConn();
		String sql = "delete from tbl_student where std_no='"+stdNo+"'";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 수정 기능2
    // modStu(String stdNo, String stdName, String phone, String addr, String birth)
    public static void modStu(StudentVo svo) {
        Connection conn = getConn();
        String sql = "UPDATE tbl_student";
        sql += " set    std_name = nvl('" + svo.getStdName() + "', std_name)";
        sql += ",         std_phone = nvl('" + svo.getStdPhone() + "', std_phone)";
        sql += ",         address = nvl('" + svo.getStdAddress() + "', address)";
        sql += ",        birth_date = nvl('" + svo.getBirthDate() + "', birth_date)";
        sql += "WHERE     std_no = '" + svo.getStdNo() + "'";
        try {
            System.out.println(sql);
            Statement stmt = conn.createStatement();
            int r = stmt.executeUpdate(sql); // insert, update, delete => 처리된 건수를 리턴해준다.
            System.out.println("처리된 건수는 " + r + "건.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	// 수정기능
	public static void modStudent(String update1, String update2, String where, String where2) {
		Connection conn = getConn();
		String sql = "update tbl_student set "+update1+"='"+update2+"'where "+where+"='"+where2+"'";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	

	// 입력기능.
	public static void addStudent(String stdNo, String stdName, String phone) {
		Connection conn = getConn();
		String sql = "insert into tbl_student(std_no, std_name, std_phone)";
		sql += "values('"+stdNo+"','"+stdName+"','"+phone+"')";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert, update, delete => 처리된 건수.
			System.out.println("처리된 건수는 : "+r+"건");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void search() {
		// 조회기능
		try {
			Connection conn = getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tbl_student");
			//[객체1, 객체2, 객체2]
			while(rs.next()) {
				String birth = rs.getString("birth_date");
				birth = birth != null ? birth.substring(0,10) : "";
				System.out.println(rs.getString("std_no")+","+rs.getString("std_name")+","+rs.getString("std_address")+","+birth);
			}
			System.out.println("end of data.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		// 조회기능 끝.
	}
}
