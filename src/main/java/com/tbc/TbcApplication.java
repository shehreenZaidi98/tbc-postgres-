package com.tbc;

import com.tbc.things.Subscriber;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TbcApplication {

	public static void main(String[] args) throws MqttException {
		SpringApplication.run(TbcApplication.class, args);
	//	Subscriber subscriber=new Subscriber();


	}
}
