package io.refactor.numericgenerateservice;

import io.refactor.numericgenerateservice.models.ResponseModel;

import io.refactor.numericgenerateservice.utils.CodeGenerator;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/numbers")
public class ApiRouters {

    private final CodeGenerator codeGenerator;

    public ApiRouters(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

    @GetMapping("/generate")
    public ResponseModel generator(HttpServletResponse response) {

        Optional<Number> code = codeGenerator.generateNumber();

        if (code.isEmpty()) {
            response.setStatus(400);
            return new ResponseModel("Generate code is unsuccessful", 400, 0);
        }

        return new ResponseModel(code.get());
    }
}
