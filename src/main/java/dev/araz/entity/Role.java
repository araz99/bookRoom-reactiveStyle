package dev.araz.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Role {
    @Id
    private Long id;
    private String name;
}
