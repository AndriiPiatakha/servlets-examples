package examplediploma.servlets;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.exceptions.verification.NeverWantedButInvoked;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.protobuf.Any;

import examplediploma.dao.UserDao;
import examplediploma.models.UserData;

@RunWith(MockitoJUnitRunner.class)
public class SignUpDimplomaTest {

	private static final String CONTEXT_PATH = "http://localhost:8080/servletExamples";
	private static final String RESOURCE_TO_REDIRECT = "/examplediploma/successSignUp.jsp";

	@Mock
	private UserDao userDaoMock;

	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	@Mock
	private ServletContext servletContext;

	@Mock
	private InitialContextFactory ctx;

	@Captor
	private ArgumentCaptor<UserData> captor;

	private SignUpDiploma testInstanceSpy;

	@Before
	public void setUp() {
		System.setProperty("java.naming.factory.initial",
			      this.getClass().getCanonicalName() + "$MyContextFactory");
		testInstanceSpy = spy(new SignUpDiploma());
		doReturn(servletContext).when(testInstanceSpy).getServletContext();
		when(servletContext.getContextPath())
			.thenReturn(CONTEXT_PATH);
		testInstanceSpy.setUserDao(userDaoMock);
	}

	@Test
	public void shouldRedirectResponseInCaseOfSuccess() throws ServletException, IOException {
		testInstanceSpy.doPost(request, response);
		String pathToRedirect = CONTEXT_PATH + RESOURCE_TO_REDIRECT;
		verify(response).sendRedirect(pathToRedirect);
	}
	
	@Test
	public void shouldSaveUserWithParametersFromRequest() throws ServletException, IOException { 
		String firstNameParameter = "Andrey";
		when(request.getParameter("first_name")).thenReturn(firstNameParameter);
		
		testInstanceSpy.doPost(request, response);
		
		verify(userDaoMock).saveUser(captor.capture());
		UserData user = captor.getValue();
		assertEquals(firstNameParameter, user.getName());
	}
	
	@Test
	public void shouldNotSaveUserIfError() throws ServletException, IOException {
		when(request.getParameter(Matchers.anyString()))
			.thenThrow(RuntimeException.class);
		
		testInstanceSpy.doPost(request, response);
		
		verify(userDaoMock, Mockito.never()).saveUser(Matchers.any(UserData.class));
	}
	

	public static class MyContextFactory implements InitialContextFactory {
		@Override
		public Context getInitialContext(Hashtable<?, ?> environment) throws NamingException {
			DataSource mockConnFact = mock(DataSource.class);
			InitialContext mockCtx = mock(InitialContext.class);
			Context mockContext = mock(Context.class);
			when(mockCtx.lookup("java:comp/env")).thenReturn(mockContext);
			when(mockContext.lookup("connpool")).thenReturn(mockConnFact);
			return mockCtx;
		}
	}

}
