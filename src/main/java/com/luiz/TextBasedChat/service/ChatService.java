package com.luiz.TextBasedChat.service;

import com.luiz.TextBasedChat.model.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {
    private List<Message> messageHistory = new ArrayList<>();

    // Method to add the message object on the List messageHistory
    public void sendMessage(Message message){
        System.out.println("\n------- Sending Message -------");
        messageHistory.add(message);
        System.out.println(message.getSender().getName() + " is sending message to " + message.getReceiver().getName() + " ...");
        System.out.println("Message: " + message.getContent());
        System.out.println("-------------------------------\n");

    }

    // Method to display the Chat History
    public void displayChatHistory(){
        System.out.println("\n------- Chat History -------");
        if (messageHistory.isEmpty()){
            System.out.println("No message history do display. Send a message and try again :)");
        }
        else {
            for (Message message : messageHistory){
                System.out.println("Sender: " + message.getSender().getName());
                System.out.println("Receiver: " + message.getReceiver().getName());
                System.out.println("Content: " + message.getContent() + '\n');
            }
        }
        System.out.println("----------------------------\n");

    }
}
