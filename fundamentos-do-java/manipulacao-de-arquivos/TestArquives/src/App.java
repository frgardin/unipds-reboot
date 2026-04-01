public class App {
    public static void main(String[] args) throws Exception {
        String fileName = GeradorDeArquivoGigante.generateArquive();
        
        System.out.println("---------> Testando Java Nio");

        System.out.println("JavaIOClassicoBenchmark: " + JavaIOClassicoBenchmark.verify(fileName) + "ms");

        System.out.println("JavaNIOUsandoFileChannelBenchmark: " + JavaNIOUsandoFileChannelBenchmark.verify(fileName) + " ms");

        System.out.println("JavaNIO2ReadAllLines: " + JavaNIO2ReadAllLines.verify(fileName) + " ms");
        DeletadorDeArquivos.delete(fileName);
    }
}
