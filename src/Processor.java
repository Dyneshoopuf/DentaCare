package dentalsoftwareapp;

import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Roy
 */
public class Processor {

    public void loginProduce() throws InterruptedException {

        synchronized (this) {

            wait();

        }
    }

    public void loginConsume() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        synchronized (this) {

            for (long a = 0; 0 < 1000; a++) {
                if (a == 100) {
                    System.out.println(a);
                    notify();
                }
            }
        }
    }
}
