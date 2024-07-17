package co.yedam.control;

import java.util.List;
import java.util.Scanner;

import co.yedam.dao.GYMDAO;
import co.yedam.vo.GYMVo;
import co.yedam.vo.StudentVo;

// 사용자 입력을 가이드, 처리된 결과 출력.
public class GYMControl {
	Scanner sc = new Scanner(System.in);
	GYMDAO sdao = new GYMDAO();
	
	
	public void run() {
		boolean isTrue = true;
		System.out.println("======================================");
		System.out.println("         헬스장 회원관리 프로그램");
		System.out.println("======================================");
		while(isTrue) {
			System.out.println("1.회원등록  2.회원정보수정 3.회원목록 4.회원상세정보 5.종료");
			System.out.println("선택 > ");
			int menu = Integer.parseInt(sc.nextLine());

			switch(menu) {
			case 1:
				selectList();
				break;
			case 2:
				addStudent();
				break;
			case 3:
				modifyStudent();
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
		
//		StudentVo std = new StudentVo();
//		std.setStdNo(sno);
//		std.setStdName(sname);
//		std.setStdPhone(phon);;
//		std.setStdAddress(add);
//		std.setBirthDate(birth);
//		
////		if(sdao.insertStudent(std)) {
//			System.out.println("저장완료!");
//		}else {
//			System.out.println("처리중 예외발생");
//		}
	}
	// 목록 출력 기능.
	void selectList() {
		List<GYMVo> GYM =  sdao.selectList();
		System.out.println("번호  이름 나이  성별 등록일 남은날짜 ");
		System.out.println("--------------------");
		for(GYMVo svo : GYM) {
			System.out.println(svo.toString());
		}
	} // end of studentlist
	//수정기능
	void modifyStudent() {
		String sno = ""; //블럭레벨 변수
		while(true) {
		System.out.println("변경할 학생번호 > ");
		sno = sc.nextLine();
		if(sdao.selectExists(sno)== 1) {
			break;
		}
		System.out.println("찾는 학생번호가 없음 학생번호 다시 입력 >");
		}
		System.out.print(">변경할 연락처 입력 : ");
		String phon = sc.nextLine();
		System.out.print(">변경할 주소 입력 : ");
		String add = sc.nextLine();
		
		StudentVo svo = new StudentVo();
		svo.setStdAddress(add);
		svo.setStdPhone(phon);
		svo.setStdNo(sno);
		if(sdao.modStu(svo)) {
			System.out.println("수정완료!");
		}
			
		
	}
//	void updateStudent() {
//		System.out.print(">변경할 학생번호 입력 : ");
//		String sno = sc.nextLine();
//		System.out.print(">변경할 학생이름 입력 : ");
//		String sname = sc.nextLine();
//		System.out.print(">변경할 연락처 입력 : ");
//		String phon = sc.nextLine();
//		System.out.print(">변경할 주소 입력 : ");
//		String add = sc.nextLine();
//		System.out.print(">변경할 생일 입력 : ");
//		String birth = sc.nextLine();		
////		god();
////		modStudent(up1, up2, where,where2);
////		 // 입력.
//		StudentVo std = new StudentVo();
//		std.setStdNo(sno);
//		std.setStdName(sname);
//		std.setStdPhone(phon);
//		std.setStdAddress(add);
//		std.setBirthDate(birth);
//		if(sdao.modStu(std)) {
//			System.out.println("수정완료!");
//		}else {
//			System.out.println("수정할 학생정보 없음!");
//		}		
//	}
	void delStudent() {
		System.out.print("> 삭제할 학생 번호 : ");
		String sno = sc.nextLine();	
		if(sdao.removeStudent(sno)) {
			System.out.println("삭제 완료!");
		}else {
			System.out.println("삭제할 학생번호가 없습니다!");
		}			
	}	
}