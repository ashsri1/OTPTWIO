package com.twio.sms.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="twilio")
@Data
@NoArgsConstructor
public class OtpTwilioConfig {

    private  String accountSid;
    private  String authToken;
    private  String phoneNumber;

    @Override
    public String toString() {
        return "OtpTWilioConfig{" +
                "accountSid='" + accountSid + '\'' +
                ", authToken='" + authToken + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}