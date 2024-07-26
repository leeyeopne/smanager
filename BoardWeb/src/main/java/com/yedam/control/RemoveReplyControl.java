package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class RemoveReplyControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String bno = req.getParameter("bno"); 
        ReplyService svc = new ReplyServiceImpl();
//        ReplyVO rvo = new ReplyVO();
        Map<String, Object> map = new HashMap<>();
        try {
        if (svc.removeReply(Integer.parseInt(bno))) {
            map.put("retCode","Success");
            map.put("retVal", bno);
        }
        } catch (Exception e) {
            map.put("retCode","Fail");
            map.put("retVal", null);
        }

            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(map);

            resp.getWriter().print(json);
        }

    }