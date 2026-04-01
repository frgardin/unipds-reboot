import java.io.BufferedWriter;
import java.io.FileWriter;

public class GeradorDeArquivoGigante {
  
    public static String generateArquive() {
        String fileName = "benchmark.txt";
        String linhaBase = "Esta eh uma linha exemplo para benchmark de leitura de arquivo";

        long tamanho = 200L * 1024 * 1024; // 200MB

        try {
            long tamanhoAtual = 0;
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            while (tamanhoAtual < tamanho) {
                writer.write(linhaBase);
                tamanhoAtual+=linhaBase.getBytes().length;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
