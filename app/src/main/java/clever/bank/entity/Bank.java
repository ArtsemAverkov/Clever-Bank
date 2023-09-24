package clever.bank.entity;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Bank {
    private Long id;
    String name;
}
