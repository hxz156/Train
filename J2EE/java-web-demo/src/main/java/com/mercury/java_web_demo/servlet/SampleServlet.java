package com.mercury.java_web_demo.servlet;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mercury.java_web_demo.bean.Sample;
import com.mercury.java_web_demo.dao.SampleDao;

/**
 * Servlet implementation class SampleServlet
 */
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SampleServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// This method will be automatically invoked
		// whenever there is a GET type request of "/samples" sent to server
		// SampleDao will get the object
		SampleDao sampleDao = new SampleDao();
		List<Sample> samples = sampleDao.getSamples();
		
		// We will use "samples.jsp" to generate dynamic HTML
		// forward current request along samples data to sample.jsp
		// Servlet 代码不需要记忆，只需要看懂
		
		// 把 samples 塞到
		// 把请求数据转发给 "/samples.jsp"，利用 jsp 去做底层代码
		// 更改 jsp 文件不需要重新启动服务器
		// jsp 只需要看懂
		// 第一个参数：属性的名字（自己取得名字，jsp里面是id）。 第二个参数：从数据库拿到的array list
		request.setAttribute("samples", samples); 
		
		RequestDispatcher dispatcher = this.getServletContext()
									.getRequestDispatcher("/samples.jsp");
        dispatcher.forward(request, response);
		
        
//================================================================================
		
//		// send samples back to client as response (similar to previous OutputStream)
//		Writer writer = response.getWriter();
//		// convert samples to a HTML string
//		// 把数据库的数据放到 html
//		// 旧的方法太麻烦，有错误不会自动报错。
//		writer.write("<html><head><title>All Samples</title></head>");
//		writer.write("<body>");
//		writer.write("<table>");
//		writer.write("<thead>");
//		writer.write("<tr><th>Name</th><th>Age</th></tr>");
//		writer.write("</thead>");
//		writer.write("<tbody>");
//		for(Sample sample : samples){
//			writer.write("<tr>");
//			writer.write("<td>" + sample.getName() + "</td>");
//			writer.write("<td>" + sample.getAge() + "</td>");
//			writer.write("</tr>");
//		}
//		
//		writer.write("</tbody>");
//		writer.write("</table>");
//		writer.write("</body>");
//		writer.write("</html>");
		
//======================================================================
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the method name, 9/22
		String methodName = request.getMethod();
		switch(methodName){
			case "POST": 
					postMethodCaseInDoPostMethod(request, response);
					break;
			
			default:
					break;
		}
		
//		// handle POST type request sent to /Samples
//		
//		// extract name/age from request
//		String name = request.getParameter("name");
//		int age = Integer.valueOf(request.getParameter("age") );	// 需要转换： "11" -> 11
//		Sample sample = new Sample(name, age);
//		SampleDao sampleDao = new SampleDao();
//		
//		
//		
//		Writer writer = response.getWriter();
//        writer.write("<html><head><title>All Samples</title></head>");
//        writer.write("<body>");
//        if (sampleDao.addSample(sample)) {
//        	writer.write("New sample added!");
//            writer.write("<a href='http://localhost:8080/java-web-demo/test.html'>Back to Home</a>");
//		} else {
//			writer.write("Something bad happend! Try again");
//	        writer.write("<a href='http://localhost:8080/java-web-demo/add-sample.html'>Try again</a>");
//		}
//        
//        writer.write("</body>");
//        writer.write("</html>");
	}
	
	private void postMethodCaseInDoPostMethod(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// handle POST type request sent to /Samples
				
				// extract name/age from request
				String name = request.getParameter("name"); // 从html里面，拿的是对应的name
				int age = Integer.valueOf(request.getParameter("age") );	// 需要转换： "11" -> 11
				Sample sample = new Sample(name, age);
				SampleDao sampleDao = new SampleDao();
				
				Writer writer = response.getWriter();
		        writer.write("<html><head><title>All Samples</title></head>");
		        writer.write("<body>");
		        if (sampleDao.addSample(sample)) {
		        	writer.write("New sample added!");
		            writer.write("<a href='http://localhost:8080/java-web-demo/test.html'>Back to Home</a>");
				} else {
					writer.write("Something bad happend! Try again");
			        writer.write("<a href='http://localhost:8080/java-web-demo/add-sample.html'>Try again</a>");
				}
		        writer.write("</body>");
		        writer.write("</html>");
	}
	
	private void deleteMethodCaseInDoPostMethod(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// extract name/age from request
		String name = request.getParameter("name");
//		int age = Integer.valueOf(request.getParameter("age") );	// 需要转换： "11" -> 11
//		Sample sample = new Sample(name, age);
		SampleDao sampleDao = new SampleDao();
		
		Writer writer = response.getWriter();
        writer.write("<html><head><title>All Samples</title></head>");
        writer.write("<body>");
        if (sampleDao.deleteSample(name)) {
        	writer.write(name + "deleted!");
            writer.write("<a href='http://localhost:8080/java-web-demo/test.html'>Back to Home</a>");
		} else {
			writer.write("Something bad happend! Try again");
	        writer.write("<a href='http://localhost:8080/java-web-demo/delete-sample.html'>Try again</a>");
		}
        writer.write("</body>");
        writer.write("</html>");
	}

}







