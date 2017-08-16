package model;

import java.sql.Date;

/**
 *
 * @author (name = Igor Hinckel, date= 2017-08-07)
 */
public class Carro {

    private int id, renavam;
    private byte qtdPortas, qtdBatidas;
    private short anoFabricacao, anoLancamento, tipoPneu;
    private String nome, cor, fabricante, placa, chassi, descricao;
    private float quilometragem, potencia;
    private Date dataCompra;
    private boolean estaFuncional, permitidaCirculacao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getQtdPortas() {
        return qtdPortas;
    }

    public void setQtdPortas(byte qtdPortas) {
        this.qtdPortas = qtdPortas;
    }

    public byte getQtdBatidas() {
        return qtdBatidas;
    }

    public void setQtdBatidas(byte qtdBatidas) {
        this.qtdBatidas = qtdBatidas;
    }

    public short getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(short anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public short getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(short anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public short getTipoPneu() {
        return tipoPneu;
    }

    public void setTipoPneu(short tipoPneu) {
        this.tipoPneu = tipoPneu;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getRenavam() {
        return renavam;
    }

    public void setRenavam(int renavam) {
        this.renavam = renavam;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public float getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(float quilometragem) {
        this.quilometragem = quilometragem;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public boolean isEstaFuncional() {
        return estaFuncional;
    }

    public void setEstaFuncional(boolean estaFuncional) {
        this.estaFuncional = estaFuncional;
    }

    public boolean isPermitidaCirculacao() {
        return permitidaCirculacao;
    }

    public void setPermitidaCirculacao(boolean permitidaCirculacao) {
        this.permitidaCirculacao = permitidaCirculacao;
    }

    @Override
    public String toString() {
        return "Carro{" + "id=" + id + ", renavam=" + renavam + ", qtdPortas=" + qtdPortas + ", qtdBatidas=" + qtdBatidas + ", anoFabricacao=" + anoFabricacao + ", anoLancamento=" + anoLancamento + ", tipoPneu=" + tipoPneu + ", nome=" + nome + ", cor=" + cor + ", fabricante=" + fabricante + ", placa=" + placa + ", chassi=" + chassi + ", descricao=" + descricao + ", quilometragem=" + quilometragem + ", potencia=" + potencia + ", dataCompra=" + dataCompra + ", estaFuncional=" + estaFuncional + ", permitidaCirculacao=" + permitidaCirculacao + '}';
    }

}
