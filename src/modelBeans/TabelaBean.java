
package modelBeans;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class TabelaBean extends AbstractTableModel{

    /**
     * @return the linhas
     */
    public ArrayList getLinhas() {
        return linhas;
    }

    /**
     * @param linhas the linhas to set
     */
    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    /**
     * @return the colunas
     */
    public String[] getColunas() {
        return colunas;
    }

    /**
     * @param colunas the colunas to set
     */
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
    private ArrayList linhas=null;
    
    private String[] colunas = null;
    
    
    
    public TabelaBean(ArrayList lin, String[] col){
        setLinhas(lin);
        setColunas(col);
    }
    
    //Conta a quantidade de colunas no banco
    public int getColumnCount(){
        return colunas.length; //Conta a quantidade de colunas esse comando length
    }
    
    // Conta quantas linhas no banco
    public int getRowCount(){
        return linhas.size(); // Conta quantas linhas existem no meu array
    }
    
    //Metodo responsavel por pegar o valor do nome da coluna e retorna o numero de colunas
    public String getColumnName(int numCol){
        return colunas[numCol];
    }
    //Metodo Responsavel por Montar nossa tabela, vai montar as linhas da tabela
    public Object getValueAt(int numLin, int numCol){
         Object[] linha = (Object[])getLinhas().get(numLin);
         return linha[numCol];
    }
}
