package co.yedam.control;

import java.util.List;
import java.util.Scanner;

import co.yedam.dao.StudentDAO;
import co.yedam.vo.StudentVo;

// 사용자 입력을 가이드, 처리된 결과 출력.
public class StudentControl {
	Scanner sc = new Scanner(System.in);
	StudentDAO sdao = new StudentDAO();
	
	public void run() {
		boolean isTrue = true;
		
		while(isTrue) {
			System.out.println("1.학생목록 2.등록 3.수정 4.삭제 5.종료");
			System.out.println("선택 > ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1:
				studentlist();
				break;
			case 2:
				addStudent();
				break;
			case 3:
				updateStudent();
				break;
			case 4:
				delStudent();
				break;
			case 5:
				System.out.println("프로그램 종료");
				isTrue = false;
			}
		}
	}// end of run().
	// 등록기능
	void addStudent() {
		System.out.print(">학생번호 입력 : ");
		String sno = sc.nextLine();
		System.out.print(">학생이름 입력 : ");
		String sname = sc.nextLine();
		System.out.print(">연락처 입력 : ");
		String phon = sc.nextLine();
		System.out.print(">주소 입력 : ");
		String add = sc.nextLine();
		System.out.print(">생일 입력 : ");
		String birth = sc.nextLine();	
		
		StudentVo std = new StudentVo();
		std.setStdNo(sno);
		std.setStdName(sname);
		std.setStdPhone(phon);;
		std.setStdAddress(add);
		std.setBirthDate(birth);;
		
		if(sdao.insertStudent(std)) {
			System.out.println("저장완료!");
		}else {
			System.out.println("처리중 예외발생");
		}
	}
	// 목록 출력 기능.
	void studentlist() {
		List<StudentVo> students =  sdao.selectList();
		System.out.println("학생번호  학생이름  연락처");
		System.out.println("--------------------");
		for(StudentVo svo : students) {
			System.out.println(svo.briefShow());
		}
	} // end of studentlist
	void updateStudent() {
		System.out.print(">학생번호 입력 : ");
		String sno = sc.nextLine();
		System.out.print(">학생이름 입력 : ");
		String sname = sc.nextLine();
		System.out.print(">연락처 입력 : ");
		String phon = sc.nextLine();
		System.out.print(">주소 입력 : ");
		String add = sc.nextLine();
		System.out.print(">생일 입력 : ");
		String birth = sc.nextLine();		
//		god();
//		modStudent(up1, up2, where,where2);
//		 // 입력.
		StudentVo std = new StudentVo();
		std.setStdNo(sno);
		std.setStdName(sname);
		std.setStdPhone(phon);
		std.setStdAddress(add);
		std.setBirthDate(birth);
		if(sdao.modStu(std)) {
			System.out.println("저장완료!");
		}else {
			System.out.println("처리중 예외발생");
		}		
	}
	void delStudent() {
		System.out.print("> 삭제할 학생 번호 : ");
		String sno = sc.nextLine();	
		if(sdao.removeStudent(sno)) {
			System.out.println("저장완료!");
		}else {
			System.out.println("처리중 예외발생");
		}			
	}	
}