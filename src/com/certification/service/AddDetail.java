package com.certification.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.certification.database.ConnectionFactory;
import com.certification.impl.CertificateIMPL;
import com.certification.impl.ParticipantIMPL;
import com.certification.model.CertificateLayout;
import com.certification.model.Participant;

/**
 * Servlet implementation class AddDetail
 */
@WebServlet("/AddDetail")
public class AddDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			CertificateIMPL certiimpl = new CertificateIMPL();
			ParticipantIMPL partiimpl = new ParticipantIMPL();
			CertificateLayout layout = new CertificateLayout();
			File certificateDirectory = new File(System.getProperty("catalina.base") + "\\upload_certificates");
			File particiapantsListDirectory = new File(System.getProperty("catalina.base") + "\\uploads_lists");

			if (!certificateDirectory.exists())
				certificateDirectory.mkdirs();
			if (!particiapantsListDirectory.exists())
				particiapantsListDirectory.mkdirs();

			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> multiparts = upload.parseRequest(request);
				List<List<String>> sheetData = new ArrayList<>();
				List<Participant> participants = new ArrayList<>();
				List<String[]> toBeAwardeds = new ArrayList<>();
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				layout.setCertificateId(timestamp.toString());
				for(FileItem item:multiparts){
					if (item.isFormField()) {
						if ("eventId".equals(item.getFieldName())) {
							layout.setEventId(item.getString());
						}
					}
				}
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						if (item.getFieldName().equals("certificateLayout")) {
							String filename = new File(item.getName()).getName();
							layout.setCertificateImageLocation(filename);
							String filepath = certificateDirectory.getAbsolutePath() + File.separator + filename;
							File storeFile = new File(filepath);
							item.write(storeFile);
						}
						if (item.getFieldName().equals("participants")) {

							InputStream stream = item.getInputStream();
							Workbook workbook = WorkbookFactory.create(stream);
							Sheet sheet = workbook.getSheetAt(0);
							Iterator<Row> rowIter = sheet.iterator();
							while (rowIter.hasNext()) {
								List<String> cellData = new ArrayList<>();
								Row row = rowIter.next();
								Iterator<Cell> cellIter = row.cellIterator();
								while (cellIter.hasNext()) {
									Cell cell = cellIter.next();
									switch (cell.getCellType()) {
									case Cell.CELL_TYPE_STRING:
										cellData.add(cell.getStringCellValue());
										break;
									case Cell.CELL_TYPE_NUMERIC:
										long d = (long) cell.getNumericCellValue();
										cellData.add(Long.toString(d));
										break;
									}
								}
								sheetData.add(cellData);
							}
							for (List<String> list : sheetData) {
								System.out.println(list);
							}
							if (!sheetData.isEmpty()) {
								sheetData.remove(0);
								for (List<String> list1 : sheetData) {
									Participant participant = new Participant();
									participant.setParticipantId(list1.get(0));
									participant.setName(list1.get(1));
									participant.setInstitution(list1.get(2));
									participant.setEmail(list1.get(3));
									participant.setContact(list1.get(4));
									participants.add(participant);
									toBeAwardeds.add(new String[]{layout.getCertificateId(),layout.getEventId(),participant.getParticipantId(),null,});
								}
								
								layout.setProperty1abscissa(Integer.toString(100));
								layout.setProperty1ordinate(Integer.toString(100));
							}
						}
					}
					
				}
				if (null == layout || participants.isEmpty()) {
					response.sendRedirect("faculty/manage_events.jsp?layoutsave=failed");
				} else {
					partiimpl.saveParticipants(participants);
					if (certiimpl.saveLayoutDetails(layout)) {
						response.sendRedirect("faculty/manage_events.jsp?layoutsave=success");
					} else {
						response.sendRedirect("faculty/manage_events.jsp?layoutsave=failed");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
