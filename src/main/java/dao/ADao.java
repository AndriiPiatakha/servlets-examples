package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ADao {
	
	public List<Professor> getProfessorsByDay() throws SQLException {
		List<Professor> proffList = new ArrayList<>();
		Connection conn = DriverManager.getConnection("");
		PreparedStatement st = conn.prepareStatement("");
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			Professor p = new Professor();
			p.setName(rs.getString("name"));
			proffList.add(p);
		}
		
		return proffList;
	}

}
