package com.nadarzy.betterReadsApp.home;

import com.nadarzy.betterReadsApp.book.BookController;
import com.nadarzy.betterReadsApp.user.BooksByUser;
import com.nadarzy.betterReadsApp.user.BooksByUserRepository;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

/** @author Julian Nadarzy on 25/11/2021 */
@Controller
public class HomeController {

  private final BooksByUserRepository booksByUserRepository;

  public HomeController(BooksByUserRepository booksByUserRepository) {
    this.booksByUserRepository = booksByUserRepository;
  }

  @GetMapping("/")
  public String home(@AuthenticationPrincipal OAuth2User principal, Model model) {
    if (principal == null || principal.getAttribute("login") == null) {
      return "index";
    }
    String user = principal.getAttribute("login");
    Slice<BooksByUser> bookSlice =
        booksByUserRepository.findAllById(user, CassandraPageRequest.of(0, 100));

    List<BooksByUser> booksByUser = bookSlice.getContent();
    booksByUser =
        booksByUser.stream()
            .distinct()
            .map(
                book -> {
                  String coverImage = "/images/no-image.png";
                  if (book.getCoverIds() != null && book.getCoverIds().size() > 0) {
                    coverImage =
                        BookController.COVER_IMAGE_ROOT + book.getCoverIds().get(0) + "-M.jpg";
                  }
                  book.setCoverUrl(coverImage);
                  return book;
                })
            .collect(Collectors.toList());
    model.addAttribute("books", booksByUser);
    return "home";
  }
}
