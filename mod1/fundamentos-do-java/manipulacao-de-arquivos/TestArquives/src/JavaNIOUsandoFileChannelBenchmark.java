import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class JavaNIOUsandoFileChannelBenchmark {

    public static long verify(String fileName) throws Exception {
        Path path = Paths.get(fileName);

        long start, end;
        start = System.currentTimeMillis();
        FileChannel channel = FileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(8192);
        while (channel.read(buffer) != -1) {
            buffer.flip();
            buffer.clear();
        }
        channel.close();
        end = System.currentTimeMillis();
        return end - start;
    }
}
