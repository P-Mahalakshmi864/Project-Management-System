import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		String projectName = req.getParameter("project-name");
		ProjectDAO projectDAO = new ProjectDAO();
		Project project = new Project(0, projectName);
		projectDAO.createProject(project);
		resp.setContentType("application/json");
		resp.getWriter().write("{\"name\": \"" + projectName + "\"}");
	}
}

