package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String citta;
    

    public Location() {

    }

    public Location(String nome, String citta) {
        super();
        this.nome = nome;
        this.citta = citta;
    }

    public Location(long id, String nome, String citta) {
        super();
        this.id = id;
        this.nome = nome;
        this.citta = citta;
    }

    @Override
    public String toString() {
        return "Location [id=" + id + ", nome=" + nome + ", citta=" + citta + "]";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public long getId() {
        return id;
    }
}
