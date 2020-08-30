package msabank;

import msabank.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDepositRequested_DepositBalance(@Payload DepositRequested depositRequested){

        if(depositRequested.isMe()){
            System.out.println("##### listener DepositBalance : " + depositRequested.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverWithdrawRequested_WithdrawBalance(@Payload WithdrawRequested withdrawRequested){

        if(withdrawRequested.isMe()){
            System.out.println("##### listener WithdrawBalance : " + withdrawRequested.toJson());
        }
    }

}
