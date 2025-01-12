package com.padwan.test.entity;

import javax.persistence.*;

@Entity
@Table(name = "jedi")
public class Jedi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String status; // padawan, jedi, mestre jedi

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Jedi mentor;

    @Column(nullable = false)
    private Integer midichlorians;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Jedi getMentor() {
        return mentor;
    }

    public void setMentor(Jedi mentor) {
        this.mentor = mentor;
    }

    public Integer getMidichlorians() {
        return midichlorians;
    }

    public void setMidichlorians(Integer midichlorians) {
        this.midichlorians = midichlorians;
    }
}