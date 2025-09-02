package school.sptech;

import org.apache.commons.lang3.stream.Streams;

public class Gincana {
    private String nome;
    private Double premio;
    private Integer qtdInscrito;
    private Boolean ativa;

    public Gincana (String nome, Double premio){
        this.nome = nome;
        this.premio = premio;
        this.qtdInscrito = 0;
        this.ativa = true;
    }
    public void inscrever (Integer qtd){
        if (qtd != null && qtd > 0 && this.ativa){
            this.qtdInscrito += qtd;
        }
    }

    public Integer remover (Integer qtd){
        if (qtd != null && qtd > 0 && qtd<this.qtdInscrito && this.ativa){
            this.qtdInscrito -= qtd;
            return qtd;
        }
        return null;
    }

    public Integer desativar(){
        if (!this.ativa){
            return null;
        }
        this.ativa = false;
        int temp = this.qtdInscrito;
        this.qtdInscrito = 0;
        return temp;
    }

    public void transferir(Gincana destino, Integer qtdATransferir){
        if(destino != null && qtdATransferir != null && qtdATransferir > 0 && this.qtdInscrito >= qtdATransferir && this.ativa && destino.ativa){
            this.qtdInscrito -= qtdATransferir;
            destino.qtdInscrito += qtdATransferir;
        }
    }

    public Boolean reajustarPremio (Double reajuste){
        if (reajuste != null && reajuste > 0){
            this.premio += this.premio*reajuste;
            return true;
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public Double getPremio() {
        return premio;
    }

    public Integer getQtdInscrito() {
        return qtdInscrito;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
