package io.refactor.numericgenerateservice.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResponseModel extends BaseModel {
    private Number code;

    public ResponseModel(String message, Number status, Number code) {
        super(message, status);
        this.code = code;
    }

    public ResponseModel(Number code) {
        super();
        this.code = code;
    }
}
