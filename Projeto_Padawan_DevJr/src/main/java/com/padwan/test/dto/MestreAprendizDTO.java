package com.padwan.test.dto;

public class MestreAprendizDTO {
    private String mestre;
    private String aprendiz;

    public MestreAprendizDTO(String mestre, String aprendiz) {
        this.mestre = mestre;
        this.aprendiz = aprendiz;
    }

    public String getMestre() {
        return mestre;
    }

    public void setMestre(String mestre) {
        this.mestre = mestre;
    }

    public String getAprendiz() {
        return aprendiz;
    }

    public void setAprendiz(String aprendiz) {
        this.aprendiz = aprendiz;
    }
}
