package com.luiz.TextBasedChat.controller;

import com.luiz.TextBasedChat.model.Message;
import com.luiz.TextBasedChat.model.User;
import com.luiz.TextBasedChat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Controller
public class ChatController {
    private final ChatService chatService;

    // Constructor DI
    @Autowired
    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }

    // Method to get sender and receiver from user input
    public Map<String, String> selectSenderReceiver(Scanner scanner){
        Map<String, String> chatUsers = new HashMap<>();
        System.out.println("Choose the Sender name: ");
        String senderName = scanner.nextLine();
        chatUsers.put("Sender", senderName);

        System.out.println("Choose the receiver name: ");
        String receiverName = scanner.nextLine();
        chatUsers.put("Receiver", receiverName);

        return chatUsers;
    }

    // Method to start the chat
    public void startChat(){
        boolean quit = false;

        while(!quit){
            Scanner scanner = new Scanner(System.in);

            // Option to guide through the app.
            System.out.println("What would you like to do?\n1. Send a message\n2. Display Chat History\n3. Quit");
            int userAppOption = scanner.nextInt();
            scanner.nextLine();

            switch (userAppOption){
                //Send Message
                case 1:
                    // Get users
                    Map<String, String> chatUsers = selectSenderReceiver(scanner);
                    User sender = new User(chatUsers.get("Sender"));
                    User receiver = new User(chatUsers.get("Receiver"));

                    // Get Message content
                    System.out.println("Please, enter the message content: ");
                    String messageContent = scanner.nextLine();

                    // Create Message Object
                    Message message = new Message(messageContent, sender, receiver);
                    chatService.sendMessage(message);
                    break;
                // Display History
                case 2:
                    chatService.displayChatHistory();
                    break;
                // Quit
                case 3:
                    quit=true;
                    break;
                // Default
                default:
                    System.out.println("Invalid option. Please select again...\n");
            }
        }
    }
}
