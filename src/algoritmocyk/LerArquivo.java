package algoritmocyk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LerArquivo {

    private String path;
    private ArrayList<ArrayList<String>> arrLinhas;

    public LerArquivo(String caminho) {
        super();
        this.path = caminho;
        arrLinhas = new ArrayList<>();
    }
    
    public ArrayList<ArrayList<String>> ler() throws IOException{
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        ArrayList<String> arrLinha = new ArrayList<>();
		while (true) {
			if (linha != null) {
                arrLinha.add(linha);
			} else {
                break;
            }
            linha = buffRead.readLine();
        }
        arrLinha.remove(0);
        buffRead.close();
        for (int i = 0; i < arrLinha.size(); i++) {
            String[] arr = arrLinha.get(i).split(" ");
            ArrayList<String> aux = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                if (!(arr[j].equals("=>") || arr[j].equals("|"))) {
                    aux.add(arr[j]);
                }
            }
            this.arrLinhas.add(aux);
        }
        return this.arrLinhas;
    }

}
