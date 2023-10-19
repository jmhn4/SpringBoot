package com.basic.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookReqDTO {

    @NotEmpty(message = "Title은 필수 입력항목입니다.")
    private String title;

    @NotEmpty(message = "Isbn은 필수 입력항목입니다.")
    private String isbn;

    @NotEmpty(message = "Author은 필수 입력항목입니다.")
    private String author;

}
