import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecShell {

    public static Process Execute(String command, int printlog, String error) throws InterruptedException {
        
        Process process;
        try {
            process = Runtime.getRuntime().exec(command);
            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
    
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
    
            int exitVal = process.waitFor();
            if (exitVal == 0 && printlog == 1) {
                System.out.println(output);
            }
            return process;
        } catch (IOException e) {
            if (error != null && (printlog == 1 || printlog == 2)) {
                System.err.println(error);
                System.exit(1);
            }
            else {
                e.printStackTrace();
                System.exit(1);
            }
        }
        return null;
    }

    public static Process Execute(String command, int printlog) throws InterruptedException {
        return Execute(command, printlog, null);
    }

    public static Process Execute(String command) throws InterruptedException {
        return Execute(command, 2, null);
    }

}
