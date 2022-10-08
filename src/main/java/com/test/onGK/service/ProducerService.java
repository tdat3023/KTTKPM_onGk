package com.test.onGK.service;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.onGK.product.api.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;
import java.util.Date;

@Component
public class ProducerService {

    @Value("${spring.activemq.topic}")
    String topic;

    @Value("${spring.activemq.queue}")
    String queue;

    @Autowired
    JmsTemplate jmsTemplate;

//    public void sendToQueue() throws JsonProcessingException {
//        try {
//           
//            String jsonObj = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(employee);
//            jmsTemplate.send(queue, messageCreator -> {
//                TextMessage message = messageCreator.createTextMessage();
//                message.setText(jsonObj);
//                return message;
//            });
//        }
//        catch (Exception ex) {
//            System.out.println("ERROR in sending message to queue");
//        }
//    }

    public void sendToTopic(String text) throws JsonProcessingException {
        try {
          
            //String jsonObj = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(department);
            jmsTemplate.send(topic, messageCreator -> {
                TextMessage message = messageCreator.createTextMessage();
                message.setText(text);
                return message;
            });
        }
        catch (Exception ex) {
            System.out.println("ERROR in sending message to queue");
        }
    }

}