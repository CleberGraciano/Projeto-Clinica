
package Conection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConexaoBD {
    
    public Statement stm; // Responsavél por realizar a pesquisa no Banco de dados 
    public ResultSet rs; // Armazena o resultado da pesquisa 
    private String driver = "org.postgresql.Driver"; // Identifica o Serviço de banco de dados 
    private String caminho = "jdbc:postgresql://localhost:5432/projetoclinica"; // Caminho do Banco de dados 
    private String usuario = "postgres"; // Usuario do Banco de dados
    private String senha = "root"; // Senha do banco de dados
    public Connection con;// Realizar a conexão com o Banco de Dados 
    
    
    
    
    
    
    
    
    //Metodo responsavel para realizar a coinexão com o banco de dados
    public void conexao(){
       
        try {
            System.setProperty("jdbc.Drivers", driver); // Responsavel por setar propriedade do driver de conexão
            setCon(DriverManager.getConnection(caminho, usuario, senha));
           // JOptionPane.showMessageDialog(null,"Conexão realizada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro de conexão com banco de dados:\n "+ex.getMessage());
            ex.printStackTrace();
        }
        
    }
    
    
    public void executaSql(String sql){
        
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);// difere a consulta de maiuscula para minusculo, CONCUR_READ_ONLY VAI SER ROLAVEL E PERCORRE TANTO DO INICIO PARA O FIM 
            rs=stm.executeQuery(sql);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao executar SQL:\n "+ex.getMessage());
            
            
        }
        
    }
    
    
    
    // Metodo responsavel para desconectar a conexão com o banco de dados
    public void desconecta(){
        
        try {
            getCon().close();
            //JOptionPane.showMessageDialog(null,"Conexão fechada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Falha ao desconectar conexão \n "+ex.getMessage());
            ex.printStackTrace();
        }
        
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }
    
    
}
