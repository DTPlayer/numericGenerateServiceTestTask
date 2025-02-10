package io.refactor.numericgenerateservice;

import io.refactor.numericgenerateservice.utils.CodeGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("local")
@SpringBootTest
class NumericGenerateServiceApplicationTests {

    @Autowired
    private CodeGenerator codeGenerator;

    @Test
    void generateNumber() {
        Optional<Number> code = codeGenerator.generateNumber();

        assertTrue(code.isPresent());
    }

}
