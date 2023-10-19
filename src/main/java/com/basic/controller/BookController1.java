package com.basic.controller;

import com.basic.entity.Book;
import com.basic.exception.BusinessException;
import com.basic.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController1 {

        @Autowired
        private BookRepository bookRepository;

        @PostMapping
        public Book create(@RequestBody Book book) {
            return bookRepository.save(book);
        }

        @GetMapping
        public List<Book> getBooks() {
                System.out.println("Test");
                return bookRepository.findAll();
        }

        @GetMapping("/{id}")
        public Book getBook(@PathVariable Long id) {
            Optional<Book> optionalBook = bookRepository.findById(id);

                Book book = optionalBook.orElseThrow(() ->new BusinessException("Book Not Found",
                    HttpStatus.NOT_FOUND));
                    return book;
        }

        @GetMapping("/isbn/{isbn}")
        public Book getBookByIsbn(@PathVariable String isbn) {
                return bookRepository.findByIsbn(isbn)
                        .orElseThrow(() -> new BusinessException("요청하신 isbn에 해당하는 책이 없습니다",
                                HttpStatus.NOT_FOUND));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteBook(@PathVariable Long id) {
                Book book = bookRepository.findById(id)
                        .orElseThrow(() -> new BusinessException("Book Not Found", HttpStatus.NOT_FOUND));

                bookRepository.delete(book);

                return ResponseEntity.ok(id + " Book이 삭제 되었습니다.");

        }

        @PutMapping("/{id}")
        public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetail) {
                Book book = bookRepository.findById(id)
                        .orElseThrow(() -> new BusinessException("Book Not Found", HttpStatus.NOT_FOUND));
                book.setTitle(bookDetail.getTitle());
                Book updatedCustomer = bookRepository.save(book);
                return updatedCustomer;
        }

}
