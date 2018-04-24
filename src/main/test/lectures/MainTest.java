package lectures;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import lectures.easymock.TestEasyMock;
import lectures.mockito.DemoMock;
import lectures.unittesting.HamcrestTest;



@RunWith(Suite.class)
@SuiteClasses({TestEasyMock.class, DemoMock.class, HamcrestTest.class})
public class MainTest {
}
