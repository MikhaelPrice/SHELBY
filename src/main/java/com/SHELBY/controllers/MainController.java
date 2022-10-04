package com.SHELBY.controllers;

import com.SHELBY.domain.Message;
import com.SHELBY.domain.User;
import com.SHELBY.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Message> messages = messageRepo.findAll();
        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByDate(filter);
        } else {
            messages = messageRepo.findAll();
        }
        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String date,
            @RequestParam String url,
            Model model) {
        Message message = new Message(text, date, url, user);
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);
        return "main";
    }

    @GetMapping("/main/{id}/messageEdit")
    public String edit(@PathVariable("id") Long id, Model model) {
        if (!messageRepo.existsById(id)) {
            return "redirect:/main";
        }
        if (messageRepo.findById(id).isPresent()) {
            model.addAttribute("text", messageRepo.findById(id).get().getText());
            model.addAttribute("date", messageRepo.findById(id).get().getDate());
            model.addAttribute("url", messageRepo.findById(id).get().getUrl());
        }
        return "messageEdit";
    }

    @PostMapping("/main/{id}/messageEdit")
    public String update(@PathVariable("id") Long id,
                         @RequestParam String text,
                         @RequestParam String date,
                         @RequestParam String url
    ) {
        Message message = messageRepo.findById(id).orElseThrow();
        message.setDate(date);
        message.setText(text);
        message.setUrl(url);
        messageRepo.save(message);
        return "redirect:/main";
    }

    @GetMapping("/main/{id}")
    public String delete(@PathVariable("id") Long id) {
        messageRepo.delete(messageRepo.findById(id).orElseThrow());
        return "redirect:/main";
    }

}
