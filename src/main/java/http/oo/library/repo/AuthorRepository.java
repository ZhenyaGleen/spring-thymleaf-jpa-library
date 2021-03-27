package http.oo.library.repo;

import http.oo.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

//    @Query(value = "SELECT author_id,first_name,last_name,book_name" +
//            " FROM authors as a" +
//            " INNER JOIN books as b" +
//            " ON a.id = b.author_id" +
//            " WHERE b.author_id = :author"
//            ,nativeQuery = true)
//    List<Author> findAuthorByName(@Param("author") int author);


    Author findAuthorById(int id);

    @Query(value = "SELECT * FROM authors",nativeQuery = true)
    List<Author> getAuthorByLastName();

}
