package ducmin.otp.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import ducmin.otp.model.SmsOTP;
import ducmin.otp.model.StoreOTP;
import org.springframework.stereotype.Component;

@Component
public class SmsService {
    private final String ACCOUNT_SID ="AC439cba1e09c7ff4c7a3a2db4c0794272";
    private final String AUTH_TOKEN = "bdaab2708227fcaa976277cdf7ff2dc5";
    private final String FROM_NUMBER = "+12055481719";
    public void send(SmsOTP sms){
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
        int min = 100000;
        int max = 999999;
        int number =(int) (Math.random()*(max-min+1)+min);
        String msg = " Mã OTP của bạn là " + number + " không gửi mã kích hoạt cho bất kỳ ai, xin vui lòng cảm ơn";
        Message message = Message.creator(new PhoneNumber(sms.getPhoneNumber()),new PhoneNumber(FROM_NUMBER),msg).create();
        StoreOTP.setOtp(number);
    }
}