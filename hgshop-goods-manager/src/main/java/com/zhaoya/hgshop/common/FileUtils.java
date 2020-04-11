package com.zhaoya.hgshop.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	
	
	/**
	 * 
	 * @param response
	 * @param file
	 * @throws FileNotFoundException 
	 */
	public static void downLoad(HttpServletResponse response, String filename) throws FileNotFoundException {
		 /* // 下载本地文件
	    String fileName = "Operator.doc".toString(); // 文件的默认保存名
*/	    // 读到流中
	    InputStream inStream = new FileInputStream("e:\\pic\\"+filename);// 文件的存放路径
	    // 设置输出的格式
	    response.reset();
	    response.setContentType("bin");
	    response.addHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
	   
	    // 循环取出流中的数据
	    byte[] b = new byte[1024];
	    int len;
	    try {
	      while ((len = inStream.read(b)) > 0)
	        response.getOutputStream().write(b, 0, len);
	      inStream.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	
	}
	
	
	/**
	 *  上传文件
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String processFile(MultipartFile file) throws IllegalStateException, IOException {

		// 原来的文件名称
		System.out.println("file.isEmpty() :" + file.isEmpty()  );
		System.out.println("file.name :" + file.getOriginalFilename());
		
		if(file.isEmpty()||"".equals(file.getOriginalFilename()) || file.getOriginalFilename().lastIndexOf('.')<0 ) {
			return "";
		}
			
		String originName = file.getOriginalFilename();
		String suffixName = originName.substring(originName.lastIndexOf('.'));
		SimpleDateFormat sdf=  new SimpleDateFormat("yyyyMMdd");
		String path = "e:/pic/" + sdf.format(new Date());
		File pathFile = new File(path);
		if(!pathFile.exists()) {
			pathFile.mkdir();
		}
		String destFileName = 		path + "/" +  UUID.randomUUID().toString() + suffixName;
		File distFile = new File( destFileName);
		file.transferTo(distFile);//文件另存到这个目录下边
		return destFileName.substring(7);
		
		
	}
}
