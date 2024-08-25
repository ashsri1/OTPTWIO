package com.twio.sms;

import com.twilio.Twilio;
import com.twio.sms.config.OtpTwilioConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmsApplication {
	@Autowired
	private OtpTwilioConfig otpTWilioConfig;

	@PostConstruct
	public void setup(){
		Twilio.init(otpTWilioConfig.getAccountSid(),
				otpTWilioConfig.getAuthToken());
	}
	public static void main(String[] args) {
		SpringApplication.run(SmsApplication.class, args);
	}

}
