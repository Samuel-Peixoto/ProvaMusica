package br.com.tech4me.tech4music.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4music.shared.MusicaDto;

public interface MusicaService {
    List<MusicaDto> obterMusica();
    MusicaDto cadrastarMusica(MusicaDto musica);
    Optional<MusicaDto> encontrarMusica(String id);
    void deletarMusica(String id);
    MusicaDto atualizarLista(String id, MusicaDto novaMusica);

}