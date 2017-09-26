package br.com.bikonect.handler;

/**
 * Created by danilopereira on 26/09/17.
 */
public class MqttHandler {

    private String message;


    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
