package com.mercury.java_web_demo.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercury.java_web_demo.bean.Sample;
import com.mercury.java_web_demo.dao.SampleDao;

/**
 * Servlet implementation class UserServlet
 */
// Use JACKSON
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 没有必要创建很多的 sampledao, 一个 user 对应一个 sampledao
	private SampleDao sampleDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        sampleDao = new SampleDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<Sample> samples = sampleDao.getSamples();
		// use Jackson to convert samples objects to JSON String.
		ObjectMapper mapper = new ObjectMapper();
		String samplesJSONString = mapper.writeValueAsString(samples);
		// 把 jason string 通过 writer 发送回去
		response.getWriter().write(samplesJSONString);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		boolean success = false;
		String message = "Add successfully!";
		try{
			String name = req.getParameter("name");
			int age = Integer.valueOf(req.getParameter("age"));
			
			// 拿到数据后，添加一个新的对象
			Sample sample = new Sample(name, age);
			
			success = sampleDao.addSample(sample);
			if(!success) {
				message = "Duplicate user!";
			}
			// (success: true/false, message: 'Add successfully!')
		}catch(Exception e) { // 如果输入age不是数字，有 exception
			success = false;
			message = "Input errors!";
		}
		// success, message
		// 最好的方法是创建一个 message class，然后把内容放进去。
		Map<String, Object> responseMessage = new HashMap<>();
		responseMessage.put("success", success);
		responseMessage.put("message", message);
		ObjectMapper objectMapper = new ObjectMapper();
		resp.getWriter().write(objectMapper.writeValueAsString(responseMessage));
		
	}

	
	
	
}











