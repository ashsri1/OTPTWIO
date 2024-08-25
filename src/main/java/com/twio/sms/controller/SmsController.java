package com.twio.sms.controller;


import com.twio.sms.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {
    @Autowired
    private TwilioService twilioService;

    @PostMapping("/sendOtp")
    public String sendOtp(@RequestParam String mobileNumber) {
        return twilioService.sendOtptoPhone(mobileNumber);
    }

    @PostMapping("/verifyOtp")
    public String verifyOtp(@RequestParam String otp) {
        return twilioService.validatedOtp(otp);
    }

}