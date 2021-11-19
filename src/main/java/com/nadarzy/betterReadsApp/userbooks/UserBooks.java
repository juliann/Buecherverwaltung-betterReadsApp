package com.nadarzy.betterReadsApp.userbooks;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;

import static org.springframework.data.cassandra.core.mapping.CassandraType.Name;

/** @author Julian Nadarzy on 19/11/2021 */
@Table(value = "book_by_user_and_bookid")
public class UserBooks {

  @PrimaryKey private UserBooksPrimaryKey userBooksPrimaryKey;

  @Column("reading_status")
  @CassandraType(type = Name.TEXT)
  private String readingStatus;

  @Column("book_review")
  @CassandraType(type = Name.TEXT)
  private String bookReview;

  @Column("started_date")
  @CassandraType(type = Name.DATE)
  private LocalDate startedDate;

  @Column("completed_date")
  @CassandraType(type = Name.DATE)
  private LocalDate completedDate;

  @Column("rating")
  @CassandraType(type = Name.INT)
  private int rating;

  public UserBooksPrimaryKey getUserBooksPrimaryKey() {
    return userBooksPrimaryKey;
  }

  public void setUserBooksPrimaryKey(UserBooksPrimaryKey userBooksPrimaryKey) {
    this.userBooksPrimaryKey = userBooksPrimaryKey;
  }

  public String getReadingStatus() {
    return readingStatus;
  }

  public void setReadingStatus(String readingStatus) {
    this.readingStatus = readingStatus;
  }

  public String getBookReview() {
    return bookReview;
  }

  public void setBookReview(String bookReview) {
    this.bookReview = bookReview;
  }

  public LocalDate getStartedDate() {
    return startedDate;
  }

  public void setStartedDate(LocalDate startedDate) {
    this.startedDate = startedDate;
  }

  public LocalDate getCompletedDate() {
    return completedDate;
  }

  public void setCompletedDate(LocalDate completedDate) {
    this.completedDate = completedDate;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }
}
