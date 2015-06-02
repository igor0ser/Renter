package com.epam.renter.properties;

public class Runner {
public static void main(String[] args) {
	System.out.println(Message.getInstance().getProperty(Message.WRONG_LOGIN));
}
}
