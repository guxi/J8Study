import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.fileupload.FileItemIterator;


	@WebServlet(urlPatterns = { "/uploadFile" })
	public class fileController extends HttpServlet {
		private static final long serialVersionUID = 1L;
	    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			String s=(String) request.getParameter("aname");
			System.out.println(s+"1");
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
			System.out.println("1");
			int formDataLength = request.getContentLength();
			//String fileName=request.
			DataInputStream dataStream = new DataInputStream(request.getInputStream());
			byte[] body =new byte[formDataLength];
			int totalBytes = 0;
	        while (totalBytes < formDataLength) {
	            int bytes = dataStream.read(body, totalBytes, formDataLength);
	            totalBytes += bytes;
	        }
	        System.out.println("2");
	        FileOutputStream fileOutputStream = new FileOutputStream("c:/test/1.jpg" );
	        fileOutputStream.write(body);
	        fileOutputStream.flush();
	        fileOutputStream.close();
	        dataStream.close();
	        System.out.println("3:"+formDataLength);
		}
	}

//			//上传路径
//			File file = new File("C:/upload");
//			//临时文件路径
//			File tempFile = new File("C:/uploadtemp");
//
//			if(!file.exists()) {
//			    file.mkdir();
//			}
//
//			if(!tempFile.exists()) {
//			    tempFile.mkdir();
//			}
//			//判断 request 是一个文件上传的 request
//			//通过 ServletFileUpload 类的静态方法 isMultipartContent 来判断
//			if(ServletFileUpload.isMultipartContent(request)) {
//			    //用 DiskFileItemFactory 创建新的 file items （只是临时的）
//			    //DiskFileItemFactory 创建FileItem 实例，并保存其内容在<b>内存</b>或者<b>硬盘中</b>
//			    //通过一个阀值来决定这个 FileItem 实例是存放在<b>内存</b>或者<b>硬盘中</b>
//			    DiskFileItemFactory factory = new DiskFileItemFactory();
//			    //设置阀值大小
//			    //不设置的话，默认10k
//			    //超过这个阀值，FileItem将直接写入到磁盘
//			    factory.setSizeThreshold(1024*10);
//			    //设置临时文件夹
//			    //不设置，默认为系统默认Temp文件路径，调用 System.getProperty("java.io.tmpdir") 获取
//			    //超过阀值的 FileItem 实例将存放在这个目录中
//			    factory.setRepository(tempFile);
//			    //构造servletFileUpload 的实例，该实例提供工厂模式创建FileItem的DiskFileItemFactory实例
//			    ServletFileUpload fileUpload = new ServletFileUpload(factory);
//			    //设置一个<b>完整的请求</b>允许的最大大小(注意是完整请求，包括非file类型的表单,比如Text类型)
//			    fileUpload.setSizeMax(10*1024*1024);
//			    //设置所允许的最大的单个上传文件大小(对应一个FileItem对象)
//			    //fileUpload.setFileSizeMax(10*1024*1024);
//
//			    try {
//			        //每一个FileItem 对应一个 request 请求中from表单中的 input 元素
//			        //解析 request 请求，将request中提交的值存入List数组
//			        List<FileItem> items = fileUpload.parseRequest(request);
//
//			        for(FileItem item : items) {
//			            //是不是一个文件上传组件
//			            if(!item.isFormField()) {
//			                String name = item.getName();
//			                System.out.println("name:" + name);
//			                System.out.println("length:" + item.getSize());
//			                item.write(new File("C:/upload/"+name));
//			            } else {
//			                String desc = item.getString("UTF-8");
//			                System.out.println("文件描述：" + desc);
//			            }
//			        }
//			    } catch (Exception e) {
//			        e.printStackTrace();
//			    }
//			} else {
//			    throw new RuntimeException("请设置form表单的enctype属性");
//			}
//			复制代码
//			Streaming API
//
//			复制代码
//			//设置文件上传路径
//			String UploadFilePath = "d:/upload";
//			//限制文件大小
//			//通过 request.getHeader("Content-Length") 获取request 请求内容长度来限制
//			if(ServletFileUpload.isMultipartContent(request)) {
//
//			    //创建ServletFileUpload实例
//			    ServletFileUpload upload = new ServletFileUpload();
//			    try {
//			        //解析request 请求 并返回FileItemStream 的iterator 实例
//			        FileItemIterator iter = upload.getItemIterator(req);
//			        while (iter.hasNext()) {
//			            FileItemStream item = iter.next();
//			            String name = item.getFieldName();
//			            InputStream stream = item.openStream();
//			            if (item.isFormField()) {
//			                System.out.println("Form field " + name + " with value "
//			                        + Streams.asString(stream) + " detected.");
//			            } else {
//			                System.out.println("File field " + name + " with file name "
//			                        + item.getName() + " detected.");
//			                // Process the input stream
//			                //System.out.println(Streams.asString(stream));
//			                System.out.println("shuru:");
//			                String filename = new Scanner(System.in).next();
//			                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(new File("e:/upload"),"ez.zip")));
//			                BufferedInputStream bis = new BufferedInputStream(stream);
//			                byte[] buffer = new byte[1024];
//			                int len = -1;
//			                while (-1 != (len = bis.read(buffer))){
//			                    bos.write(buffer,0,len);
//			                }
//			                bis.close();
//			                bos.flush();
//			                bos.close();
//
//			                PrintWriter out = resp.getWriter();
//			                out.write("完成");
//			                System.out.println("wanchengle ");
//			            }
//			        }
//			    } catch (FileUploadException e) {
//			        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//			    }
//			} else {
//			    throw new RuntimeException("请设置form表单的enctype属性");
//			}
	//}


