package clever.bank.controller;

import clever.bank.entity.User;
import clever.bank.repository.UserApiRepository;
import clever.bank.repository.UserRepository;
import clever.bank.sevices.UserApiService;
import clever.bank.sevices.UserService;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class UserController extends HttpServlet {

    private final UserRepository userRepository = new UserApiRepository();
    private final UserService userService = new UserApiService(userRepository);


    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        BufferedReader reader = req.getReader();
        StringBuilder jsonInput = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonInput.append(line);
        }
        String jsonData = jsonInput.toString();

        Gson gson = new Gson();
        User user = gson.fromJson(jsonData, User.class);
        Long aLong = userService.create(user);

        PrintWriter out = resp.getWriter();
        out.println(aLong);
    }
}

