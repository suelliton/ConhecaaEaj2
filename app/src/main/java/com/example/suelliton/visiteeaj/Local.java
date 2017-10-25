package com.example.suelliton.visiteeaj;

import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.Table;

/**
 * Created by suelliton on 14/10/2017.
 */

public class Local extends SugarRecord{

    private String nome;
    private String descricao;
    private String responsavel;
    private String email;
    private String telefone;
    private String horario_funcionamento;
    private double latitude;
    private double longitude;



    public Local() {
    }

    public Local(String nome, String descricao, String responsavel, String email, String telefone, String horario_funcionamento, double latitude, double longitude) {
        this.nome = nome;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.email = email;
        this.telefone = telefone;
        this.horario_funcionamento = horario_funcionamento;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getHorario_funcionamento() {
        return horario_funcionamento;
    }

    public void setHorario_funcionamento(String horario_funcionamento) {
        this.horario_funcionamento = horario_funcionamento;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Local{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", horario_funcionamento='" + horario_funcionamento + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
