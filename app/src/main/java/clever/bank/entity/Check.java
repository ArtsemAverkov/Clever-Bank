package clever.bank.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Check {
    private Long id;
    private String accountNumber;
}
