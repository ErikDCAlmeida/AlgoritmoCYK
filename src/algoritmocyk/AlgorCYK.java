package algoritmocyk;

import java.util.ArrayList;

public class AlgorCYK {
    
    private String[] arrPalavra;
    private ArrayList<ArrayList<String>> arrGramatica;
    private ArrayList<String[]> arrTabelaTestePalavra;

    public AlgorCYK(String palavra, ArrayList<ArrayList<String>> arrRecebido) {
        super();
        arrPalavra = new String[palavra.length()];
        arrPalavra = palavra.split(" ");
        this.arrGramatica = arrRecebido;
        this.arrTabelaTestePalavra = new ArrayList<>();
        for (int i = 0; i < arrPalavra.length; i++) {
            String[] linha = new String[i+1];
            this.arrTabelaTestePalavra.add(linha);
        }
    }

    public ArrayList<ArrayList<String>> getArrGramatica() {
        return arrGramatica;
    }
    public String[] getArrPalavra() {
        return arrPalavra;
    }

}
