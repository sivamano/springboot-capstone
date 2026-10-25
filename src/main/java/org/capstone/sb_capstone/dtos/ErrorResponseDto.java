package org.capstone.sb_capstone.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto {
    private String status;
    private String message;
}
