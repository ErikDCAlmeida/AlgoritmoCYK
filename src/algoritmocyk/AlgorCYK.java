package algoritmocyk;

import java.util.ArrayList;
import java.util.Arrays;

public class AlgorCYK {
    
    private String[] arrPalavra;
    private ArrayList<ArrayList<String>> arrGramatica;
    private Geradores[][] matrizTestePalavra;
    private ArrayList<Character> arrCaracteresGramatica;

    public AlgorCYK(String palavra, ArrayList<ArrayList<String>> arrRecebido) {
        super();
        arrPalavra = new String[palavra.length()];
        arrPalavra = palavra.split(" ");
        this.arrGramatica = arrRecebido;
        this.arrCaracteresGramatica = new ArrayList<>();
        this.matrizTestePalavra = new Geradores[arrPalavra.length][arrPalavra.length];
    }

    public boolean verificarPalavra(){
        for (int i = 0; i < arrPalavra.length; i++) {
            Geradores geradores = new Geradores();
            String letra = this.arrPalavra[i];
            String geradorLetra = null;
            for (int j = 0; j < arrGramatica.size(); j++) {
                for (int k = 0; k < arrGramatica.get(j).size(); k++) {
                    for (int j2 = 0; j2 < arrGramatica.get(j).get(k).length(); j2++) {
                        if (!this.arrCaracteresGramatica.contains(arrGramatica.get(j).get(k).charAt(j2))) {
                            this.arrCaracteresGramatica.add(arrGramatica.get(j).get(k).charAt(j2));
                        }
                    }
                    if (arrGramatica.get(j).get(k).equals(letra)) {
                        geradorLetra = arrGramatica.get(j).get(0);
                        geradores.adicionarGeradores(geradorLetra);
                    }
                }
            }   
            for (int j = 0; j < arrPalavra.length; j++) {
                this.matrizTestePalavra[0][i] = geradores;
            }
        }

        for (int i = 0; i < this.matrizTestePalavra.length - 1; i++) {
            this.testadorAuxiliar(i, (i + 1), this.arrCaracteresGramatica);
        }

        System.out.println("Array com caracteres do alfabeto: " + this.arrCaracteresGramatica);

        System.out.println(Arrays.deepToString(this.matrizTestePalavra));

        if (this.matrizTestePalavra[this.matrizTestePalavra.length-1][0] != null) {
            return this.matrizTestePalavra[this.matrizTestePalavra.length-1][0].contemElemento(this.arrGramatica.get(0).get(0));
        } else { 
            return false;
        } 
    }

    private void testadorAuxiliar(int linhaAtual, int colunasAtuais, ArrayList<Character> arrCaracteres){
        ArrayList<ArrayList<String>> arrTeste = new ArrayList<>();
        for (int j = 0; j < this.matrizTestePalavra[linhaAtual].length-colunasAtuais; j++) {
            ArrayList<String> auxCombinarGeradores = this.combinarGeradores(this.matrizTestePalavra[linhaAtual][j], this.matrizTestePalavra[linhaAtual][j+1], arrCaracteres);
            ArrayList<String> auxTeste = new ArrayList<>();
            for (int i = 0; i < auxCombinarGeradores.size(); i++) {
                auxTeste.add(auxCombinarGeradores.get(i));
            }
            arrTeste.add(auxTeste);
        }
        System.out.println("??????Array Teste: " + arrTeste);
        for (int i = 0; i < arrTeste.size(); i++) {
            for (int j = 0; j < arrGramatica.size(); j++) {
                for (int k = 0; k < arrGramatica.get(j).size(); k++) {
                    for (int k2 = 0; k2 < arrTeste.get(i).size(); k2++) {
                        if (arrTeste.get(i).get(k2) != null) {
                            if (arrTeste.get(i).get(k2).equals(arrGramatica.get(j).get(k))){
                                Geradores geradores = new Geradores();
                                geradores.adicionarGeradores(arrGramatica.get(j).get(0));
                                this.matrizTestePalavra[linhaAtual + 1][i] = geradores;
                            }
                        } else {
                            Geradores geradores = new Geradores();
                            this.matrizTestePalavra[linhaAtual + 1][i] = geradores;
                        }
                    }
                }
            }
        }
    }

    public ArrayList<String> combinarGeradores(Geradores gerador1, Geradores gerador2, ArrayList<Character> arrCaracteres){
        ArrayList<String> str = new ArrayList<>();
        if (gerador1 != null) {
            for (int i = 0; i < gerador1.getListaGeradores().size(); i++) {
                if (gerador2 != null) {
                    for (int j = 0; j < gerador2.getListaGeradores().size(); j++) {
                        if (gerador1.getListaGeradores().get(i) == null) {
                            for (int j2 = 0; j2 < arrCaracteres.size(); j2++) {
                                String combinacao = arrCaracteres.get(j2) + gerador2.getListaGeradores().get(j);
                                str.add(combinacao);
                            }
                        } else if (gerador2.getListaGeradores().get(i) == null){
                            for (int j2 = 0; j2 < arrCaracteres.size(); j2++) {
                                String combinacao = gerador1.getListaGeradores().get(i) + arrCaracteres.get(j2);
                                str.add(combinacao);
                            }
                        } else if (gerador1.getListaGeradores().get(i) != null && gerador2.getListaGeradores().get(i) != null) {
                            String combinacao = gerador1.getListaGeradores().get(i) + gerador2.getListaGeradores().get(j);
                            str.add(combinacao);
                        }
                    }
                } else {
                    for (int j2 = 0; j2 < arrCaracteres.size(); j2++) {
                        String combinacao = gerador1.getListaGeradores().get(i) + arrCaracteres.get(j2);
                        str.add(combinacao);
                    } 
                }
            }
        } else if (gerador2 != null) {
            for (int j = 0; j < gerador2.getListaGeradores().size(); j++) {
                for (int j2 = 0; j2 < arrCaracteres.size(); j2++) {
                    String combinacao = arrCaracteres.get(j2) + gerador2.getListaGeradores().get(j);
                    str.add(combinacao);
                }
            }
        } 
        
        return str;
    }

    public Geradores[][] getmatrizTestePalavra() {
        return matrizTestePalavra;
    }

    public ArrayList<ArrayList<String>> getArrGramatica() {
        return arrGramatica;
    }
    public String[] getArrPalavra() {
        return arrPalavra;
    }

}
