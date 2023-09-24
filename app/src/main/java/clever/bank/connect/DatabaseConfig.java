package clever.bank.connect;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DatabaseConfig {
    private String url;
    private String username;
    private String password;
}
