package Currency.configuration;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
@PropertySources({
        @PropertySource("classpath:application-development.properties"),
        @PropertySource("classpath:application-production.properties")
})
public class DatabaseConfig {



}
