package com.basic.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.ISBN;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class BookReqForm {

    private Long id;

    @NotEmpty(message = "Title은 필수 입력항목입니다.")
    private String title;

    @NotEmpty(message = "Isbn은 필수 입력항목입니다.")
    private String isbn;

    @NotEmpty(message = "Author은 필수 입력항목입니다.")
    private String author;


}