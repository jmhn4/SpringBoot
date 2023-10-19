package com.basic.controller;


import com.basic.dto.BookReqDTO;
import com.basic.dto.BookResDTO;
import com.basic.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController2 {
    private final BookService bookService;

    @PostMapping
    public BookResDTO saveBook(@RequestBody BookReqDTO bookReqDTO){
        return bookService.saveBook(bookReqDTO);
    }

    @GetMapping("/{id}")
    public BookResDTO getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/isbn/{isbn}")
    public BookResDTO getBookByIsbn(@PathVariable String isbn) {
        return bookService.getBookByIsbn(isbn);
    }

    @GetMapping
    public List<BookResDTO> getBooks() {
            return bookService.getBooks();
    }

    @PutMapping("/{id}")
    public BookResDTO updateBook(@PathVariable Long id, @RequestBody BookReqDTO bookReqDTO){
        return bookService.updateBook(id,bookReqDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok(id + " Book이 삭제처리 되었습니다.");
    }
}