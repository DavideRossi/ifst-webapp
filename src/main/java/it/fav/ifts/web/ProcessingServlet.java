package it.fav.ifts.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.fav.ifts.logic.Saluter;

/**
 * This sevlet retrieves the data from the name selection form,
 * processes it with a Saluter object to create a salutation
 * that is added to the request attributes from where it will
 * be retrieved from the forwarded salutation page
 */
public class ProcessingServlet extends HttpServlet {
	private static final long serialVersionUID = -2910041560601677048L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//retrieve the value of the selected element in the form from the parameter "name"
		int name_index = Integer.parseInt(req.getParameter("name"));
		//retrieve the list of names from the session object
		@SuppressWarnings("unchecked")
		List<String> names = (List<String>) req.getSession().getAttribute("names");
		//retrieve the selected element from the list of names
		String name = names.get(name_index);
		//create a salutation message
		Saluter saluter = new Saluter();
		String salutation = saluter.salute(name);
		//store the message in a request attribute
		//since the message is only used by the forwarded JSP there is not need to store
		//it in the session object
		req.setAttribute("salutation", salutation);
		//forward to the JSP to show the message
		getServletContext().getRequestDispatcher("/salutation.jsp").forward(req, resp);
	}
}
