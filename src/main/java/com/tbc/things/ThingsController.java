package com.tbc.things;

import com.tbc.session.Session;
import com.tbc.session.SessionRepository;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController

@CrossOrigin("*")
public class ThingsController {
@Autowired
    ThingsRepository thingsRepository;
@Autowired
    SessionRepository sessionRepository;
@PostMapping("insertUserCredentials")
    public String insertUser_credentials(@RequestBody Things things){
    thingsRepository.save(things);
    return null;
}
@GetMapping("getData")
    public List<Things>getAllData(){

 return thingsRepository.findAll();
}

    @GetMapping("getLogin")
    public String getLogin(@RequestParam("user_id")String user_id,
                                            @RequestParam("password")String password) {
    Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Session session=new Session();
        session.setUser_id(user_id);
        session.setPassword(password);
        session.setDate(sdf.format(date));
        session.setStatus("active");

       List<Things> list = thingsRepository.getLogin(user_id,password);
        String message="Not Login";
        if(list.size()>0){
            sessionRepository.save(session);
            message="Login";
        }
        return message;
    }
    @Scheduled(fixedDelay = 60000)
    public void sessionExpire() throws ParseException, MqttException {
    List<Session>list=sessionRepository.getStatus("active");
    Date date=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    for(Session session:list) {
        Date startDate = sdf.parse(session.getDate());
        long diff=date.getTime()-startDate.getTime();
        long min=diff/(1000*60);
        if(min>=3){
            Subscriber subscriber=new Subscriber();
            MqttMessage message = new MqttMessage("expire".getBytes());

            subscriber.client.publish("session",message);

            sessionRepository.getSession("expire",session.getUser_id(),session.getPassword());
        }
        System.out.println(min);

    }
   

    // session active for 15 min ;
    }
}
