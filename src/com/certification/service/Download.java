package com.certification.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.certification.impl.CertificateIMPL;
import com.certification.impl.EventIMPL;
import com.certification.impl.ParticipantIMPL;
import com.certification.model.CertificateAwarded;
import com.certification.model.CertificateData;
import com.certification.model.CertificateLayout;
import com.certification.model.Event;
import com.certification.model.Participant;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class Download
 */
@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Download() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String eventID = request.getParameter("eventID");
			String participantID = request.getParameter("participantID");
			ParticipantIMPL impl = new ParticipantIMPL();
			EventIMPL impl2 = new EventIMPL();
			CertificateIMPL impl3 = new CertificateIMPL();
			Participant p = null;
			Event event = impl2.getEvent(eventID);
			for (Participant participant : impl.getAllParticipant()) {
				if (participant.getParticipantId().equals(participantID)) {
					p = participant;
					break;
				}
			}
			if (null == p || null==event) {
				throw new IllegalArgumentException();
			}
			File certificateDirectory = new File(System.getProperty("catalina.base") + "\\upload_certificates");
			CertificateData data = impl3.getCertificateDataByEventID(eventID);
			Image img = Image.getInstance(certificateDirectory.getAbsolutePath()+"\\"+data.getCertificateImageLocation());
			
			Document document = new Document(new Rectangle(1280, 905));
			PdfWriter write = PdfWriter.getInstance(document,response.getOutputStream());
			//new FileOutputStream("C:\\Users\\Deepanshu Jain\\Desktop\\Certificate Sample2.pdf")
			img.scaleAbsolute(1280, 905);
			img.setAbsolutePosition(0, 0);
			document.open();
			response.setHeader("Expires", "0");
            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            response.setContentType("application/pdf");
            
            
			PdfContentByte canvas = write.getDirectContentUnder();
			BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			canvas.saveState();
			canvas.addImage(img);
			canvas.beginText();
			canvas.moveText(Integer.parseInt(data.getProperty1abscissa()), 905- Integer.parseInt(data.getProperty1ordinate()));
			canvas.setFontAndSize(bf, 35);
			canvas.showText(p.getName());
			
			canvas.moveText(450, -310);
			canvas.setFontAndSize(bf, 12);
			canvas.showText(data.getCertificateId());
			canvas.endText();
			canvas.restoreState();
			document.close();		
			
		} catch (IllegalArgumentException p) {
			p.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
