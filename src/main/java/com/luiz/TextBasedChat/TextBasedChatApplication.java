package com.luiz.TextBasedChat;

import com.luiz.TextBasedChat.controller.ChatController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TextBasedChatApplication implements CommandLineRunner {
	@Autowired
	private ChatController chatController;

	public static void main(String[] args) {
		SpringApplication.run(TextBasedChatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		chatController.startChat();
	}
}
