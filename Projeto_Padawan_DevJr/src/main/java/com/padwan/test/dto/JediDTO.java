package com.padwan.test.dto;

import com.padwan.test.entity.Jedi;

public class JediDTO {
    private Long id;
    private String nome;
    private String status;
    private Integer midichlorians;
    private String mentorNome;

    public JediDTO(Jedi jedi) {
        this.id = jedi.getId();
        this.nome = jedi.getNome();
        this.status = jedi.getStatus();
        this.midichlorians = jedi.getMidichlorians();
        this.mentorNome = (jedi.getMentor() != null) ? jedi.getMentor().getNome() : null;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Integer getMidichlorians() { return midichlorians; }
    public void setMidichlorians(Integer midichlorians) { this.midichlorians = midichlorians; }
    public String getMentorNome() { return mentorNome; }
    public void setMentorNome(String mentorNome) { this.mentorNome = mentorNome; }
}
