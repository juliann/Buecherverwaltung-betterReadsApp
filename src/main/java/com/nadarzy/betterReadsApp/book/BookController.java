package com.nadarzy.betterReadsApp.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author Julian Nadarzy on 22/10/2021
 */
@Controller
public class BookController {
    private final String COVER_IMAGE_ROOT = "http://covers.openlibrary.org/b/id/";

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books/{bookId}")
    public String getBook(@PathVariable String bookId, Model model){
        System.out.println("in getBook");
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            model.addAttribute(book);
            String coverImage="/images/no-image.png";
            if (book.getCoverIds()!=null && book.getCoverIds().size()>0){
                 coverImage = COVER_IMAGE_ROOT+ book.getCoverIds().get(0) +"-L.jpg";

                System.out.println(coverImage);
            }
            model.addAttribute("coverImage", coverImage);
            System.out.println(book.getName());
            return "bookDetails";
        } else{
            System.out.println("not found");
            return "book-not-found";
        }
    }
}
