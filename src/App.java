import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import algoritmocyk.AlgorCYK;
import algoritmocyk.Geradores;
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

            boolean resultado = algorCYK.verificarPalavra();
            String strResultado = "";
            if (resultado == true) {
                strResultado = "A palavra pertence a gramática!";
            } else {
                strResultado = "A palavra nao pertence a gramática!";
            }
            for (int i = 0; i < algorCYK.getmatrizTestePalavra().length; i++) {
                for (int j = 0; j < algorCYK.getmatrizTestePalavra()[i].length; j++) {
                    if (j > (algorCYK.getmatrizTestePalavra()[i].length - (i + 1))) {
                        algorCYK.getmatrizTestePalavra()[i][j] = new Geradores();
                    }
                }
            }
            StringBuilder stringB = new StringBuilder();
            for (int i = algorCYK.getmatrizTestePalavra().length - 1; i >= 0; i--) {
                stringB.append(i).append(": ").append(Arrays.toString(algorCYK.getmatrizTestePalavra()[i])).append("\n");
            }
            String escolha = JOptionPane.showInputDialog(null, "Resultado: " + strResultado + "\n\n" +
                                                            "Matriz do seu teste: \n" + stringB +
                                                            "OBS.: Para entender a matriz, as linhas/colunas que estão com {} podem ser desconsideradas.\n" +
                                                            "O que está como 'null' é considerado como espaços vazios.\n\n" +
                                                            "Se não desejar fazer outro teste digite a letra 'n', " +
                                                            "caso contrário, qualquer outra letra ou símbolo continuará o programa.").toUpperCase();
            System.out.println("\n");
            if (escolha.equals("N")) {
                break;
            }
        }
        JOptionPane.showMessageDialog(null, "O programa foi finalizado!", "Finalizado", 1);
        

    }

}