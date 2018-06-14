
package Dao;

import Conection.ConexaoBD;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelBeans.Usuario;


public class UsuarioDao {
    
    ConexaoBD conex = new ConexaoBD();
    Usuario usuarioBean = new Usuario();

    
    public void salvar(Usuario usuario){
        
        conex.conexao();
        
        try {
            
            PreparedStatement pst = conex.getCon().prepareStatement("insert into usuarios (nome_usuario, senha_usuario, tipo_usuario) values (?, ?, ?) ");
          
            pst.setString(1,usuario.getNome_usuario());
            pst.setString(2, usuario.getSenha_usuario());
            pst.setString(3, usuario.getTipo_usuario());
  
            pst.execute();
            

            
            JOptionPane.showMessageDialog(null, "Usuario Cadastrado com sucesso");
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Falha ao Salvar Usuario");
            ex.printStackTrace();
        }
        
        conex.desconecta();
    }
    
    public void buscarUsuario (Usuario usuario) {
        conex.conexao();
        conex.executaSql("select * from medicos where nome_medico like'%"+usuario.getPesquisa()+"%'");// realisando a consulta
        try {
            
            conex.rs.first();
            usuario.setCod_usuario(conex.rs.getLong("cod_usuario"));
            usuario.setNome_usuario(conex.rs.getString(""));
            usuario.setSenha_usuario(conex.rs.getString("senha_usuario"));
            usuario.setTipo_usuario(conex.rs.getString("tipo_usuario"));
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        conex.desconecta();
       
    }
    
    public void Editar(Usuario usuario){
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("update usuarios set nome_usuario=?, senha_usuario=?, tipo_usuario=? where cod_usuario=? ");
            pst.setString(1, usuario.getNome_usuario());
            pst.setString(2, usuario.getSenha_usuario());
            pst.setString(3, usuario.getTipo_usuario());
            pst.setLong(4, usuario.getCod_usuario());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro nas alterações dos dados /n "+ex.getMessage());
            ex.printStackTrace();
        }
        
        conex.desconecta();
        
    }
    
     public void Excluir(Usuario usuario){
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from usuarios where cod_usuario=?");
            pst.setLong(1, usuario.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados  excluidos com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar Excluir dados /n!!!"+ex);
            ex.printStackTrace();
        }
        
        conex.desconecta();
        
    }
        
    
    
    
}
