package it.fav.ifts.web;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

/**
 * Application's entry point
 * This servlet loads data in a session object and forwards to the initial page
 */
public class InitialServlet extends HttpServlet {
	private static final long serialVersionUID = 1214445446508878572L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//read the whole /WEB-INF/names.json file in the json string
		String json = new String(req.getServletContext().getResource("/WEB-INF/names.json").
				openStream().readAllBytes(), StandardCharsets.UTF_8);
		//retrieve the JSON document as an object
		JsonObject document = JsonParser.parseString(json).getAsJsonObject();
		Gson gson = new Gson();
		List<String> names = gson.fromJson(document.get("names"), new TypeToken<List<String>>(){});
		//put the name list in the session object as an attribute with name "name"
		//from where other servlets and JSPs can retrieve it
		req.getSession(true).setAttribute("names", names);
		//forward the request to a JSP that will render the HTML document
		getServletContext().getRequestDispatcher("/start.jsp").forward(req, resp);
	}
}
