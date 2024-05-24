package org.board.boardproject.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    private Long id;

    @Setter
    private String name;

    @Setter
    private String title;

    private String password;

    @Setter
    private String content;

    private LocalDateTime createdAt;

    @Setter
    private LocalDateTime updatedAt;

}

