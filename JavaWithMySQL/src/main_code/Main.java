package main_code;


import gui.Window;

public class Main {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Window();
            }

    });
  }
}