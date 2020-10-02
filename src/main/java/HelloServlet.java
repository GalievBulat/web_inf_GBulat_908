import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class HelloServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
        cfg.setDirectoryForTemplateLoading(new File("C:\\Users\\Kakad\\Documents\\webb\\src\\main\\webapp\\WEB-INF\\template"));
        cfg.setDefaultEncoding("UTF-8");
        //
        Template temp = cfg.getTemplate("auth.ftl");
        Map<String, Object> root = Collections.emptyMap();
        try {
            temp.process(root,response.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e.getMessage(),e);
        }
    }
}