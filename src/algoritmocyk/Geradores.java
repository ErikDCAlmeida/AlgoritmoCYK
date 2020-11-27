package algoritmocyk;

import java.util.ArrayList;

public class Geradores {
    
    private ArrayList<String> listaGeradores;

    public Geradores() {
        super();
        this.listaGeradores = new ArrayList<>();
    }

    public void adicionarGeradores(String gerador){
        if (!this.listaGeradores.contains(gerador)) {
            this.listaGeradores.add(gerador);
        }
    }

    public ArrayList<String> getListaGeradores() {
        return listaGeradores;
    }

    public boolean contemElemento(String elemento){
        for (int i = 0; i < this.listaGeradores.size(); i++) {
            if (this.listaGeradores.get(i).equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{");
        for (int i = 0; i < listaGeradores.size(); i++) {
            if (i != listaGeradores.size()-1) {
                str.append(listaGeradores.get(i)).append(", ");
            } else {
                str.append(listaGeradores.get(i));
            }
        }
        str.append("}");
        return str.toString();
    }

}
