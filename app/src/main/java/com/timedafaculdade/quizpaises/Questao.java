package com.timedafaculdade.quizpaises;

public class Questao {
    private String primeiraAlternativa;
    private String segundaAlternativa;
    private String terceiraAlternativa;
    private String quartaAlternativa;
    private Integer bandeira;
    private Integer correta;

    public Questao(String primeiraAlternativa, String segundaAlternativa, String terceiraAlternativa, String quartaAlternativa, Integer bandeira, Integer correta) {
        this.primeiraAlternativa = primeiraAlternativa;
        this.segundaAlternativa = segundaAlternativa;
        this.terceiraAlternativa = terceiraAlternativa;
        this.quartaAlternativa = quartaAlternativa;
        this.bandeira = bandeira;
        this.correta = correta;
    }

    public String getPrimeiraAlternativa() {
        return primeiraAlternativa;
    }

    public void setPrimeiraAlternativa(String primeiraAlternativa) {
        this.primeiraAlternativa = primeiraAlternativa;
    }

    public String getSegundaAlternativa() {
        return segundaAlternativa;
    }

    public void setSegundaAlternativa(String segundaAlternativa) {
        this.segundaAlternativa = segundaAlternativa;
    }

    public String getTerceiraAlternativa() {
        return terceiraAlternativa;
    }

    public void setTerceiraAlternativa(String terceiraAlternativa) {
        this.terceiraAlternativa = terceiraAlternativa;
    }

    public String getQuartaAlternativa() {
        return quartaAlternativa;
    }

    public void setQuartaAlternativa(String quartaAlternativa) {
        this.quartaAlternativa = quartaAlternativa;
    }

    public Integer getBandeira() {
        return bandeira;
    }

    public void setBandeira(Integer bandeira) {
        this.bandeira = bandeira;
    }

    public Integer getCorreta() {
        return correta;
    }

    public void setCorreta(Integer correta) {
        this.correta = correta;
    }

    @Override
    public String toString() {
        return "Questao{" +
                "primeiraAlternativa='" + primeiraAlternativa + '\'' +
                ", segundaAlternativa='" + segundaAlternativa + '\'' +
                ", terceiraAlternativa='" + terceiraAlternativa + '\'' +
                ", quartaAlternativa='" + quartaAlternativa + '\'' +
                ", bandeira=" + bandeira +
                ", correta=" + correta +
                '}';
    }
}
