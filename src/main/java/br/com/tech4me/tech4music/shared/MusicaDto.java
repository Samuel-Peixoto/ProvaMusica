package br.com.tech4me.tech4music.shared;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;


import org.springframework.data.annotation.Id;

public class MusicaDto {
    @Id
    private String id;
    @NotBlank(message = "Titulo não pode estar vazio")
    private String titulo;
    @NotBlank(message = "Artista não pode estar vazio")
    private String artista;
    @NotBlank(message = "Album não pode estar vazio")
    private String album;
    @NotBlank(message = "Genero não pode estar vazio")
    private String genero;
    @Positive(message = "O Ano Lançamento é obrigatório")
    private Integer anoLancamento;
    @NotBlank(message = "Compositor não pode estar vazio")
    private String compositor;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public Integer getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public String getCompositor() {
        return compositor;
    }
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

}
