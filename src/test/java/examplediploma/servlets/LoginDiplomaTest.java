//package examplediploma.servlets;
//
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.spy;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.io.IOException;
//import java.util.Hashtable;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.naming.spi.InitialContextFactory;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.sql.DataSource;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import examplediploma.dao.UserDao;
//@ExtendWith(MockitoExtension.class)
////@RunWith(MockitoJUnitRunner.class)
//public class LoginDiplomaTest {
//
//	
//	public static final String ERROR_MSG_ATTRIBUTE = "errorMsg";
//	public static final String USER_NOT_FOUND_ERR_MSG = "Password or Email is not valid";
//	
//	private static final String CONTEXT_PATH = "http://localhost:8080/servletExamples";
//	private static final String RESOURCE_TO_REDIRECT = "/examplediploma/successSignUp.jsp";
//
//	
//	@Mock
//	private HttpServletRequest req;
//	
//	@Mock
//	private HttpServletResponse resp;
//	
//	@Mock
//	private UserDao userDao;
//	
//	@Mock
//	private ServletContext servletContext;
//	
//	@Mock
//	private RequestDispatcher rdMock;
//
//	@Mock
//	private InitialContextFactory ctx;
//	
//	private LoginDiploma testInstance;
//
//	@BeforeEach
//	public void setUp() {
//		System.setProperty("java.naming.factory.initial",
//			      this.getClass().getCanonicalName() + "$MyContextFactory");
//		testInstance = spy(new LoginDiploma());
//		doReturn(servletContext).when(testInstance).getServletContext();
//		when(servletContext.getContextPath())
//			.thenReturn(CONTEXT_PATH);
//		
//		testInstance.setUserDao(userDao);
//	}
//
//	
//	@Test
//	public void shouldRedirectToLoginPageWithErrorWhenNoSuchUser() throws ServletException, IOException {
//		// GIVEN
//		when(userDao.getUserByEmail(anyString())).thenReturn(null);
//		when(req.getRequestDispatcher(anyString())).thenReturn(rdMock);
//		
//		// WHEN
//		testInstance.doPost(req, resp);
//		
//		// THEN
//		verify(req).setAttribute(ERROR_MSG_ATTRIBUTE, USER_NOT_FOUND_ERR_MSG);
//		verify(req).getRequestDispatcher("WEB-INF/examplediploma/login.jspa");
//	}
//	
//	
//
//	public static class MyContextFactory implements InitialContextFactory {
//		@Override
//		public Context getInitialContext(Hashtable<?, ?> environment) throws NamingException {
//			DataSource mockConnFact = mock(DataSource.class);
//			InitialContext mockCtx = mock(InitialContext.class);
//			Context mockContext = mock(Context.class);
//			when(mockCtx.lookup("java:comp/env")).thenReturn(mockContext);
//			when(mockContext.lookup("connpool")).thenReturn(mockConnFact);
//			return mockCtx;
//		}
//	}
//}
