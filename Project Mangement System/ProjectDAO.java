import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectDAO {
	private Connection connection;

	public ProjectDAO() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_management", "username", "password");
	}

	public void createProject(Project project) throws SQLException {
		PreparedStatement statement = connection.prepareStatement("INSERT INTO projects (name) VALUES (?)");
		statement.setString(1, project.getName());
		statement.executeUpdate();
	}

	public Project getProject(int id) throws SQLException {
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM projects WHERE id = ?");
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			return new Project(resultSet.getInt("id"), resultSet.getString("name"));
		} else {
			return null;
		}
	}
}
