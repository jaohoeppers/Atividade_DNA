import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class GerenciadorDeArquivos {

    public synchronized void LerFita2(String arquivo) {

        String[] a;
        ArrayList<Integer> invalidas = new ArrayList<>();
        int linha = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/arquivosDNA/arquivosDNA/"+arquivo))) {
            String line;
            FileWriter writer = new FileWriter(arquivo+"result.txt");
            while ((line = reader.readLine()) != null) {
                linha +=1;
                a = ConverterFita2(line);

                if(a[1].equals("false")){
                    invalidas.add(linha);
                }
                writer.write(a[0] + "\n");

            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Leu arquivo: " + arquivo);
        System.out.println("Todal de fitas: " + linha);
        System.out.println("Todal de fitas validas: " + (linha - invalidas.size()));
        System.out.println("Todal de fitas invaidas: " + invalidas.size());
        System.out.println("Linha das fitas invalidas: " + invalidas);

    }

    public String[] ConverterFita2(String line){
        StringBuilder nova = new StringBuilder();

        for (String x : line.split("")) {
            switch (x) {
                case "A" -> {
                    nova.append("T");
                }
                case "T" -> {
                    nova.append("A");
                }
                case "G" -> {
                    nova.append("C");
                }
                case "C" -> {
                    nova.append("G");
                }
                default -> {return new String[]{"****FITA INVALIDA - " + line, "false"};}
            }
        }

        StringBuilder sb = new StringBuilder(nova);
        sb.reverse();
//        System.out.println("Antiga: "+line);
//        System.out.println("Nova: "+nova);
//
//        System.out.println("Nova inversa: "+sb);

//        return String.valueOf(sb.reverse());
        return new String[]{String.valueOf(sb.reverse()), "true"};
    }

}
