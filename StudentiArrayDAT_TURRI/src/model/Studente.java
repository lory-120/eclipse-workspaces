package model;
import java.io.*;

/**
 * @Author stagnitta
 * @Name gestisce gli studenti
 * "Classe Studente con....
 *
 */
public class Studente implements Serializable {
    private String cognome;
    private String nome;
    private String cf;
    private String email;
    private int eta;

    public Studente(String cf, String cognome, String nome, String email, int eta) {
        this.cognome = cognome;
        this.nome = nome;
        this.email = email;
        this.cf = cf;
        this.eta = eta;
    }

    public Studente() {
        this.cognome = "";
        this.nome = "";
        this.email = "";
        this.cf = "";
        eta=0;
    }

    public Studente(Studente s) {
        cognome = s.cognome;
        nome = s.nome;
        email = s.email;
        cf = s.cf;
        eta = s.eta;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCf() {
        return cf;
    }
    public void setCf(String cf) {
        this.cf = cf;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "cognome= " + cognome + '\'' +
                ", nome= " + nome + '\'' +
                ", email= " + email + '\'' +
                ", cf= " + cf + '\'' +
                ", eta= " + eta + '\'' +
                '}';
    }

    /**
     *
     * @param s passo un oggetto studente e dico se gli oggetti sono uguali
     * @return
     */
    public int compareTo(Studente s){
        return this.cf.compareTo(s.cf);
    }

    /**
     *
     * @param s1 oggetto1
     * @param s2 oggetto2
     * @return true se sono uguali
     */
    public boolean equals(Studente s1, Studente s2){
        return s1.eta==s2.eta;
    }
}