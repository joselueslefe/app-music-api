package com.joselueslefe.appmusic.Controller;

import com.joselueslefe.appmusic.model.Music;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/musicas") // Rota base: localhost:8080/musicas
public class Controller {

    private List<Music> musicList = new ArrayList<>();

    public Controller() {
        musicList.add(new Music(1L, "My Hair", "Ariana Grande"));
        musicList.add(new Music(2L, "God is a Woman", "Ariana Grande"));
        musicList.add(new Music(3L, "I Don't Wanna Break Up Again", "Ariana Grande"));
    }

    @GetMapping
    public List<Music> getMusicList() {
        return musicList;
    }

    @GetMapping("/{id}")
    public Music buscarPorId(@PathVariable long id) {
        return musicList.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public String adicionar(@RequestBody Music novaMusic) {
        musicList.add(novaMusic);
        return "Música adicionada com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String remover(@PathVariable Long id) {
        boolean remover = musicList.removeIf(m -> m.getId() == id);
        if (remover) {
            return "Música removida com sucesso!";
        } else {
            return "Música não encontrada.";
        }
    }
}
