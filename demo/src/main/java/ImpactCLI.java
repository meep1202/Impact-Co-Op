import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import java.util.concurrent.Callable;

@Command(name = "request", mixinStandardHelpOptions = true, version = "request 1.0", description = "Use option -n to remove request for a job")
public class ImpactCLI implements Callable<Integer> {
    public static void request(String text) {
        System.out.println(text);
    }

    @Option(names = {"-n", "--no"}, description = "Removes my request for a job")
    private String requestString = "Yes";

    public Integer call() {
        if (requestString == "Yes") {
            System.out.println("Please hire me Impact!!");
        }
        else {
            System.out.println(":(");
        }
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ImpactCLI()).execute(args);
        System.exit(exitCode);
    }
}
