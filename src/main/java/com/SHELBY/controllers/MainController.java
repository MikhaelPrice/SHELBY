package com.SHELBY.controllers;

import com.SHELBY.domain.Message;
import com.SHELBY.domain.User;
import com.SHELBY.repos.MessageRepo;
import com.SHELBY.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private MessageRepo messageRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Message> messages = messageRepo.findAll();
        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
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
            @RequestParam String tag,
            @RequestParam("file") MultipartFile file,
            Model model) throws IOException {
        Message message = new Message(text, tag, user);
        FileService fileService = new FileService();
        message.setFilename(fileService.uploadFile(file, uploadPath));
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
            model.addAttribute("tag", messageRepo.findById(id).get().getTag());
        }
        return "messageEdit";
    }

    @PostMapping("/main/{id}/messageEdit")
    public String update(@PathVariable("id") Long id,
                         @RequestParam String text,
                         @RequestParam String tag
    ) {
        Message message = messageRepo.findById(id).orElseThrow();
        message.setTag(tag);
        message.setText(text);
        if (messageRepo.findById(id).isPresent()) {
            message.setAuthor(messageRepo.findById(id).get().getAuthor());
        }
        messageRepo.save(message);
        return "redirect:/main";
    }

    @PostMapping("/main/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        Message message = messageRepo.findById(id).orElseThrow();
        messageRepo.delete(message);
        return "redirect:/main";
    }

}
