import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

/**
 * Integration test that feeds {@link PCOMain} with the scripted input stored
 * in {@code input1.txt} and ensures the console output matches the transcript
 * in {@code inputs&outputs.txt}. This validates the full interactive flow,
 * including eliminations and accomodations, without requiring manual play.
 */
public class PCOMainIOTest {

	@Test
	public void playsScriptedSessionFromFile() throws Exception {
		String inputScript = Files.readString(Path.of("input1.txt"), StandardCharsets.UTF_8);
		String expectedOutput = Files.readString(Path.of("inputs&outputs.txt"), StandardCharsets.UTF_8);

		InputStream originalIn = System.in;
		PrintStream originalOut = System.out;

		ByteArrayInputStream scriptedInput =
				new ByteArrayInputStream(inputScript.getBytes(StandardCharsets.UTF_8));
		ByteArrayOutputStream capturedOutput = new ByteArrayOutputStream();
		PrintStream testPrintStream = new PrintStream(capturedOutput, true, StandardCharsets.UTF_8);

		try {
			System.setIn(scriptedInput);
			System.setOut(testPrintStream);
			PCOMain.main(new String[0]);
		} finally {
			System.setIn(originalIn);
			System.setOut(originalOut);
		}

		String normalizedExpected = normalizeLineEndings(expectedOutput);
		String normalizedActual = normalizeLineEndings(capturedOutput.toString(StandardCharsets.UTF_8));

		assertEquals(normalizedExpected, normalizedActual,
				"Console output must match the expected transcript.");
	}

	private static String normalizeLineEndings(String value) {
		return value.replace("\r\n", "\n").replace("\r", "\n");
	}
}

