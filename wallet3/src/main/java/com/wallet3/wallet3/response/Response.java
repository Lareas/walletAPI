package com.wallet3.wallet3.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Response<T> {
    private T data;
    private List<String> errors;
}
