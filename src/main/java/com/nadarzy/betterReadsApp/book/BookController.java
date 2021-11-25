package com.nadarzy.betterReadsApp.book;

import com.nadarzy.betterReadsApp.userbooks.UserBooks;
import com.nadarzy.betterReadsApp.userbooks.UserBooksPrimaryKey;
import com.nadarzy.betterReadsApp.userbooks.UserBooksRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/** @author Julian Nadarzy on 22/10/2021 */
@Controller
public class BookController {
  public static final String COVER_IMAGE_ROOT = "http://covers.openlibrary.org/b/id/";

  private final BookRepository bookRepository;
  private final UserBooksRepository userBooksRepository;

  public BookController(BookRepository bookRepository, UserBooksRepository userBooksRepository) {
    this.bookRepository = bookRepository;
    this.userBooksRepository = userBooksRepository;
  }

  @GetMapping("/books/{bookId}")
  public String getBook(
      @PathVariable String bookId, Model model, @AuthenticationPrincipal OAuth2User principal) {
    System.out.println("in getBook");
    Optional<Book> optionalBook = bookRepository.findById(bookId);
    if (optionalBook.isPresent()) {
      Book book = optionalBook.get();
      model.addAttribute(book);
      String coverImage = "/images/no-image.png";
      if (book.getCoverIds() != null && book.getCoverIds().size() > 0) {
        coverImage = COVER_IMAGE_ROOT + book.getCoverIds().get(0) + "-L.jpg";
      }
      model.addAttribute("coverImage", coverImage);
      if (principal != null && principal.getAttribute("login") != null) {
        String login = principal.getAttribute("login");
        model.addAttribute("loginId", login);
        UserBooksPrimaryKey key = new UserBooksPrimaryKey();
        key.setBookId(bookId);
        key.setUserId(login);
        Optional<UserBooks> userBooksOptional = userBooksRepository.findById(key);
        if (userBooksOptional.isPresent()) {
          model.addAttribute("userBooks", userBooksOptional.get());
        } else {
          model.addAttribute("userBooks", new UserBooks());
        }
      }
      return "book";

    } else {

      return "book-not-found";
    }
  }
}
