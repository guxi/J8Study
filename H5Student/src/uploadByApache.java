import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


	@WebServlet(urlPatterns = { "/uploadFileByA" })
	public class uploadByApache extends HttpServlet {
		private static final long serialVersionUID = 1L;
	    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			String s=(String) request.getParameter("aname");
			System.out.println(s+"1");
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			try {
		        //每一个FileItem 对应一个 request 请求中from表单中的 input 元素
		        //解析 request 请求，将request中提交的值存入List数组
				List<FileItem> items =fileUpload.parseRequest(request);

				for(FileItem item : items) {
		            //是不是一个文件上传组件
		            if(!item.isFormField()) {
		            	
		            	//InputStream inp = item.getInputStream();
		            	excelService es=new excelService(item.getInputStream());
		            	es.saveToDB();
		                String name = item.getName();
		               // File file=item.
		                System.out.println("name:" + name);
		                System.out.println("length:" + item.getSize());
		               // item.write(new File("C:/upload/"+name));
		            } else {
		                String desc = item.getString("UTF-8");
		                System.out.println("文件描述：" + desc);
		            }
		        }
			}
		     catch (Exception e) {
		        e.printStackTrace();
		    }
		} else {
		    throw new RuntimeException("请设置form表单的enctype属性");
		}	
		}
			
		}
	

