package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void dataInitializer(){

        Author thabo = new Author("Thabo", "Bas thiza");
        Book book1 = new Book("Cooking book","113311","Danny-Boy");
        thabo.getBooks().add(book1);
        book1.getAuthors().add(thabo);

        authorRepository.save(thabo);
        bookRepository.save(book1);

        Author mike = new Author("Michael", "shim star");
        Book book2 = new Book("Cooking book vol 2","4422587","west - pub");
        mike.getBooks().add(book2);
        book2.getAuthors().add(mike);

        authorRepository.save(mike);
        bookRepository.save(book2);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        dataInitializer();
    }
}
