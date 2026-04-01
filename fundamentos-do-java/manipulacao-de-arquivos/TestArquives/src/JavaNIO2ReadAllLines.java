import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JavaNIO2ReadAllLines {

    public static long verify(String fileName) throws Exception {
        Path path = Paths.get(fileName);

        long start, end;
        start = System.currentTimeMillis();
        List<String> lines = Files.readAllLines(path);
        end = System.currentTimeMillis();
        return end - start;
    }
}
