package com.twio.sms.service;



import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twio.sms.config.OtpTwilioConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class TwilioService {
    @Autowired
    private OtpTwilioConfig otpTWilioConfig;
    Map<String, String> otpMap = new HashMap<String, String>();

    public String generatedOtp() {
        int otp = (int) (Math.random() * 100000);
        return String.format("%06d", otp);
    }

    public String sendOtptoPhone(String mobileNumber) {
        String otp = generatedOtp();
        PhoneNumber reciepientPhoneNumber = new PhoneNumber(mobileNumber);
        PhoneNumber senderPhoneNumber = new PhoneNumber(otpTWilioConfig.getPhoneNumber());
        String msgbody = "Your OTP is :" + otp;
        Message message = Message.creator(reciepientPhoneNumber, senderPhoneNumber, msgbody).create();
        otpMap.put(msgbody, otp);
        return "OTP sent successfully";
    }

    public String validatedOtp(String otp) {
        Set<String> keys = otpMap.keySet();
        String value = null;
        for (String key : keys)
            value = otpMap.get(key);
        if (value.equals(otp))
            return "OTP validated successfully";
        else
            return "Invalid OTP";
    }
}



