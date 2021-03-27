package http.oo.library.controller;

import http.oo.library.model.Author;
import http.oo.library.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api/author")
public class AuthorController {

    public final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public ModelAndView findAll() {
        List<Author> authors = authorService.findAllAuthors();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("author-list");
        modelAndView.addObject("authors", authors);
        return modelAndView;
    }


    @GetMapping("/{id}")
    public ModelAndView findAuthorById(@PathVariable int id){
        Author author = authorService.findAuthorById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("author-one");
        modelAndView.addObject("author",author);
        return modelAndView;
    }


    @GetMapping("/author-create")
    public ModelAndView createAuthor(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("author-create");
        modelAndView.addObject("author", new Author());
        return modelAndView;
    }

    @PostMapping("/author-create")
    public String createAuthorPost(Author author){
        authorService.createAuthor(author);
        return "redirect:/api/author";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthorById(@PathVariable("id") int id){
        authorService.deleteAuthorById(id);
        return "redirect:/api/author";
    }

    
}
