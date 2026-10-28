package org.capstone.sb_capstone.advices;

import org.capstone.sb_capstone.dtos.ErrorResponseDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionAdvices {

    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDto handleRunTimeException(RuntimeException e) {
        ErrorResponseDto errorDto = new ErrorResponseDto();
        errorDto.setMessage("Warning - RunTime Exception");
        errorDto.setStatus(e.getMessage());
        return errorDto;
    }
}
