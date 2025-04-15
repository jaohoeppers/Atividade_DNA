//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GerenciadorDeArquivos gerenciador = new GerenciadorDeArquivos();

        for (int x = 0; x < 10; x++) {
            int finalX = x;

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread " + Thread.currentThread().getName() + " start and started to read archive: dna-"+ finalX +".txt");
                    synchronized(gerenciador) {gerenciador.LerFita2("dna-"+ finalX +".txt");}
                }
            });

            thread.setName("Thread "+finalX);

            thread.start();

        }

//        System.out.println(a);
    }
}