package dev.araz.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Order {
    @Id
    private Long id;
    private Long userId;
    private Long bookId;
    private LocalDate orderDate;
}
