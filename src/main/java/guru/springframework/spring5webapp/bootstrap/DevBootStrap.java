package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void dataInitializer(){


        Publisher publisher = new Publisher("Danny-Boy","Midrand");
        publisherRepository.save(publisher);

        Author thabo = new Author("Thabo", "Bas thiza");
        Book book1 = new Book("Cooking book","113311",publisher);
        thabo.getBooks().add(book1);
        book1.getAuthors().add(thabo);

        authorRepository.save(thabo);
        bookRepository.save(book1);

        Author mike = new Author("Michael", "shim star");
        Book book2 = new Book("Cooking book vol 2","4422587",publisher);
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
