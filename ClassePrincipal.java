/*

 */
package testevalemobifaylon;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Faylon Afonso Benedito
 */
public class ClassePrincipal extends Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cliente objCliente = new Cliente();
              
        
        //Comandos para criar alguns clientes, apos executar uma vez colocar as linhas como comentario.
        objCliente.InserirCliente(1499, 123123123, "Faylon", true, 1000f);
        objCliente.InserirCliente(1500, 123123123, "AAA", true, 780f);
        objCliente.InserirCliente(1501, 123123123, "BBB", true, 590f);
        objCliente.InserirCliente(1502, 123123123, "CCC", true, 999f);
        objCliente.InserirCliente(1503, 123123123, "DDD", true, 650f);
        objCliente.InserirCliente(1504, 123123123, "EEE", true, 700f);
        objCliente.InserirCliente(1508, 123123123, "FFF", true, 200f);
        
        
         
        //Chamada do metodo que irá calcular as medias e exibir as informações
        objCliente.CalcularMedia();
             
       
    }
    
}
