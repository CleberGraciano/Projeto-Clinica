
package Dao;

import Conection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelBeans.Usuario;


public class UsuarioDao {
    
    ConexaoBD conex = new ConexaoBD();
    Usuario usuarioBean = new Usuario();
    
    public void salvar(){
        
        conex.conexao();
        
        try {
            
            PreparedStatement pst = conex.getCon().prepareStatement("insert into usuarios (nome, usuario, senha, confirmaSenha, tipo) values (?, ?, ?, ?, ?) ");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
}
