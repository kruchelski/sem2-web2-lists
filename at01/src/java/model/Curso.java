package model;

public class Curso {
    private String nome, link, imgSrc;
    
    public Curso(String nome, String link, String imgSrc) {
        this.nome = nome;
        this.link = link;
        this.imgSrc = imgSrc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
    
    
}
