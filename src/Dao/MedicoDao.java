/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelBeans.MedicoBean;


public class MedicoDao {
    
    ConexaoBD conex = new ConexaoBD();
    MedicoBean mod = new MedicoBean();
    
    public void Excluir(MedicoBean medicoBean){
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from medicos where cod_medico=?");
            pst.setLong(1, medicoBean.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados  excluidos com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar Excluir dados /n!!!"+ex);
            ex.printStackTrace();
        }
        
        conex.desconecta();
        
    }
    
    
    public void salvar(MedicoBean med){
        conex.conexao();
        
        try {
           
            PreparedStatement pst = conex.getCon().prepareStatement("insert into medicos (nome_medico, especializacao_medico,crm_medico) values (?, ?, ?)");
            pst.setString(1, med.getNome());
            pst.setString(2, med.getEspecialidade());
            pst.setInt(3, med.getCrm());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados inseridos com sucesso");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\n Erro: "+ex);
            ex.printStackTrace();
        }
        
        
        conex.desconecta();
    }
    
    public void Editar(MedicoBean medicoBean){
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("update medicos set nome_medico=?, especializacao_medico=?, crm_medico=? where cod_medico=? ");
            pst.setString(1, medicoBean.getNome());
            pst.setString(2, medicoBean.getEspecialidade());
            pst.setInt(3, medicoBean.getCrm());
            pst.setLong(4, medicoBean.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro nas alterações dos dados /n "+ex.getMessage());
            ex.printStackTrace();
        }
        
        conex.desconecta();
    }
    
    public MedicoBean buscaMedico(MedicoBean medico){
        conex.conexao();
        conex.executaSql("select * from medicos where nome_medico like'%"+medico.getPesquisa()+"%'");// realisando a consulta
        try {
            conex.rs.first();//Pega o primeiro resultado da pesquisa 
            medico.setCodigo(conex.rs.getLong("cod_medico"));//seta o campo codigo da tabela para o atributo código
            medico.setNome(conex.rs.getString("nome_medico"));//seta o campo Nome da tabela para o atributo Nome do banco
            medico.setEspecialidade(conex.rs.getString("especializacao_medico"));//seta o campo especialização da tabela para o atributo Nome especialidade do banco
            medico.setCrm(conex.rs.getInt("crm_medico"));//seta o ccm Nome da tabela para o atributo ccm do banco
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Médico não Cadastrado ");
        }
        
        conex.desconecta();
        return medico;
        
    }
    
}
