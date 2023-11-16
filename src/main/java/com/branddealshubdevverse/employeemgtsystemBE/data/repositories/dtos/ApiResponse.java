package com.branddealshubdevverse.employeemgtsystemBE.data.repositories.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ApiResponse {
    private String message;
    private int statusCode;
    private boolean success;
    private Object data;
}
