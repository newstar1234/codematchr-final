package com.project.codematchr.dto.request.board;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchBoardRequestDto {
    
    @NotBlank
    private String boardTitle;

    @NotBlank
    private String boardContents;
    
    private String boardImageUrl;
}
