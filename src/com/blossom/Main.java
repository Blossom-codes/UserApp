package com.blossom;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        Input input = new Input();
        for (int i = 1; i <= 2; i++) {
            System.out.println("i = " + i);
            String name = input.inputStringDataFromTerminal("Enter your name");
            String email = input.inputStringDataFromTerminal("Enter your email");
            int pin = input.inputIntDataFromTerminal("Set a pin");
            Register signup = new Register(i, name,email,pin);
            System.out.println(signup.name() +", Registration was Successful");
            System.out.println();

        }
    }
}