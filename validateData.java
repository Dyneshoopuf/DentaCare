/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dentalsoftwareapp;

import java.awt.image.ImageObserver;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author dyne
 */
public class validateData {

    boolean valid;

    protected void validateEmail() {
        boolean isValid;
        String evl;

        SignUp signup = new SignUp();
        String email_valid = signup.txt_email.getText().trim();
        int email_length = email_valid.length();
        evl = email_valid.toLowerCase();
        int count = 0;
        if (evl != null) {
            count += 1;

            if (evl.contains("@") && evl.contains(".") && evl.contains("com")
                    && evl.contains("yahoo") || evl.contains("yahoomail") || evl.contains("gmail") || evl.contains("google")) {
                count += 1;
                if (email_length >= 10) {
                    count += 1;
                    if (count == 3) {
                        isValid = true;
                        valid = isValid;
                    } else {
                        JOptionPane.showMessageDialog(null, "Your email is too short", "Sign up failed", JFrame.ERROR);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Your email is invalid", "Sign up failed", JFrame.ERROR);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please provide your email address", "Sign up failed", JFrame.ERROR);
            }
        }
    }
}




