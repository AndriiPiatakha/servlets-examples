package lectures.unittesting;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.Timeout;
import org.junit.runners.model.TestTimedOutException;

public class DemoRules {
	
	@Rule
	public ExpectedException ex = ExpectedException.none();
	@Rule
	public Timeout tr = Timeout.seconds(1);
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();
	
	@Test
	public void someTest() {
		ex.expect(IllegalArgumentException.class);
		ex.expectMessage("Some error message");
		ex.expectCause(instanceOf(FileNotFoundException.class));
		
		IllegalArgumentException iae = 
				new IllegalArgumentException("Some error message");
		iae.initCause(new FileNotFoundException());
		throw iae;
	}
	
	@Test
	public void timeoutTest() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
	}
	

	@Test
	public void test() throws IOException {
		File file = tempFolder.newFile("./testFile.txt");
		file.createNewFile();
		try (PrintWriter pw = new PrintWriter(file); BufferedReader br = new BufferedReader(new FileReader(file));) {
			pw.println("asdasdasd");
			pw.close();

			String readLine = br.readLine();
			System.out.println(readLine);
		}
	}

}
