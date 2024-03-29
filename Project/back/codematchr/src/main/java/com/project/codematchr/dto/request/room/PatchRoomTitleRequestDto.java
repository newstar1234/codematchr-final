package com.project.codematchr.dto.request.room;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchRoomTitleRequestDto {

    @NotBlank
    private String roomTitle;

}
