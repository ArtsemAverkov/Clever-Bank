package clever.bank.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
public class Transaction {
    private Long id;
    private Long accountIdFrom;
    private Long accountIdTo;
    private BigDecimal amount;
    private LocalDateTime timestamp;
}
