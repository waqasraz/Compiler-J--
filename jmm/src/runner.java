import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class runner {

	public runner() {
		runIt("/usr/bin/arm-linux-gnueabi-as   -o prog.o rts.s file.s");
		runIt("/usr/bin/arm-linux-gnueabi-ld -o a.out prog.o");
		// runIt("/usr/bin/qemu-system-arm -nographic -monitor null -cpu any -serial null -semihosting -kernel a.out");
	}

	/**
	 * To run and show the output of the making assembly process
	 * 
	 * @param cmd
	 */
	public void runIt(String cmd) {
		String s = null;

		try {

			// using the Runtime exec method:
			Process p = Runtime.getRuntime().exec(cmd);
			// Process p =
			// Runtime.getRuntime().exec("/usr/bin/arm-linux-gnueabi-ld -o a.out prog.o");

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(
					p.getInputStream()));

			BufferedReader stdError = new BufferedReader(new InputStreamReader(
					p.getErrorStream()));

			// read the output from the command
			// System.out.println("Here is the standard output of the command:\n");
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}

			// read any errors from the attempted command
			// System.out.println("Here is the standard error of the command (if any):\n");
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);
			}

			// System.exit(0);
		} catch (IOException e) {
			System.out.println("exception happened - here's what I know: ");
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
