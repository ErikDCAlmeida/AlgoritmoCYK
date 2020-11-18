import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import algoritmocyk.AlgorCYK;
import algoritmocyk.LerArquivo;

public class App {
    
    public static void main (String[] args) throws IOException {

        String palavra = "";
        String caminho = "";
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(jfc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            caminho = jfc.getSelectedFile().getAbsoluteFile().toString();
        }

        while(true){
            palavra = JOptionPane.showInputDialog(null, "Digite sua palavra:");
            LerArquivo arquivo = new LerArquivo(caminho);
            AlgorCYK algorCYK = new AlgorCYK(palavra, arquivo.ler());
            System.out.println(algorCYK.getArrGramatica() + "\n" + Arrays.toString(algorCYK.getArrPalavra()));
            String escolha = JOptionPane.showInputDialog(null, "O resultado do teste foi:\n\n" + 
                                                            algorCYK.verificarPalavra() + "\n\n" + "Se não desejar fazer outro teste digite a letra 'n', "+ 
                                                            "caso contrário, qualquer outra letra continuará o programa.").toUpperCase();
            System.out.println("\n");
            System.out.println(Arrays.deepToString(algorCYK.getArrTabelaTestePalavra()));
            if (escolha.equals("N")) {
                break;
            }
        }
        JOptionPane.showMessageDialog(null, "O programa foi finalizado!", "Finalizado", 1);
        

    }

}