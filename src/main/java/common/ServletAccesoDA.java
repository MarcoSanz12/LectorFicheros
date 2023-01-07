package common;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import xml.XMLWriter;

/**
 * Servlet implementation class ServletAccesoDA
 */
public class ServletAccesoDA extends HttpServlet {

	private String[] datosNames = { "dato1", "dato2", "dato3", "dato4", "dato5", "dato6" };
	
	private String ERROR_MESSAGE = "";
	public final String DEFAULT_ERROR_MESSAGE = "No deberías estar viendo esto";
	private final String UNIMPLEMENTED_ERROR_MESSAGE = "El módulo actual no está implementado";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAccesoDA() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String jsp = "AccesoDA.jsp";
		boolean emptyFields = true;
		ERROR_MESSAGE = DEFAULT_ERROR_MESSAGE;

		/* Se comprueba que no haya campos vacíos */
		if (!isEmptyFields(request)) {

			String fileType = request.getParameter("fileType");
			String action = request.getParameter("action");
			ArrayList<String> datos = getDatosParameters(request);

			/* Elección de ficheros */
			switch (fileType) {
			case "xls": {

				switch (action) {

				/* XLS lectura */
				case "read":
					ERROR_MESSAGE = UNIMPLEMENTED_ERROR_MESSAGE;
					break;
				/* XLS escritura */
				case "write":
					ERROR_MESSAGE = UNIMPLEMENTED_ERROR_MESSAGE;
					break;
				}

			}
			case "csv": {

				switch (action) {

				/* CSV lectura */
				case "read":
					ERROR_MESSAGE = UNIMPLEMENTED_ERROR_MESSAGE;
					break;
				/* CSV escritura */
				case "write":
					ERROR_MESSAGE = UNIMPLEMENTED_ERROR_MESSAGE;
					break;
				}

			}
			case "json": {

				switch (action) {

				/* JSON lectura */
				case "read":
					ERROR_MESSAGE = UNIMPLEMENTED_ERROR_MESSAGE;
					break;
				/* JSON escritura */
				case "write":
					ERROR_MESSAGE = UNIMPLEMENTED_ERROR_MESSAGE;
					break;
				}

			}
			case "xml": {

				switch (action) {

				/* XML lectura */
				case "read":
					jsp = "DatosAbiertosXML.jsp";
					break;
				/* XML escritura */
				case "write":

					XMLWriter writer = new XMLWriter();
					writer.writeXML(datos);
					break;
				}

			}
			}
			
			emptyFields = false;

		}

		if (!ERROR_MESSAGE.equals(DEFAULT_ERROR_MESSAGE)) {
			jsp = "ErrorDA.jsp";
		}
		request.getServletContext().setAttribute("errorMessage",ERROR_MESSAGE);
		request.getServletContext().setAttribute("emptyFields", emptyFields);
		request.getRequestDispatcher(jsp).forward(request, response);

	}

	private ArrayList<String> getDatosParameters(HttpServletRequest request) {

		ArrayList<String> datos = new ArrayList<String>();

		for (String dato : datosNames) {
			datos.add(request.getParameter(dato));
		}

		return datos;
	}

	private boolean isEmptyFields(HttpServletRequest request) {
		boolean empty = false;

		if (request.getParameter("action") != null && request.getParameter("fileType") != null) {

			if (request.getParameter("action").equals("write")) {

				int datosQuant = 0;

				for (String dato : datosNames) {
					
					if (datosQuant > 0) {
						break;
					}
				
					String datoValue = request.getParameter(dato);
					if (datoValue != null) {

						if (!datoValue.isEmpty()) {
							datosQuant++;
						}
					}
				}
				if (datosQuant == 0) {
					empty = true;
				}

			}

		} else {
			empty = true;
		}

		return empty;
	}

}
