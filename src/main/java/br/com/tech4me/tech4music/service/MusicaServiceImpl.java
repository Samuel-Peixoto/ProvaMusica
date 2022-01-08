package br.com.tech4me.tech4music.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4music.model.Musica;
import br.com.tech4me.tech4music.repository.MusicaRepository;
import br.com.tech4me.tech4music.shared.MusicaDto;

@Service
public class MusicaServiceImpl implements MusicaService{
    @Autowired
    private MusicaRepository repo;

    @Override
    public List<MusicaDto> obterMusica() {
        List<Musica> musicas = repo.findAll();
        return musicas.stream()
        .map(c -> new ModelMapper().map(c, MusicaDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public MusicaDto cadrastarMusica(MusicaDto musica) {
        Musica musicaCadrastar = new ModelMapper().map(musica, Musica.class);
        musicaCadrastar = repo.save(musicaCadrastar);
        return new ModelMapper().map(musicaCadrastar, MusicaDto.class);
    }

    @Override
    public Optional<MusicaDto> encontrarMusica(String id) {
        Optional<Musica> musicaAchar = repo.findById(id);
        return Optional.of(new ModelMapper().map(musicaAchar.get(), MusicaDto.class));
    }
    @Override
    public void deletarMusica(String id) {
        repo.deleteById(id);

    }

    @Override
    public MusicaDto atualizarLista(String id, MusicaDto novaMusica) {
        Musica cancao = new ModelMapper().map(novaMusica, Musica.class);
        cancao.setId(id);
        cancao = repo.save(cancao);
        return new ModelMapper().map(cancao, MusicaDto.class);
    }
}
