package ducmin.otp.controller;

import ducmin.otp.model.SmsPojo;
import ducmin.otp.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class SMSController {
    @Autowired
    SmsService smsService;
    @Autowired
    private SimpMessagingTemplate websocket;
    private final String TOPIC_DESTINATION = "/lesson/sms";

    @PostMapping("/mobileNo")
    public ResponseEntity<?> sendOtp(@RequestBody SmsPojo sms){
        try {
            smsService.send(sms);

        }catch (Exception e){
            return new ResponseEntity<>("Vui lòng kiểm tra lại số điện thoại", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        websocket.convertAndSend(TOPIC_DESTINATION,getTimeStamp()+": SMS has been sent!" + sms.getPhoneNumber());
        return new ResponseEntity<>("Đã gửi mã OTP xin vui lòng nhập mã",HttpStatus.OK);
    }
    private String getTimeStamp(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }
}
