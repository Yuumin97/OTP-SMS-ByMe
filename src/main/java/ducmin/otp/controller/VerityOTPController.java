package ducmin.otp.controller;

import ducmin.otp.model.StoreOTP;
import ducmin.otp.model.TempOTP;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerityOTPController {
    @PostMapping("/otp")
    public String verityOTP(@RequestBody TempOTP sms){
        if (sms.getOtp()== StoreOTP.getOtp())
            return "Đã nhập đúng OTP xin cảm ơn";
        else
            return "Sai mã OTP xin vui lòng nhập lại";
    }
}
