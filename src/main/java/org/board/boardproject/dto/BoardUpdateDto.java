package org.board.boardproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class BoardUpdateDto {
    private Long id;

    @NotBlank(message = "content는 공백을 허용하지 않습니다.")
    @Size(min= 2, max = 20, message = "name은 2~20자 까지만 허용합니다.")
    private String name;

    @NotBlank(message = "content는 공백을 허용하지 않습니다.")
    @Size(min= 1, max = 50, message = "title은 1~50자 까지만 허용합니다.")
    private String title;

    @NotBlank(message = "content는 공백을 허용하지 않습니다.")
    @Size(min= 1, max = 1000, message = "content는 1~1000자 까지만 허용합니다.")
    private String content;

    @NotBlank(message = "password는 공백을 허용하지 않습니다.")
    @Size(min= 4, max = 30, message = "password는 4~30자 까지만 허용합니다.")
    private String password;
}
