/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author amine
 */
public class Evaluation {
    protected int id_exp;
    protected int id_critere;
    protected int note;

    public Evaluation(int id_exp, int id_critere, int note) {
        this.id_exp = id_exp;
        this.id_critere = id_critere;
        this.note = note;
    }

    public Evaluation() {
    }

    public int getId_exp() {
        return id_exp;
    }

    public void setId_exp(int id_exp) {
        this.id_exp = id_exp;
    }

    public int getId_critere() {
        return id_critere;
    }

    public void setId_critere(int id_critere) {
        this.id_critere = id_critere;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "evaluation{" + "id_exp=" + id_exp + ", id_critere=" + id_critere + ", note=" + note + '}';
    }
    
}
