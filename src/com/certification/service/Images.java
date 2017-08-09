package com.certification.service;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Images
 */
@WebServlet("/images/*")
public class Images extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Images() {
        super();
        System.out.println("CALLED"); 
        // TODO Auto-generated constructor stub
    }
    //0da45a4d300debb4892d48e7eabd0c3a.jpg
    private String imagePath;
    public void init() throws ServletException{
       File certificateDirectory = new File(System.getProperty("catalina.base") + "\\upload_certificates");
        this.imagePath = certificateDirectory.getAbsolutePath();
        System.out.println(">"+imagePath);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String requestedImage = request.getPathInfo();
        System.out.println("IP:"+imagePath);
        System.out.println("RI:"+requestedImage);
        if(requestedImage == null){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        File image = new File(imagePath, URLDecoder.decode(requestedImage, "UTF-8"));
        System.out.println("IMAGE:"+image);
        if(!image.exists()){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        String contentType = getServletContext().getMimeType(image.getName());
        if(contentType == null || !contentType.startsWith("image")){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        System.out.println(contentType);
        response.reset();
        response.setContentType(contentType);
        response.setHeader("Content-Length", String.valueOf(image.length()));
        Files.copy(image.toPath(),response.getOutputStream());
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 String requestedImage = request.getPathInfo();
	        System.out.println(imagePath); 
	        System.out.println(requestedImage);
	        if(requestedImage == null){
	            response.sendError(HttpServletResponse.SC_NOT_FOUND);
	        }
	        File image = new File(imagePath, URLDecoder.decode(requestedImage, "UTF-8"));
	        System.out.println("image"+image);
	        if(!image.exists()){
	            response.sendError(HttpServletResponse.SC_NOT_FOUND);
	        }
	        String contentType = getServletContext().getMimeType(image.getName());
	        if(contentType == null || !contentType.startsWith("image")){
	            response.sendError(HttpServletResponse.SC_NOT_FOUND);
	            return;
	        }
	        System.out.println(contentType);
	        response.reset();
	        response.setContentType(contentType);
	        response.setHeader("Content-Length", String.valueOf(image.length()));
	        Files.copy(image.toPath(),response.getOutputStream());
	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
        String requestedImage = request.getPathInfo();
        System.out.println(imagePath);
        System.out.println(requestedImage);
        if(requestedImage == null){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        File image = new File(imagePath, URLDecoder.decode(requestedImage, "UTF-8"));
        System.out.println(image);
        if(!image.exists()){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        String contentType = getServletContext().getMimeType(image.getName());
        if(contentType == null || !contentType.startsWith("image")){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        System.out.println(contentType);
        response.reset();
        response.setContentType(contentType);
        response.setHeader("Content-Length", String.valueOf(image.length()));
        Files.copy(image.toPath(),response.getOutputStream());
        
	}

}
