/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dentalsoftwareapp;

/**
 *
 * @author Roy
 */
public class DentalSoftwareApp {

    /**
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) /* throws InterruptedException */ {

        /* final Processor processor = new Processor();

         Thread t1 = new Thread(new Runnable() {

         @Override
         public void run() {
         try {
         processor.loginProduce();
         } catch (InterruptedException e) {
         e.printStackTrace();
         }
         }
         });

         Thread t2 = new Thread(new Runnable() {

         @Override
         public void run() {
         try {
         processor.loginConsume();
         } catch (InterruptedException e) {
         e.printStackTrace();
         }
         }
         });

         t1.start();
         t2.start();

         t1.join();
         t2.join();
         */
        int multiplier = 2;
        int multiplier2 = 10;

        ScreenPop screenPop = new ScreenPop();
        screenPop.setVisible(true);

        SignUp signUp = new SignUp();

        try {

            for (int i = 0; i <= 100; i++) {
                Thread.sleep(1 + (i + multiplier + multiplier2));
                screenPop.loadingPercent.setText(Integer.toString(i) + "%");
                screenPop.loadingBar.setValue(i);
                if (i == 100) {
                    screenPop.dispose();
                    signUp.setVisible(true);
                    signUp.setLocationRelativeTo(null);
                }
                if (i == 5) {
                    //checks if license is already claimed
                    screenPop.loadingDescription.setText("Validating license...");
                    Data data = new Data();
                    data.checkLicense();
                    System.out.print("\n");
                    signUp.invalidate();
                }
                if (i == 33) {
                    screenPop.loadingDescription.setText("Loading files...");
                    //here goes the saved directories if software was already claimed beforehand
                    signUp.validate();
                    System.out.println("No existing files found yet");
                }
                if (i == 47) {
                    Thread.sleep(1000);
                    screenPop.loadingDescription.setText("Fetching data...");
                    Data data = new Data();
                    data.getData();
                }
                if (i == 79) {
                    Thread.sleep(1000);
                    screenPop.loadingDescription.setText("Warming up...");
           
                    signUp.revalidate();

                }
                if (i == 99) {
                    Thread.sleep(400);
                    signUp.revalidate();
                    screenPop.loadingDescription.setText("Done..!");
                    Thread.sleep(500);
                    signUp.repaint();
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
