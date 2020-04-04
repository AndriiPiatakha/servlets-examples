package hibernate.annotations;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class ManageEmployee {
	private static SessionFactory factory;

	public static void main(String[] args) {

		try {
			factory = HibernateUtil.getSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		ManageEmployee ME = new ManageEmployee();

		/* Add few employee records in database */
		Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
		Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
		Integer empID3 = ME.addEmployee("John", "Paul", 10000);

		/* List down all the employees */
		ME.listEmployees();

		/* Update employee's records */
		ME.updateEmployee(empID1, 5000);

		/* Delete an employee from the database */
		ME.deleteEmployee(empID2);

		/* List down new list of the employees */
		ME.listEmployees();

		
		System.out.println("===== Extract employee by ID");
		ME.querySingleEmployeeById(1);
		
		
		System.out.println("===== Native SQL Demo");
		ME.listEmployeesScalar();
		ME.listEmployeesEntity();
		
		System.out.println("===== One to Many demo");
		ME.saveDealsPerEmployee(1);
		ME.listEmployees();
		
		System.out.println("===== Many to Many demo");
		ME.saveProjectsForTwoUsers(1, 3);
		ME.listEmployees();
	}

	private void saveProjectsForTwoUsers(int employeeId1, int employeeId2) {
		Transaction tx = null;
		try (Session session = factory.openSession()) {
	
			tx = session.beginTransaction();
			Query<Employee> query = session.createQuery("FROM Employee E WHERE E.id = :id");
			query.setParameter("id", employeeId1);
			Employee employee = query.list().get(0);
			
			query.setParameter("id", employeeId2);
			Employee employee2 = query.list().get(0);
			
			Project project1 = new Project();
			project1.setProjectName("project1");
			
			Project project2 = new Project();
			project2.setProjectName("project2");
			
			employee.getProjects().add(project1);
			employee.getProjects().add(project2);
			
			employee2.getProjects().add(project1);
			employee2.getProjects().add(project2);
			
			
			session.save(employee);
			session.save(employee2);
			
			tx.commit();
			
		}
	}

	private void saveDealsPerEmployee(int employeeId) {
		Transaction tx = null;
		try (Session session = factory.openSession()) {
	
			tx = session.beginTransaction();
			Query<Employee> query = session.createQuery("FROM Employee E WHERE E.id = :id");
			query.setParameter("id", employeeId);
			Employee employee = query.list().get(0);
			Deal deal1 = new Deal();
			Deal deal2 = new Deal();
			deal1.setName("deal1");
			deal1.setEmployee(employee);
			deal2.setName("deal2");
			deal2.setEmployee(employee);
			
			
			// In case employee will own the relationships, we need to do changes in employee entity
//			employee.setDeals(new HashSet<Deal>(Arrays.asList(deal1, deal2)));
			
			session.save(deal1);
			session.save(deal2);
			
			tx.commit();
			
		}
		
	}

	private void querySingleEmployeeById(int id) {
		
		Transaction tx = null;
		try (Session session = factory.openSession()) {
			tx = session.beginTransaction();
			Query<Employee> query = session.createQuery("FROM Employee E WHERE E.id = :id");
			query.setParameter("id", id);
			List<Employee> employees = query.list();
			System.out.println(employees.get(0));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

	/* Method to CREATE an employee in the database */
	public Integer addEmployee(String fname, String lname, int salary) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;

		try {
			tx = session.beginTransaction();
			Employee employee = new Employee();
			employee.setFirstName(fname);
			employee.setLastName(lname);
			employee.setSalary(salary);
			employeeID = (Integer) session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeID;
	}

	/* Method to READ all the employees */
	public void listEmployees() {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM Employee").list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();
				System.out.print("First Name: " + employee.getFirstName());
				System.out.print("  Last Name: " + employee.getLastName());
				System.out.print("  Salary: " + employee.getSalary());
				System.out.print("\tDeals: " + employee.getDeals());
				System.out.println("\tProjects: " + employee.getProjects());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to UPDATE salary for an employee */
	public void updateEmployee(Integer EmployeeID, int salary) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, EmployeeID);
			employee.setSalary(salary);
			session.update(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to DELETE an employee from the records */
	public void deleteEmployee(Integer EmployeeID) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, EmployeeID);
			session.delete(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	/* Method to  READ all the employees using Scalar Query */
	   public void listEmployeesScalar( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         String sql = "SELECT first_name, salary FROM EMPLOYEE";
	         NativeQuery query = session.createSQLQuery(sql);
	         query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	         List data = query.list();

	         for(Object object : data) {
	            Map row = (Map)object;
	            System.out.print("First Name: " + row.get("first_name")); 
	            System.out.println(", Salary: " + row.get("salary")); 
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }

	   /* Method to READ all the employees using Entity Query */
	   public void listEmployeesEntity( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         String sql = "SELECT * FROM EMPLOYEE";
	         NativeQuery query = session.createSQLQuery(sql);
	         query.addEntity(Employee.class);
	         List employees = query.list();

	         for (Iterator iterator = employees.iterator(); iterator.hasNext();){
	            Employee employee = (Employee) iterator.next(); 
	            System.out.print("First Name: " + employee.getFirstName()); 
	            System.out.print("  Last Name: " + employee.getLastName()); 
	            System.out.println("  Salary: " + employee.getSalary()); 
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
}
