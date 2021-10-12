package com.lovotech.fr.gxld.core.bean.cra.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
public class ExceptionResponse {

    private String errorMessage;
    private String errorCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

}