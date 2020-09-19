package mockito;

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
	
	

}
