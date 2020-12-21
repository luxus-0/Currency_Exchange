package Currency.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:application-development.properties"),
        @PropertySource("classpath:application-production.properties")
})
public class ConfigDatabase {
}
