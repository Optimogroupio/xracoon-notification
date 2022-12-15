package io.optimogroup.xracoon.xracoonnotification.config;

import io.optimogroup.xracoon.xracoonnotification.proxy.SmsofficeProxy;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.Executors;

@Configuration
public class RetrofitConfiguration {

    private final String baseUrl;


    public RetrofitConfiguration(@Value("${smsoffice.api.base.url}") String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Bean
    public Retrofit retrofit() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
        return new Retrofit.Builder().client(okHttpClient)
                .callbackExecutor(Executors.newSingleThreadExecutor())
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    @Bean
    public SmsofficeProxy smsofficeProxy() {
        return retrofit().create(SmsofficeProxy.class);
    }
}
