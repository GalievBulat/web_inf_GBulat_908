
import DBClasses.User;
import Servants.Auth;
import Servants.AuthHandler;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/profile")
public class AuthServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write("404");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
        try {
        cfg.setDirectoryForTemplateLoading(new File("C:\\Users\\Kakad\\Documents\\webb\\src\\main\\webapp\\WEB-INF\\template"));
        cfg.setDefaultEncoding("UTF-8");
        Template temp = cfg.getTemplate("profile.ftl");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Auth aH= new AuthHandler();
        Optional<User> OUser = aH.authorise(login,password);
        Map<String, Object> root = new HashMap<>();
        if (OUser.isPresent()) {
            User user = OUser.get();
            root.put("name",user.getName());
            root.put("login",user.getLogin());
            root.put("reg_date",user.getRegistration_date());
            root.put("birth_date",user.getBirth_date());
        } else {
            root.put("errorMessage","no user has been found");
        }
            temp.process(root, response.getWriter());
        } catch (TemplateException | IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
