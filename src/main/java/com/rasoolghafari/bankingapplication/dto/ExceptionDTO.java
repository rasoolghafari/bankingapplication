package com.rasoolghafari.bankingapplication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class ExceptionDTO {

    @JsonIgnore
    HttpStatus httpStatus;
    private String message;
    private Integer status;

    public Integer getStatus() {
        if (this.getHttpStatus() != null) {
            return this.getHttpStatus().value();
        }
        return HttpStatus.INTERNAL_SERVER_ERROR.value();
    }
}
