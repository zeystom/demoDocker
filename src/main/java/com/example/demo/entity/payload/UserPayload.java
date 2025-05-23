package com.example.demo.entity.payload;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.apache.logging.log4j.message.Message;

public record UserPayload(
        @NotNull(message = "qwewe")
        @Size(min = 2, max = 50, message = "{errors.create.name_null}")
        String name,
        @NotNull(message = "eMAIL ISNUll")
        @Size(min = 5, max = 100, message = "Email must be between 5 and 50 chars")
        String email,
        @NotNull(message = "Age is null")
        @Min(value = 18, message = "Age must be greater than 18")
        int age) {
}
