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

//			//�ϴ�·��
//			File file = new File("C:/upload");
//			//��ʱ�ļ�·��
//			File tempFile = new File("C:/uploadtemp");
//
//			if(!file.exists()) {
//			    file.mkdir();
//			}
//
//			if(!tempFile.exists()) {
//			    tempFile.mkdir();
//			}
//			//�ж� request ��һ���ļ��ϴ��� request
//			//ͨ�� ServletFileUpload ��ľ�̬���� isMultipartContent ���ж�
//			if(ServletFileUpload.isMultipartContent(request)) {
//			    //�� DiskFileItemFactory �����µ� file items ��ֻ����ʱ�ģ�
//			    //DiskFileItemFactory ����FileItem ʵ������������������<b>�ڴ�</b>����<b>Ӳ����</b>
//			    //ͨ��һ����ֵ��������� FileItem ʵ���Ǵ����<b>�ڴ�</b>����<b>Ӳ����</b>
//			    DiskFileItemFactory factory = new DiskFileItemFactory();
//			    //���÷�ֵ��С
//			    //�����õĻ���Ĭ��10k
//			    //���������ֵ��FileItem��ֱ��д�뵽����
//			    factory.setSizeThreshold(1024*10);
//			    //������ʱ�ļ���
//			    //�����ã�Ĭ��ΪϵͳĬ��Temp�ļ�·�������� System.getProperty("java.io.tmpdir") ��ȡ
//			    //������ֵ�� FileItem ʵ������������Ŀ¼��
//			    factory.setRepository(tempFile);
//			    //����servletFileUpload ��ʵ������ʵ���ṩ����ģʽ����FileItem��DiskFileItemFactoryʵ��
//			    ServletFileUpload fileUpload = new ServletFileUpload(factory);
//			    //����һ��<b>����������</b>���������С(ע�����������󣬰�����file���͵ı�,����Text����)
//			    fileUpload.setSizeMax(10*1024*1024);
//			    //��������������ĵ����ϴ��ļ���С(��Ӧһ��FileItem����)
//			    //fileUpload.setFileSizeMax(10*1024*1024);
//
//			    try {
//			        //ÿһ��FileItem ��Ӧһ�� request ������from���е� input Ԫ��
//			        //���� request ���󣬽�request���ύ��ֵ����List����
//			        List<FileItem> items = fileUpload.parseRequest(request);
//
//			        for(FileItem item : items) {
//			            //�ǲ���һ���ļ��ϴ����
//			            if(!item.isFormField()) {
//			                String name = item.getName();
//			                System.out.println("name:" + name);
//			                System.out.println("length:" + item.getSize());
//			                item.write(new File("C:/upload/"+name));
//			            } else {
//			                String desc = item.getString("UTF-8");
//			                System.out.println("�ļ�������" + desc);
//			            }
//			        }
//			    } catch (Exception e) {
//			        e.printStackTrace();
//			    }
//			} else {
//			    throw new RuntimeException("������form����enctype����");
//			}
//			���ƴ���
//			Streaming API
//
//			���ƴ���
//			//�����ļ��ϴ�·��
//			String UploadFilePath = "d:/upload";
//			//�����ļ���С
//			//ͨ�� request.getHeader("Content-Length") ��ȡrequest �������ݳ���������
//			if(ServletFileUpload.isMultipartContent(request)) {
//
//			    //����ServletFileUploadʵ��
//			    ServletFileUpload upload = new ServletFileUpload();
//			    try {
//			        //����request ���� ������FileItemStream ��iterator ʵ��
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
//			                out.write("���");
//			                System.out.println("wanchengle ");
//			            }
//			        }
//			    } catch (FileUploadException e) {
//			        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//			    }
//			} else {
//			    throw new RuntimeException("������form����enctype����");
//			}
	//}


