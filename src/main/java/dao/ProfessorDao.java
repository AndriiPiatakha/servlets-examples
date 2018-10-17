package dao;

import java.util.List;

public interface ProfessorDao {
	
	List<Professor> getProfessorsByDay(String day);
	Professor getProfessorById();
	List<Professor> getProfessorsByTitle(String title);

}
