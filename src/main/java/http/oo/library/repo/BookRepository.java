package http.oo.library.repo;

import http.oo.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query(value = "SELECT *" +
            "FROM books"
            ,nativeQuery = true)
    List<Book> findAllByBook();
}
