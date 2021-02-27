package examplediploma.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import examplediploma.models.UserData;

@WebServlet("/getProducts")
public class GetProducts extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserData> users = new ArrayList<>(Arrays.asList(
					new UserData(1, "John", "Doe", "john.doe@email.com"),
					new UserData(1, "William", "Smith", "will.smith@email.com")
				
				));
		
		Gson gson = new Gson();
		resp.getWriter().write(gson.toJson(users));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reqBody = req.getReader().lines().collect(Collectors.joining());
		System.out.println(reqBody);
		
		var gson = new Gson();
		Type type = new TypeToken<List<UserData>>(){}.getType();
		
		List<UserData> users = gson.fromJson(reqBody, type);
		users.forEach((user) -> System.out.println(user));
		
	}
	

}
