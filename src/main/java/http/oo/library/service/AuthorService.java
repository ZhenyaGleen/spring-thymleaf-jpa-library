package http.oo.library.service;

import http.oo.library.model.Author;
import http.oo.library.repo.AuthorRepository;
import org.slf4j.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Slf4j
public class AuthorService {


    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Transactional
    public List<Author> findAllAuthors() {
        log.info("You are got all authors");
        return authorRepository.findAll();

    }

    @Transactional
    public Author findAuthorById(int id) {

        log.info("You are got author with id: " + id);
        return authorRepository.findAuthorById(id);
    }

    @Transactional
    public Author createAuthor(Author author) {
        log.info("You are created author");
        return authorRepository.save(author);
    }

    @Transactional
    public void updateAuthor(int id,Author author){
        Author upAuthor = authorRepository.findAuthorById(id);
        if (upAuthor != null){
            authorRepository.save(upAuthor);
        }
    }

    @Transactional
    public void deleteAuthorById(int id){
        log.info("You are deleted author with id: " + id);
        authorRepository.deleteById(id);
    }
}
