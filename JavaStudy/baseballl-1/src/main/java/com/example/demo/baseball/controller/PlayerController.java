package com.example.demo.baseball.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.baseball.domain.Player;
import com.example.demo.baseball.service.PlayerService;

@Controller
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public String index(Model model) {
        List<Player> players = playerService.findAll();
        model.addAttribute("players", players);
        return "players/index";
    }

    @GetMapping("new")
    public String newPlayer(Model model) {
        return "players/new";
    }

    @GetMapping("{id}/edit")
    public String edit (@PathVariable Long id, Model model) {
        Player player = playerService.findById(id);
        model.addAttribute("player",player);
        return "players/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        Player player = playerService.findById(id);
        model.addAttribute("player", player);
        return "players/show";
    }

    @PutMapping("{id}") 
    public String update(@PathVariable Long id, @ModelAttribute Player player) {
        player.setId(id);
        playerService.save(player);
        return "redirect:/players";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        playerService.delete(id);
        return "redirect:/players";
    }

    //new.htmlの「作成」ボタンをクリックしたときに実行される処理
    // http://localhost:8080/players/new/
    @PostMapping(path="/new")   
    public String getInfo(@ModelAttribute Player player) {
        playerService.insertSave(player);
        return "redirect:/players";
    }
}