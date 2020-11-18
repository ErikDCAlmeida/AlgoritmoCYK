package algoritmocyk;

import java.util.ArrayList;
import java.util.Arrays;

public class AlgorCYK {
    
    private String[] arrPalavra;
    private ArrayList<ArrayList<String>> arrGramatica;
    private Geradores[][] arrTabelaTestePalavra;

    public AlgorCYK(String palavra, ArrayList<ArrayList<String>> arrRecebido) {
        super();
        arrPalavra = new String[palavra.length()];
        arrPalavra = palavra.split(" ");
        this.arrGramatica = arrRecebido;
        this.arrTabelaTestePalavra = new Geradores[arrPalavra.length][arrPalavra.length];
    }

    public String verificarPalavra(){
        for (int i = 0; i < arrPalavra.length; i++) {
            Geradores geradores = new Geradores();
            String letra = this.arrPalavra[i];
            String geradorLetra = null;
            for (int j = 0; j < arrGramatica.size(); j++) {
                for (int k = 0; k < arrGramatica.get(j).size(); k++) {
                    if (arrGramatica.get(j).get(k).equals(letra)) {
                        geradorLetra = arrGramatica.get(j).get(0);
                        geradores.adicionarGeradores(geradorLetra);
                    }
                }
            }            
            for (int j = 0; j < arrPalavra.length; j++) {
                this.arrTabelaTestePalavra[0][i] = geradores;
            }
        }
        System.out.println(Arrays.toString(this.arrTabelaTestePalavra[0]));
        return "Palavra não pertence a gramática!";
    }

    public Geradores[][] getArrTabelaTestePalavra() {
        return arrTabelaTestePalavra;
    }

    public ArrayList<ArrayList<String>> getArrGramatica() {
        return arrGramatica;
    }
    public String[] getArrPalavra() {
        return arrPalavra;
    }

}
