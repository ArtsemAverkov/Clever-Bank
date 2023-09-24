package clever.bank.connect;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AppConfig {
    DatabaseConfig databaseConfig;
}
