package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DefaultProfessorDao implements ProfessorDao {
	
	public static final String SELECT_QUERY = "";
	
	public List<Professor> getProfessorsByDay() throws SQLException {
		List<Professor> proffList = new ArrayList<>();
		Connection conn = DriverManager.getConnection("");
		PreparedStatement st = conn.prepareStatement(SELECT_QUERY);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			Professor p = new Professor();
			p.setName(rs.getString("name"));
			proffList.add(p);
		}
		
		return proffList;
	}
	
	public Professor getProfessorById(int id) throws SQLException {
		Professor p = new Professor();
		Connection conn = null;
		PreparedStatement st = conn.prepareStatement("SAMPLE QUERY");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		p.setName(rs.getString("name"));
		return p;
	}

	@Override
	public List<Professor> getProfessorsByDay(String day) {
		return null;
	}

	@Override
	public Professor getProfessorById() {
		return null;
	}

	@Override
	public List<Professor> getProfessorsByTitle(String title) {
		return null;
	}

}
