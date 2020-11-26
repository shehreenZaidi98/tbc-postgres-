package com.tbc.things;


import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;



/**
 * A sample application that demonstrates how to use the Paho MQTT v3.1 Client blocking API.
 */
public  class Subscriber implements MqttCallback {

    private final int qos = 1;
    private String topic = "session";
    protected MqttClient client;

  
    public Subscriber() throws MqttException {
        String host = String.format("tcp://%s:%d", "localhost", 1883);
        /*String username = "test";
        String password = "123";*/
        String clientId = "MQTT-Java-Example";
        MqttConnectOptions conOpt = new MqttConnectOptions();
        conOpt.setCleanSession(true);
       /* conOpt.setUserName(username);
        conOpt.setPassword(password.toCharArray());*/
        if (this.client == null) {
            this.client = new MqttClient(host, clientId+Math.random(), new MemoryPersistence());
            this.client.setCallback(this);
            this.client.connect(conOpt);

            this.client.subscribe(this.topic, qos);
        }

    }
  /*  public void sendMessage(String payload) throws MqttException {
        MqttMessage message = new MqttMessage(payload.getBytes());
        message.setQos(qos);
        this.client.publish(this.topic, message); // Blocking publish
    }
*/
    /**
     * @see MqttCallback#connectionLost(Throwable)
     */
    public void connectionLost(Throwable cause) {
        System.out.println("Connection lost because: " + cause);
        try {
            new Subscriber();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * @see MqttCallback#deliveryComplete(IMqttDeliveryToken)
     */
    public void deliveryComplete(IMqttDeliveryToken token) {
    }

    /**
     */
    public void messageArrived(String topic, MqttMessage message) throws MqttException 
     {

System.out.println(message+"    "+topic);
    }

}
