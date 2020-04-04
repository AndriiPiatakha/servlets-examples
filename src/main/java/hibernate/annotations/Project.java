package hibernate.annotations;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
public class Project {   
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
  
    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees = new HashSet<>();
    
    @Column
    private String projectName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", employees=" + employees + ", projectName=" + projectName + "]";
	}
    
    
     
    
}
