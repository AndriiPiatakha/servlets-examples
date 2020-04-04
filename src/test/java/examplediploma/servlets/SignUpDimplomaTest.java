package examplediploma.servlets;

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
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import examplediploma.dao.UserDao;
import examplediploma.models.UserData;

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
		MockitoAnnotations.initMocks(this);
		System.setProperty("java.naming.factory.initial",
			      this.getClass().getCanonicalName() + "$MyContextFactory");
		testInstanceSpy = spy(new SignUpDiploma());
		doReturn(servletContext).when(testInstanceSpy).getServletContext();
		when(servletContext.getContextPath())
			.thenReturn(CONTEXT_PATH);
	}

	@Test
	public void shouldRedirectResponseInCaseOfSuccess() throws ServletException, IOException {
		testInstanceSpy.setUserDao(userDaoMock);
		testInstanceSpy.doPost(request, response);
		String pathToRedirect = CONTEXT_PATH + RESOURCE_TO_REDIRECT;
		verify(response).sendRedirect(pathToRedirect);
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
