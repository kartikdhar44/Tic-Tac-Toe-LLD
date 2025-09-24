package org.kartik.ui;

import org.kartik.Board;
import org.kartik.GameManager;

import java.util.Scanner;

public class UI
{
  private final Scanner scanner;

  private static UI Instance;


  public static UI getInstance(){
      if(Instance==null){
          Instance=new UI();
      }
      return Instance;
  }

    public UI() {
        scanner=new Scanner(System.in);
    }


//    public boolean ReadInput()
//    {
//
//        String input=scanner.nextLine().toLowerCase();
//        if(input.equals("s")){
//            display("New Game Started");
//        }
//        if(GameManager.getInstance().getPlayer1()==null){
//            display("Enter Player 1 Name");
//            String name=scanner.nextLine();
//            GameManager.getInstance().AddPlayer(name);
//            return true;
//        }
//        if(GameManager.getInstance().getPlayer2()==null){
//            display("Enter Player 2 Name");
//            String name=scanner.nextLine();
//            GameManager.getInstance().AddPlayer(name);
//            return true;
//        }
//        GameManager.getInstance().init();
//        display("Game Initialized");
//        display("Enter the row and column number to place your symbol");
//        display("Enter row");
//        int row=readInteger();
//        display("Enter Column");
//        int column= readInteger();
//        GameManager.getInstance().firePlayerInput(row,column);
//        return !GameManager.getInstance().getBoard().EndState();
//    }



    public void display(String message){
        System.out.println(message);
    }

    public int readInteger() {
        return scanner.nextInt();
    }



}
