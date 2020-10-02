import DBClasses.User;
import Servants.AuthHandler;
import Servants.FileOutputHandler;
import Servants.OutputHandler;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@WebServlet("/reg")
public class RegServlet extends HttpServlet{
    private final String USERS_FILE = "C:\\Users\\Kakad\\Documents\\webb\\src\\main\\java\\users.txt";
    private final int USERS_ATTRIBUTES = 6;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        OutputHandler oH = new FileOutputHandler();
        List<String> userInf = new ArrayList<>();
        try {
            userInf.add(""+(new BufferedReader(new FileReader(USERS_FILE)).lines().count()/(USERS_ATTRIBUTES+1)+1));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage(),e);
        }
        userInf.add(req.getParameter("name"));
        userInf.add(req.getParameter("login"));
        userInf.add(req.getParameter("password"));
        userInf.add(req.getParameter("reg_date"));
        userInf.add(req.getParameter("birth_date"));
        oH.writeTheUserToTheFile(new User(userInf));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
        try {
            cfg.setDirectoryForTemplateLoading(new File("C:\\Users\\Kakad\\Documents\\webb\\src\\main\\webapp\\WEB-INF\\template"));
            cfg.setDefaultEncoding("UTF-8");
            //
            Template temp = cfg.getTemplate("reg.ftl");
            Map<String, Object> root = Collections.emptyMap();
            temp.process(root, resp.getWriter());
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e.getMessage(),e);
        }
    }
}