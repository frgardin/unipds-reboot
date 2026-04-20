import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaIOClassicoBenchmark {

    public static long verify(String fileName) throws Exception {
        Path path = Paths.get(fileName);

        long start, end;
        start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader(path.toFile()));
        while (br.readLine()!= null); // nao faz nada apenas le
        end = System.currentTimeMillis();
        return end-start;
    }
}

