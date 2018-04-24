package lectures.unittesting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TempFolderRule {

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

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
