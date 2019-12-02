
package model;

public class Social{
    private String nome;
    private String link;
    private String imgSrc;
    
    public Social(String nome, String link, String imgSrc){
        this.nome = nome;
        this.link = link;
        this.imgSrc = imgSrc;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLink() {
        return this.link;
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
