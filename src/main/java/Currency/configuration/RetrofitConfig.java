package Currency.configuration;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Component
    public class RetrofitClient {
        public Retrofit getRetrofitClient() {
            OkHttpClient httpClient = new OkHttpClient();
            return new Retrofit.Builder()
                    .baseUrl("http://localhost:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();
        }
    }
}
