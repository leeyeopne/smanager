package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class StudentListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp){
		// TODO Auto-generated method stub
		// stdList.do -> 보여줄 페이지는 WEB-INF/jsp/studentlist.jsp
		try {
			req.getRequestDispatcher("WEB-INF/jsp/studentList.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
