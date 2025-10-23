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
    }
    public int getCantClientesEsperando(){
        return clientesEnCola.size();
    }
    public Cliente desencolarCliente(){
        return clientesEnCola.remove();
    }

}
