package g7.frsf.utn.seguimiento.estadodelsistema;

import java.util.LinkedList;
import java.util.Queue;



public class Cola {
    private Queue<Cliente> clientesEnCola;
    private Integer cantClientesEnCola;


    public Cola(){
        super();
        clientesEnCola =new LinkedList<Cliente>();
        cantClientesEnCola = 0;
    }

    public void encolarCliente(Cliente clienteArribado){
        clientesEnCola.add(clienteArribado);
        cantClientesEnCola++;
    }
    public int getCantClientesEsperando(){
        // ! Tambien podria retornar cantClientesEnCola (propiedad redundante)
        return clientesEnCola.size();
    }
    public Cliente desencolarCliente(){
        cantClientesEnCola--;
        return clientesEnCola.remove();
    }

}
