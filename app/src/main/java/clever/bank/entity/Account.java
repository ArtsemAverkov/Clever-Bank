package clever.bank.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class Account {
    private Long id;
    private Long userId;
    private Long bankId;
    private BigDecimal balance;
}
