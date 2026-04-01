import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeletadorDeArquivos {
    
    public static boolean delete(String fileName) {
        Path caminho = Paths.get(fileName);
        try {
            return Files.deleteIfExists(caminho);
        } catch (IOException e) {
            System.err.println("Erro ao deletar: " + e.getMessage());
        }
        return false;
    }
}
