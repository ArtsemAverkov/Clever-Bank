package clever.bank.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Transaction {
    private Long id;
    private String type;
}
