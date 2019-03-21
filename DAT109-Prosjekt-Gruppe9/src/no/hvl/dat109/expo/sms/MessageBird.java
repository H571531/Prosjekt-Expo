package no.hvl.dat109.expo.sms;

import com.messagebird.MessageBirdClient;
import com.messagebird.MessageBirdService;
import com.messagebird.MessageBirdServiceImpl;

import java.math.BigInteger;
import java.util.Arrays;

public class MessageBird implements SMSInterface{

    final String API_KEY;
    final MessageBirdService messageBirdService;
    // Add the service to the client
    final MessageBirdClient messageBirdClient;

    public MessageBird(String api_key) {
        API_KEY = api_key;
        messageBirdService = new MessageBirdServiceImpl(api_key);
        messageBirdClient = new MessageBirdClient(messageBirdService);
    }


    @Override
    public Boolean sendSMS(Long number, String message) {
        try{
            messageBirdClient.sendMessage("EXPO",message, Arrays.asList(BigInteger.valueOf(number)));
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            return false;
        }

    }


}
