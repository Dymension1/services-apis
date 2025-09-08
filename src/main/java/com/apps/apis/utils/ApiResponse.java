package com.apps.apis.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private String message;
    private Integer status;
    private T data;

    public ApiResponse(T data, String name) {
        this.message = name;
        this.status = HttpStatus.OK.value();
        this.data = data;
    }
}
