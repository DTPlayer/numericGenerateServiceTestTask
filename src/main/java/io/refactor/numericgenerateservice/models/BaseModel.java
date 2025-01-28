package io.refactor.numericgenerateservice.models;

import lombok.Data;

@Data
public class BaseModel {
    private String message;
    private Number status;

    public BaseModel(String message, Number status) {
        this.message = message;
        this.status = status;
    }

    public BaseModel() {
        this.message = "";
        this.status = 200;
    }
}
