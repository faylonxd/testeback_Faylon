
package testevalemobifaylon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faylon Afonso Benedito
 */
public class Cliente {
    
    //Criação dos Atributos do Cliente
    private int idCliente, cpfCliente;
    private String nomeCliente;
    private boolean ativoCliente;
    private Float valorTotalCliente;

    
    //Criação dos metodos get e set do Cliente
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(int cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String NomeCliente) {
        this.nomeCliente = NomeCliente;
    }

    public boolean isAtivoCliente() {
        return ativoCliente;
    }

    public void setAtivoCliente(boolean ativoCliente) {
        this.ativoCliente = ativoCliente;
    }

    public Float getValorTotalCliente() {
        return valorTotalCliente;
    }

    public void setValorTotalCliente(Float valorTotalCliente) {
        this.valorTotalCliente = valorTotalCliente;
    }
    
     
    
    // Metodo para Inserir um Cliente no Banco de dados
    public void InserirCliente(int idCliente, int cpfCliente, String NomeCliente, boolean ativoCliente, Float valorTotalCliente) {
        this.cpfCliente = cpfCliente;
        this.nomeCliente = NomeCliente;
        this.ativoCliente = ativoCliente;
        this.valorTotalCliente = valorTotalCliente;
        String cmd = "INSERT INTO `dbclientes`.`tb_clientes` (`id_customer`,`cpf_cnpj`,`nm_customer`,`is_active`,`vl_total`) VALUES("+idCliente+","+cpfCliente+",'"+nomeCliente+"',"+ativoCliente+","+valorTotalCliente+");";
                
        try {
            Connection con = ConexaoMySQL.getInstance().getConnection();
            con.createStatement().executeUpdate(cmd);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
        //Metodo Para Calular a Media de Acordo com o solicitado
        public void CalcularMedia(){
            Cliente objCliente = new Cliente();
            int qtdElementos=0;
            float media=0;
            ArrayList linha = new ArrayList();
            ResultSet rs = null;
            Connection con = ConexaoMySQL.getInstance().getConnection();
            try {
            PreparedStatement sql = con.prepareStatement("Select id_customer, cpf_cnpj, nm_customer, is_active, vl_total from tb_clientes where vl_total > 560 AND id_customer between 1500 and 2700 order by vl_total DESC");
            rs = sql.executeQuery();
                while(rs.next()){
                    setIdCliente(Integer.parseInt(rs.getString(1)));
                    setCpfCliente(Integer.parseInt(rs.getString(2)));
                    setNomeCliente(rs.getString(3));
                    setAtivoCliente(Boolean.parseBoolean(rs.getString(4)));
                    setValorTotalCliente(Float.parseFloat(rs.getString(5)));
                    media=media+getValorTotalCliente();
                    qtdElementos = qtdElementos+1;
                    
                    System.out.println("Cliente Utilizado para calculo da Média: "+getNomeCliente()+ ", com o Saldo de: "+getValorTotalCliente()+ " e ID: "+getIdCliente());
                    
                    linha.add(rs);                   
                }
              } catch (SQLException e) {
            e.printStackTrace();
           }
            media=media/qtdElementos;
            System.out.println("A media é: "+ media);
           
        }
    }
