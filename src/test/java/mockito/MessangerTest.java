package mockito;


import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MessangerTest {
	
	@Mock
	private TemplateEngine mockTemplateEngine;
	
	@Mock
	private MailServer mockMailServer;
	
	@InjectMocks
	private Messenger testInstance;
	
	@Captor
	private ArgumentCaptor<Email> argumentCaptor;
	
	@Mock
	private Client mockClient;
	
	@Mock
	private Template mockTemplate;
	
	@Test
	public void shouldSendEmailHappyPath() {
		testInstance.sendMessage(new Client(), new Template());
	
		verify(mockMailServer).send(any(Email.class));
	}
	
	@Test
	public void shouldSendEmailWithClientEmailAddress() {
		String testClientEmail = "test@test.com";
		when(mockClient.getEmail()).thenReturn(testClientEmail);
		
		testInstance.sendMessage(mockClient, mockTemplate);
		
		verify(mockMailServer).send(argumentCaptor.capture());
		verify(mockClient).getEmail();
		assertEquals(testClientEmail, argumentCaptor.getValue().getAddressee());
	}
	

}

