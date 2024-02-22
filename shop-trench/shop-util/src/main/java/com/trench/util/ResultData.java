package com.trench.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultData {

    private Integer code;

    private Object message;

    @Override
    public String toString() {
        return "ResultData{" +
                "code=" + code +
                ", message=" + message +
                '}';
    }
}
