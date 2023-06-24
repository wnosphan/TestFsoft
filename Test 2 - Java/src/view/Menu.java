package view;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu<T> {

    protected String title;
    protected ArrayList<T> mChon;

    public Menu() {
    }

    public Menu(String td, String[] mc) {
        title = td;
        mChon = new ArrayList<>();
        for (String s : mc) {
            mChon.add((T) s);
        }
    }
//-------------------------------------------

    public void display() {
        System.out.println(title);
        System.out.println("--------------------------------");
        for (int i = 0; i < mChon.size(); i++) {
            System.out.println((i + 1) + "." + mChon.get(i));
        }
        System.out.println("--------------------------------");
        System.out.print("Enter selection..");
    }
//-------------------------------------------

    public int getSelected() {

        Scanner sc = new Scanner(System.in);
        
        return sc.nextInt();
    }
//-------------------------------------------

    public abstract void execute(int n);

//-------------------------------------------
    public void run() {

        while (true) {
            display();
            int n = getSelected();

            execute(n);
             while(askToContinue()) {
                   
                this.execute(n);
            } 
        }
    }
//------------------------------------------- 

    public boolean askToContinue() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Do you want to continue with this option or go back to the menu? (Y/N) ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if (input.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Please enter a valid input (Y/N).");
            }
        }
    }
}
