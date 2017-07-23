package com.certification.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.certification.dao.EventDAO;
import com.certification.impl.EventIMPL;
import com.certification.model.Event;

/**
 * Servlet implementation class SaveNewEvent
 */
@WebServlet("/SaveNewEvent")
public class SaveNewEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveNewEvent() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Event event = new Event();
		EventDAO dao = new EventIMPL();

		String eventName = request.getParameter("eventName");
		String facultyIncharge = request.getParameter("eventIncharge");
		int eventDuration = Integer.parseInt(request.getParameter("eventDuration"));
		String dateStarted = request.getParameter("dateStarted");

		try {
			if (eventName.isEmpty() || facultyIncharge.isEmpty() || request.getParameter("eventDuration").isEmpty()
					|| dateStarted.isEmpty()) {
				throw new IllegalArgumentException();
			}
			event.setEventId(dao.getNewEventId());
			event.setDateStarted(dateStarted);
			event.setNoDays(eventDuration);
			event.setFacultyIncharge(facultyIncharge);
			event.setEventName(eventName);
			if(dao.createEvent(event)){
				response.sendRedirect("admin/all_events.jsp?save=success");
			}else{
				response.sendRedirect("admin/all_events.jsp?save=failed");
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

	}

}
