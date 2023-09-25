package com.example.ex2.controller;

import com.example.ex2.dto.SongDto;
import com.example.ex2.model.Song;
import com.example.ex2.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("songs")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public ModelAndView showAll() {
        List<Song> songList = songService.findAll();
        ModelAndView modelAndView = new ModelAndView("list", "songList", songList);
        return modelAndView;
    }

    @GetMapping("create")
    public String showFormCreate(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("create")
    public String save(@Valid @ModelAttribute SongDto songDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.add(song);
        redirectAttributes.addFlashAttribute("message", "Created success!");
        return "redirect:/songs/create";
    }

    @GetMapping("update/{id}")
    public String showFormUpdate(Model model, @PathVariable int id) {
        SongDto songDto = new SongDto();
        Song song = songService.findById(id);
        BeanUtils.copyProperties(song, songDto);
        model.addAttribute("songDto", songDto);
        return "update";
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute SongDto songDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.update(song);
        redirectAttributes.addFlashAttribute("message", "Update success!");
        return "redirect:/songs/update/"+ song.getId();
    }

}
