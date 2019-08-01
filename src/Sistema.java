import java.util.ArrayList;

public class Sistema {

    private ArrayList<Cliente> fila;

    public Sistema (){
        fila = new ArrayList<>();
    }

    public void adicionarClienteFila(Cliente c){
        fila.add(c);
    }
}
