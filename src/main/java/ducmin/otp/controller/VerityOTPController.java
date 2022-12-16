package ducmin.otp.controller;

import ducmin.otp.dto.StoreOTP;
import ducmin.otp.dto.TempOTP;
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
