package com.luiz.TextBasedChat.model;

public class Message {
    private String content;
    private User sender;
    private User receiver;

    // Constructor
    public Message(String content, User sender, User receiver){
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
    }

    // Getters
    public String getContent(){
        return content;
    }

    public User getSender(){
        return sender;
    }

    public User getReceiver(){
        return receiver;
    }

}
