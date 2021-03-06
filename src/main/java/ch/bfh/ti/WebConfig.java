package ch.bfh.ti;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.cbor.CBORFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Base64;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/web/static/**")
                .addResourceLocations("/web/static/");
    }

    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT");
    }

    @Bean
    public ObjectMapper getObjectMapper(){return new ObjectMapper();}
    @Bean
    public CBORFactory getCborFactory(){
        return new CBORFactory();
    }
    @Bean
    public Base64.Encoder getBase64UrlEncoder() {
        return Base64.getUrlEncoder().withoutPadding();
    }
    @Bean
    public Base64.Decoder getBase64UrlDecoder() {
        return Base64.getUrlDecoder();
    }
    @Bean
    public BouncyCastleProvider getBouncyCastleProvider(){return new BouncyCastleProvider();}
}
