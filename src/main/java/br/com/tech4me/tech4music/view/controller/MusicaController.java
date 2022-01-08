package br.com.tech4me.tech4music.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4music.service.MusicaService;
import br.com.tech4me.tech4music.shared.MusicaDto;

@RestController
@RequestMapping("/api/tech4music")

public class MusicaController {
    @Autowired
    private MusicaService servico;

    @GetMapping
    public ResponseEntity<List<MusicaDto>> obterMusica() {
        List<MusicaDto> musicasDto = servico.obterMusica();

        List<MusicaDto> musicaList = musicasDto.stream()
        .map(c -> new ModelMapper().map(c, MusicaDto.class))
          .collect(Collectors.toList());

        return new ResponseEntity<>(musicaList, HttpStatus.FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MusicaDto> encontrarMusica(@PathVariable String id) {
        Optional<MusicaDto> musica = servico.encontrarMusica(id);

        if(musica.isPresent()){
            MusicaDto musicaPlay = new ModelMapper().map(musica.get(), MusicaDto.class);
        return new ResponseEntity<>(musicaPlay, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<MusicaDto> cadrastarMusica(@RequestBody @Valid MusicaDto musica) {
        MusicaDto musicaCadrasto = new ModelMapper().map(musica, MusicaDto.class);
        musicaCadrasto = servico.cadrastarMusica(musicaCadrasto);
        MusicaDto musicaResposta = new ModelMapper().map(musicaCadrasto, MusicaDto.class);
        return new ResponseEntity<>(musicaResposta, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarMusica(@PathVariable String id) {
        servico.deletarMusica(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MusicaDto> atualizarMusica(@PathVariable @Valid String id, @RequestBody MusicaDto novaMusica) {
        Optional<MusicaDto> musica = servico.encontrarMusica(id);
        if(musica.isPresent()){

        return new ResponseEntity<>(servico.atualizarLista(id, novaMusica), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    
}
