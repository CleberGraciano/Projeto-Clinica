/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelBeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity (name = "medicos")
public class MedicoBean extends GenericDomain {

    private Integer cod_medico;

    @Column(length = 50, nullable = false, name = "nome_medico")
    private String nome;

    @Column(length = 50, nullable = false, name = "especializacao_medico")
    private String especialidade;
    
    @Column(length = 20, nullable = false, name = "crm_medico")
    private Integer crm;
    
   
    private String pesquisa;
    
    
    
    /**
     * @return the pesquisa
     */
    public String getPesquisa() {
        return pesquisa;
    }

    /**
     * @param pesquisa the pesquisa to set
     */
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the especialidade
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    /**
     * @return the crm
     */
    public int getCrm() {
        return crm;
    }

    /**
     * @param crm the crm to set
     */
    public void setCrm(int crm) {
        this.crm = crm;
    }

    /**
     * @return the cod_medico
     */
    public Integer getCod_medico() {
        return cod_medico;
    }

    /**
     * @param cod_medico the cod_medico to set
     */
    public void setCod_medico(Integer cod_medico) {
        this.cod_medico = cod_medico;
    }
    
   
    
}
