package clever.bank.entity;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private Long id;
    private String name;
    private String lastName;
    private String email;
}
