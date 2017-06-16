package dentalsoftwareapp;

import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Roy
 */
public class Time {

    public void currentTimeSignUp(final JLabel lbl_date, final JLabel lbl_time) {

        Thread clock = new Thread() {

            public void run() {
                for (;;) {
                    Calendar cal = new GregorianCalendar();
                    int month = cal.get(Calendar.MONTH);
                    int year = cal.get(Calendar.YEAR);
                    int day = cal.get(Calendar.DAY_OF_MONTH);

                    lbl_date.setText((month + 1) + "/" + day + "/" + year);

                    int second = cal.get(Calendar.SECOND);
                    int zeroMinute = 0;
                    int minute = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR);

                    lbl_time.setText(hour + ":" + (minute) + ":" + second);
                    try {
                        sleep(1000);
                    } catch (Exception ex) {

                    }
                }
            }

        };

        clock.start();
    }

    public void currentTimeLogin(final JLabel date, final JLabel time) {

        Thread clock = new Thread() {

            public void run() {
                for (;;) {
                    Calendar cal = new GregorianCalendar();
                    int month = cal.get(Calendar.MONTH);
                    int year = cal.get(Calendar.YEAR);
                    int day = cal.get(Calendar.DAY_OF_MONTH);

                    date.setText((month + 1) + "/" + day + "/" + year);

                    int second = cal.get(Calendar.SECOND);
                    int zeroMinute = 0;
                    int minute = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR);

                    time.setText(hour + ":" + (minute) + ":" + second);
                    try {
                        sleep(1000);
                    } catch (Exception ex) {

                    }
                }
            }

        };

        clock.start();
    }
}
