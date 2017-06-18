/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dentalsoftwareapp;

import AppPackage.AnimationClass;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.sql.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import javax.swing.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Roy
 */
public class SignUp extends javax.swing.JFrame {

    // protected ImageIcon software_icon;
    protected String txtName, txtUsername, txtEmail;
    protected String txtPassword;
    private char[] chrPassword;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement pst;
    private String empty = "";
    public Color lpane_color;
    public Color rpane_color;
    public Color txt_name_color;
    public Color txt_username_color;
    public Color txt_email_color;
    public Color txt_password_color;
    public Color chkbox_agree_color;
    public Color jPanel3_color;
    public Color signup_button_color;
    public Color contactPanel_color;
    public Color signIn_color;
    public Color lbl_date_color;
    public Color lbl_time_color;
    public Color jLayeredPane2_color;
    int secondsPassed = 0;

    Timer stopwatch;
    int countCounter;

    int xx;
    int yy;
    int login_attempts = 6;
    int countTimer = 0;
    int delay = 1000;

    Data db = new Data();
    Time time = new Time();

    //for binary pw
    private char[] getPw() {
        return chrPassword;
    }

    /**
     * Creates new form SignUp2
     */
    public SignUp() {
        initComponents();
        modifyThis();
        final int height = this.getHeight();
        final int width = this.getWidth();
        final Dimension default_dimension = new Dimension(width, height);
        getDefaultLocation(xx, yy);

        System.out.println(secondsPassed);
        //overrides
        time.currentTimeSignUp(lbl_date, lbl_time);

        getDefaultColors();
        lbl_null_name.setVisible(false);
        lbl_null_username.setVisible(false);
        lbl_null_password.setVisible(false);
        lbl_accepted_password.setVisible(false);
        lbl_null_email.setVisible(false);
        lbl_unaccepted_password.setVisible(false);
        lbl_accepted_email.setVisible(false);
        lbl_unaccepted_email.setVisible(false);
        login_username.setVisible(false);
        login_password.setVisible(false);
        login_lbl_username.setVisible(false);
        login_lbl_password.setVisible(false);
        loginPanel.setVisible(false);
        login_lbl_login.setVisible(false);
        img_loader.setVisible(false);
        chkbox_agree.setEnabled(false);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerdb", "root", "");
            st = con.createStatement();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    protected final void validation() {
        showLoginStuff();
        final String username = login_username.getText();
        final char[] charpassword = login_password.getPassword();
        final String password = String.valueOf(charpassword);
        int count = 0;
        double mastercount = 0;
        boolean isUsernamePresent = false;
        boolean isPasswordPresent = false;

        if (login_username != null && !login_username.getText().equals(empty)) {
            mastercount += 0.5;
            isUsernamePresent = true;
        }
        if (login_password != null && !password.equals(empty)) {
            mastercount += 0.5;
            isPasswordPresent = true;
        }

        if (isUsernamePresent == false && isPasswordPresent == true) {
            JOptionPane.showMessageDialog(SignUp.this, "Username cannot be empty");
        }
        if (isPasswordPresent == false && isUsernamePresent == true) {
            JOptionPane.showMessageDialog(SignUp.this, "Password cannot be empty");

        } else if (isUsernamePresent == false && isPasswordPresent == false) {
            JOptionPane.showMessageDialog(SignUp.this, "Username and Password cannot be empty");
        }

        if (mastercount == 1) {

            /*   if (login_attempts <= 2 && login_attempts != 0 && count == 0) {
                int options = JOptionPane.showConfirmDialog(SignUp.this, "It seems to me that you are having trouble accessing your account. Do you wish to reset your password?", "Login problem", YES_NO_OPTION, HEIGHT, new ImageIcon(getClass().getResource("/resources/nerd.png")));
                if (options == JOptionPane.YES_OPTION) {
                    ForgotPassword fp = new ForgotPassword(SignUp.this, true);
                    fp.setLocationByPlatform(true);
                    fp.setVisible(true);
                }
            }
              if (login_attempts == 0 && count != 0) {
                JOptionPane.showMessageDialog(SignUp.this, "Sorry, but you've entered incorrect log-in details multiple times. Shutting down.");
                System.exit(1);
            }
             */
            if (mastercount == 1 && isUsernamePresent == true && isPasswordPresent == true) {
                try {
                    Thread.sleep(100);
                    String validateAccount = "SELECT Username, Password FROM registertbl WHERE Username = '" + username + "' and Password = '" + password + "'";

                    rs = st.executeQuery(validateAccount);

                    while (rs.next()) {
                        count += 1;
                    }
                    if (count == 1) {

                        count += 1;
                    } else if (count == 0) {
                        if (login_attempts >= 3) {
                            JOptionPane.showMessageDialog(SignUp.this, "Incorrect username and or password");
                        }
                        login_attempts -= 1;
                    }
                    if (login_attempts <= 2 && login_attempts != 0 && count == 0) {
                        int options = JOptionPane.showConfirmDialog(SignUp.this, "It seems to me that you are having trouble accessing your account. Do you wish to reset your password?", "Login problem", YES_NO_OPTION, HEIGHT, new ImageIcon(getClass().getResource("/resources/nerd.png")));
                        if (options == JOptionPane.YES_OPTION) {

                            ForgotPassword fp = new ForgotPassword(SignUp.this, true);
                            fp.setLocationByPlatform(true);
                            fp.setVisible(true);
                        }
                    }
                    if (login_attempts == 0 && count != 0) {
                        JOptionPane.showMessageDialog(SignUp.this, "Sorry, but you've entered incorrect log-in details multiple times. Shutting down.");
                        System.exit(1);
                    }

                    if (count == 2) {
                        mastercount += 1;
                    }
                    System.out.println("count is" + count);

                    if (mastercount == 2) {

                        JOptionPane.showMessageDialog(SignUp.this, "Welcome, " + username);
                        login_username.setText("");
                        login_password.setText("");
                        super.dispose();
                        Home home = new Home();
                        home.setVisible(true);

                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }

    }

    public void startTimer(int countPassed, final JLabel img_loader) {
        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (countTimer == 0) {
                    stopwatch.stop();
                    img_loader.setVisible(false);
                    validation();

                } else {
                    img_loader.setVisible(true);
                    countTimer--;
                }
            }
        };
        stopwatch = new Timer(delay, action);
        stopwatch.setInitialDelay(0);
        stopwatch.start();
        countTimer = countPassed;
    }

    public void setToggleColorIcon(String toggleColor_icon) {
        URL url = getClass().getResource(toggleColor_icon);
        try {
            BufferedImage default_theme_icon = ImageIO.read(url);
            toggleColor.setIcon(new ImageIcon(default_theme_icon));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hideLoginStuff() {
        loginPanel.setVisible(false);
        login_lbl_username.setVisible(false);
        login_lbl_password.setVisible(false);
        loginButton.setVisible(false);
        login_username.setVisible(false);
        login_password.setVisible(false);
        login_lbl_login.setVisible(false);
        lbl_signup.setVisible(false);
        sign_up_button.setVisible(false);

    }

    public void showLoginStuff() {
        loginPanel.setVisible(true);
        login_lbl_username.setVisible(true);
        login_lbl_password.setVisible(true);
        loginButton.setVisible(true);
        login_username.setVisible(true);
        login_password.setVisible(true);
        login_lbl_login.setVisible(true);
        lbl_signup.setVisible(true);
        sign_up_button.setVisible(true);

    }

    // method for getting the default BG of all components
    public void getDefaultColors() {
        lpane_color = lPane.getBackground();
        rpane_color = rPane.getBackground();
        txt_name_color = txt_name.getBackground();
        txt_username_color = txt_username.getBackground();
        txt_password_color = txt_password.getBackground();
        txt_email_color = txt_email.getBackground();
        chkbox_agree_color = chkbox_agree.getBackground();
        jPanel3_color = jPanel3.getBackground();
        contactPanel_color = contactPanel.getBackground();
        jLayeredPane2_color = jLayeredPane2.getBackground();

        //get Default FG
        signIn_color = login.getForeground();
        signup_button_color = signup_button.getForeground();
        lbl_date_color = lbl_date.getForeground();
        lbl_time_color = lbl_date.getForeground();
    }

    //method to set the default BG that I got from this ^
    public void setDefaultColors() {
        lPane.setBackground(lpane_color);
        rPane.setBackground(rpane_color);
        txt_name.setBackground(txt_name_color);
        txt_username.setBackground(txt_username_color);
        txt_password.setBackground(txt_password_color);
        txt_email.setBackground(txt_email_color);
        chkbox_agree.setBackground(chkbox_agree_color);
        jPanel3.setBackground(jPanel3_color);
        contactPanel.setBackground(contactPanel_color);
        jLayeredPane2.setBackground(jLayeredPane2_color);

        //set DefaultFG
        login.setForeground(signIn_color);
        signup_button.setForeground(signup_button_color);
        lbl_date.setForeground(lbl_date_color);
        lbl_time.setForeground(lbl_time_color);

    }

    final void getDefaultLocation(int login_X, int login_Y) {
        login_X = login.getX();
        login_Y = login.getY();

        xx = login_X;
        yy = login_Y;

    }

    /* final void setDefaultLocation() {
        login.setLocation(login_X, login_Y);
    }
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        menu_refresh = new javax.swing.JMenuItem();
        menu_clear = new javax.swing.JMenuItem();
        menu_exit = new javax.swing.JMenuItem();
        rPane = new javax.swing.JPanel();
        lPane = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        lbl_logo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        lbl_date = new javax.swing.JLabel();
        lbl_time = new javax.swing.JLabel();
        logoButton = new javax.swing.JButton();
        seePassword = new javax.swing.JCheckBox();
        login = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        lbl_password = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        txt_email = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        signup_button = new javax.swing.JButton();
        lbl_contactus = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lbl_username = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        lbl_null_name = new javax.swing.JLabel();
        passwordProtect = new javax.swing.JLabel();
        lbl_null_username = new javax.swing.JLabel();
        lbl_null_password = new javax.swing.JLabel();
        lbl_null_email = new javax.swing.JLabel();
        lbl_capslock = new javax.swing.JLabel();
        toggleColor = new javax.swing.JToggleButton();
        lbl_accepted_password = new javax.swing.JLabel();
        lbl_unaccepted_password = new javax.swing.JLabel();
        contactPanel = new javax.swing.JPanel();
        contact_fb = new javax.swing.JButton();
        contact_google = new javax.swing.JButton();
        contact_twitter = new javax.swing.JButton();
        lbl_or = new javax.swing.JLabel();
        log_in_button = new javax.swing.JButton();
        lbl_accepted_email = new javax.swing.JLabel();
        lbl_unaccepted_email = new javax.swing.JLabel();
        settingButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        chkbox_agree = new javax.swing.JCheckBox();
        termsandconditionsButton = new javax.swing.JButton();
        lbl_signup = new javax.swing.JLabel();
        sign_up_button = new javax.swing.JButton();
        login_username = new javax.swing.JTextField();
        login_password = new javax.swing.JPasswordField();
        login_lbl_username = new javax.swing.JLabel();
        login_lbl_password = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        login_lbl_login = new javax.swing.JLabel();
        img_loader = new javax.swing.JLabel();

        jPopupMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPopupMenu1MouseReleased(evt);
            }
        });

        menu_refresh.setText("Refresh");
        menu_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_refreshActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menu_refresh);

        menu_clear.setText("Clear text");
        menu_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_clearActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menu_clear);

        menu_exit.setText("Exit");
        menu_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_exitActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menu_exit);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rPane.setBackground(new java.awt.Color(74, 67, 102));
        rPane.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rPaneFocusGained(evt);
            }
        });
        rPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rPaneMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rPaneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rPaneMouseEntered(evt);
            }
        });
        rPane.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rPaneKeyPressed(evt);
            }
        });
        rPane.setLayout(null);

        lPane.setBackground(new java.awt.Color(155, 110, 163));
        lPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lPaneMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lPaneMouseClicked(evt);
            }
        });
        lPane.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 2, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 255));
        jLabel3.setText("Alpha");
        lPane.add(jLabel3);
        jLabel3.setBounds(560, 210, 50, 30);

        jSeparator2.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lPane.add(jSeparator2);
        jSeparator2.setBounds(10, 180, 630, 10);

        jSeparator6.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lPane.add(jSeparator6);
        jSeparator6.setBounds(40, 260, 570, 20);

        lbl_logo.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        lbl_logo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_logo.setText("<LOGO HERE> ");
        lPane.add(lbl_logo);
        lbl_logo.setBounds(240, 430, 178, 120);

        jLabel9.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("A dentist gets to the root of the problem");
        lPane.add(jLabel9);
        jLabel9.setBounds(50, 130, 566, 50);

        jLabel6.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Keep track of your patients with ");
        lPane.add(jLabel6);
        jLabel6.setBounds(70, 210, 420, 50);

        jLabel14.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("DentaCare");
        lPane.add(jLabel14);
        jLabel14.setBounds(440, 210, 150, 50);

        jLayeredPane2.setBackground(new java.awt.Color(155, 110, 163));
        jLayeredPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLayeredPane2.setToolTipText("");
        jLayeredPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLayeredPane2.setOpaque(true);
        jLayeredPane2.setLayout(new java.awt.GridLayout(1, 0));

        lbl_date.setFont(new java.awt.Font("DialogInput", 0, 24)); // NOI18N
        lbl_date.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/date2.png"))); // NOI18N
        lbl_date.setText("Date");
        jLayeredPane2.add(lbl_date);

        lbl_time.setFont(new java.awt.Font("DialogInput", 0, 24)); // NOI18N
        lbl_time.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/clock_1.png"))); // NOI18N
        lbl_time.setText("Time");
        jLayeredPane2.add(lbl_time);

        lPane.add(jLayeredPane2);
        jLayeredPane2.setBounds(0, 0, 670, 50);

        logoButton.setToolTipText("");
        logoButton.setBorderPainted(false);
        logoButton.setContentAreaFilled(false);
        logoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoButtonActionPerformed(evt);
            }
        });
        lPane.add(logoButton);
        logoButton.setBounds(190, 440, 280, 100);

        rPane.add(lPane);
        lPane.setBounds(0, 0, 660, 720);

        seePassword.setBorder(null);
        seePassword.setContentAreaFilled(false);
        seePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seePassword.setFocusable(false);
        seePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/antieye2.png"))); // NOI18N
        seePassword.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/eye2.png"))); // NOI18N
        seePassword.setVerifyInputWhenFocusTarget(false);
        seePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                seePasswordMouseEntered(evt);
            }
        });
        seePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seePasswordActionPerformed(evt);
            }
        });
        rPane.add(seePassword);
        seePassword.setBounds(1160, 380, 40, 28);

        login.setBackground(new java.awt.Color(204, 204, 204));
        login.setFont(new java.awt.Font("Century Gothic", 2, 24)); // NOI18N
        login.setText("Log In");
        login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rPane.add(login);
        login.setBounds(860, 50, 80, 60);

        lbl_name.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_name.setForeground(new java.awt.Color(102, 102, 102));
        lbl_name.setText("FULL NAME");
        rPane.add(lbl_name);
        lbl_name.setBounds(720, 150, 80, 40);

        lbl_password.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_password.setForeground(new java.awt.Color(102, 102, 102));
        lbl_password.setText("PASSWORD");
        rPane.add(lbl_password);
        lbl_password.setBounds(720, 330, 80, 40);
        rPane.add(jSeparator1);
        jSeparator1.setBounds(1050, 590, 150, 10);
        rPane.add(jSeparator3);
        jSeparator3.setBounds(720, 230, 470, 10);
        rPane.add(jSeparator4);
        jSeparator4.setBounds(720, 320, 470, 10);
        rPane.add(jSeparator5);
        jSeparator5.setBounds(720, 410, 470, 10);

        txt_email.setBackground(new java.awt.Color(74, 67, 102));
        txt_email.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setText("Your email here");
        txt_email.setBorder(null);
        txt_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emailFocusLost(evt);
            }
        });
        txt_email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_emailMouseClicked(evt);
            }
        });
        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_emailKeyPressed(evt);
            }
        });
        rPane.add(txt_email);
        txt_email.setBounds(720, 470, 470, 30);

        txt_name.setBackground(new java.awt.Color(74, 67, 102));
        txt_name.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        txt_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_name.setText("Enter your full name");
        txt_name.setBorder(null);
        txt_name.setCaretColor(new java.awt.Color(74, 67, 102));
        txt_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nameFocusLost(evt);
            }
        });
        txt_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_nameMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_nameMouseExited(evt);
            }
        });
        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });
        txt_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nameKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nameKeyReleased(evt);
            }
        });
        rPane.add(txt_name);
        txt_name.setBounds(720, 200, 470, 30);

        txt_username.setBackground(new java.awt.Color(74, 67, 102));
        txt_username.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        txt_username.setForeground(new java.awt.Color(255, 255, 255));
        txt_username.setText("Enter your username ");
        txt_username.setToolTipText("Enter a non-uppercase username between 3 to 20 characters");
        txt_username.setBorder(null);
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        txt_username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_usernameMouseClicked(evt);
            }
        });
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usernameKeyPressed(evt);
            }
        });
        rPane.add(txt_username);
        txt_username.setBounds(720, 290, 470, 30);

        txt_password.setBackground(new java.awt.Color(74, 67, 102));
        txt_password.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setText("Password here");
        txt_password.setBorder(null);
        txt_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_passwordFocusLost(evt);
            }
        });
        txt_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_passwordMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_passwordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_passwordMouseEntered(evt);
            }
        });
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });
        rPane.add(txt_password);
        txt_password.setBounds(720, 380, 430, 30);

        jPanel3.setBackground(new java.awt.Color(155, 110, 163));
        jPanel3.setLayout(null);

        signup_button.setBackground(new java.awt.Color(155, 110, 163));
        signup_button.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        signup_button.setForeground(java.awt.Color.white);
        signup_button.setText("Sign Up");
        signup_button.setToolTipText("");
        signup_button.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        signup_button.setBorderPainted(false);
        signup_button.setContentAreaFilled(false);
        signup_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signup_button.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                signup_buttonFocusLost(evt);
            }
        });
        signup_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_buttonActionPerformed(evt);
            }
        });
        jPanel3.add(signup_button);
        signup_button.setBounds(0, 0, 210, 50);

        rPane.add(jPanel3);
        jPanel3.setBounds(720, 590, 210, 50);

        lbl_contactus.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_contactus.setForeground(new java.awt.Color(204, 204, 204));
        lbl_contactus.setText("Contact Us");
        rPane.add(lbl_contactus);
        lbl_contactus.setBounds(1100, 620, 80, 30);
        rPane.add(jSeparator7);
        jSeparator7.setBounds(720, 500, 470, 10);

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton3.setToolTipText("Sign-in here");
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        rPane.add(jButton3);
        jButton3.setBounds(1060, 570, 140, 20);

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Already a member?");
        rPane.add(jLabel10);
        jLabel10.setBounds(1060, 570, 140, 20);

        lbl_username.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(102, 102, 102));
        lbl_username.setText("USERNAME");
        rPane.add(lbl_username);
        lbl_username.setBounds(720, 240, 80, 40);

        lbl_email.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(102, 102, 102));
        lbl_email.setText("EMAIL");
        rPane.add(lbl_email);
        lbl_email.setBounds(720, 420, 50, 40);

        lbl_null_name.setBackground(new java.awt.Color(36, 47, 65));
        lbl_null_name.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_null_name.setForeground(new java.awt.Color(255, 255, 255));
        lbl_null_name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/nullfield.png"))); // NOI18N
        lbl_null_name.setToolTipText("Full name cannot be empty");
        rPane.add(lbl_null_name);
        lbl_null_name.setBounds(690, 210, 20, 20);

        passwordProtect.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        passwordProtect.setForeground(new java.awt.Color(204, 204, 204));
        passwordProtect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shield.png"))); // NOI18N
        passwordProtect.setToolTipText("This software is highly optimized to prevent any unathorized access (eg., hackers)");
        passwordProtect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                passwordProtectMouseReleased(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                passwordProtectMouseEntered(evt);
            }
        });
        rPane.add(passwordProtect);
        passwordProtect.setBounds(800, 330, 30, 40);

        lbl_null_username.setBackground(new java.awt.Color(36, 47, 65));
        lbl_null_username.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_null_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_null_username.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/nullfield.png"))); // NOI18N
        lbl_null_username.setToolTipText("Username cannot be empty");
        rPane.add(lbl_null_username);
        lbl_null_username.setBounds(690, 300, 20, 20);

        lbl_null_password.setBackground(new java.awt.Color(36, 47, 65));
        lbl_null_password.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_null_password.setForeground(new java.awt.Color(255, 255, 255));
        lbl_null_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/nullfield.png"))); // NOI18N
        lbl_null_password.setToolTipText("Password cannot be empty");
        lbl_null_password.setFocusable(false);
        lbl_null_password.setRequestFocusEnabled(false);
        lbl_null_password.setVerifyInputWhenFocusTarget(false);
        rPane.add(lbl_null_password);
        lbl_null_password.setBounds(690, 390, 20, 20);

        lbl_null_email.setBackground(new java.awt.Color(36, 47, 65));
        lbl_null_email.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_null_email.setForeground(new java.awt.Color(255, 255, 255));
        lbl_null_email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/nullfield.png"))); // NOI18N
        lbl_null_email.setToolTipText("Email cannot be empty");
        lbl_null_email.setFocusable(false);
        lbl_null_email.setRequestFocusEnabled(false);
        lbl_null_email.setVerifyInputWhenFocusTarget(false);
        rPane.add(lbl_null_email);
        lbl_null_email.setBounds(690, 480, 20, 20);

        lbl_capslock.setBackground(new java.awt.Color(36, 47, 65));
        lbl_capslock.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lbl_capslock.setForeground(new java.awt.Color(255, 255, 255));
        lbl_capslock.setToolTipText("Cannot be blank");
        rPane.add(lbl_capslock);
        lbl_capslock.setBounds(1110, 170, 140, 20);

        toggleColor.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        toggleColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/dark tooth.png"))); // NOI18N
        toggleColor.setBorderPainted(false);
        toggleColor.setContentAreaFilled(false);
        toggleColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toggleColor.setFocusPainted(false);
        toggleColor.setVerifyInputWhenFocusTarget(false);
        toggleColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleColorActionPerformed(evt);
            }
        });
        rPane.add(toggleColor);
        toggleColor.setBounds(1220, 0, 40, 40);

        lbl_accepted_password.setBackground(new java.awt.Color(36, 47, 65));
        lbl_accepted_password.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_accepted_password.setForeground(new java.awt.Color(255, 255, 255));
        lbl_accepted_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/check.png"))); // NOI18N
        lbl_accepted_password.setToolTipText("Your password strength is up to our standards!");
        rPane.add(lbl_accepted_password);
        lbl_accepted_password.setBounds(690, 390, 20, 20);

        lbl_unaccepted_password.setBackground(new java.awt.Color(36, 47, 65));
        lbl_unaccepted_password.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_unaccepted_password.setForeground(new java.awt.Color(255, 255, 255));
        lbl_unaccepted_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/invalid.png"))); // NOI18N
        lbl_unaccepted_password.setToolTipText("Your password is too weak");
        rPane.add(lbl_unaccepted_password);
        lbl_unaccepted_password.setBounds(690, 390, 20, 20);

        contactPanel.setBackground(new java.awt.Color(74, 67, 102));
        contactPanel.setLayout(null);

        contact_fb.setBackground(new java.awt.Color(36, 47, 65));
        contact_fb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fbIcon.png"))); // NOI18N
        contact_fb.setToolTipText("Contact Us");
        contact_fb.setBorder(null);
        contact_fb.setContentAreaFilled(false);
        contact_fb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contact_fb.setFocusPainted(false);
        contact_fb.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fbIconBig.png"))); // NOI18N
        contact_fb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contact_fbMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                contact_fbMouseEntered(evt);
            }
        });
        contact_fb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contact_fbActionPerformed(evt);
            }
        });
        contactPanel.add(contact_fb);
        contact_fb.setBounds(0, 0, 74, 61);

        contact_google.setBackground(new java.awt.Color(36, 47, 65));
        contact_google.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/google.png"))); // NOI18N
        contact_google.setToolTipText("Contact Us");
        contact_google.setBorder(null);
        contact_google.setContentAreaFilled(false);
        contact_google.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contact_google.setFocusPainted(false);
        contact_google.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/googleBig.png"))); // NOI18N
        contact_google.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contact_googleActionPerformed(evt);
            }
        });
        contactPanel.add(contact_google);
        contact_google.setBounds(80, 0, 64, 68);

        contact_twitter.setBackground(new java.awt.Color(36, 47, 65));
        contact_twitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/twitter.png"))); // NOI18N
        contact_twitter.setToolTipText("Contact Us");
        contact_twitter.setBorder(null);
        contact_twitter.setContentAreaFilled(false);
        contact_twitter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contact_twitter.setFocusPainted(false);
        contact_twitter.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/twitterBig.png"))); // NOI18N
        contact_twitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contact_twitterActionPerformed(evt);
            }
        });
        contactPanel.add(contact_twitter);
        contact_twitter.setBounds(150, 0, 78, 61);

        rPane.add(contactPanel);
        contactPanel.setBounds(1030, 650, 240, 80);

        lbl_or.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lbl_or.setForeground(new java.awt.Color(102, 102, 102));
        lbl_or.setText("or");
        rPane.add(lbl_or);
        lbl_or.setBounds(820, 60, 40, 40);

        log_in_button.setBackground(new java.awt.Color(0, 204, 255));
        log_in_button.setBorder(null);
        log_in_button.setContentAreaFilled(false);
        log_in_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        log_in_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_in_buttonActionPerformed(evt);
            }
        });
        rPane.add(log_in_button);
        log_in_button.setBounds(850, 60, 90, 40);

        lbl_accepted_email.setBackground(new java.awt.Color(36, 47, 65));
        lbl_accepted_email.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_accepted_email.setForeground(new java.awt.Color(255, 255, 255));
        lbl_accepted_email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/check.png"))); // NOI18N
        lbl_accepted_email.setToolTipText("Your email is valid");
        rPane.add(lbl_accepted_email);
        lbl_accepted_email.setBounds(690, 480, 20, 20);

        lbl_unaccepted_email.setBackground(new java.awt.Color(36, 47, 65));
        lbl_unaccepted_email.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_unaccepted_email.setForeground(new java.awt.Color(255, 255, 255));
        lbl_unaccepted_email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/invalid.png"))); // NOI18N
        lbl_unaccepted_email.setToolTipText("This is not a valid email");
        rPane.add(lbl_unaccepted_email);
        lbl_unaccepted_email.setBounds(690, 480, 20, 20);

        settingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/support.png"))); // NOI18N
        settingButton.setBorderPainted(false);
        settingButton.setContentAreaFilled(false);
        settingButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settingButton.setFocusable(false);
        settingButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Support big.png"))); // NOI18N
        settingButton.setVerifyInputWhenFocusTarget(false);
        settingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingButtonActionPerformed(evt);
            }
        });
        rPane.add(settingButton);
        settingButton.setBounds(1180, 0, 50, 40);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        chkbox_agree.setBackground(new java.awt.Color(74, 67, 102));
        chkbox_agree.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        chkbox_agree.setText("I agree to ");
        chkbox_agree.setBorder(null);
        chkbox_agree.setContentAreaFilled(false);
        chkbox_agree.setFocusPainted(false);
        chkbox_agree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                chkbox_agreeMouseEntered(evt);
            }
        });
        chkbox_agree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbox_agreeActionPerformed(evt);
            }
        });
        jPanel1.add(chkbox_agree);

        termsandconditionsButton.setFont(new java.awt.Font("Open Sans", 3, 18)); // NOI18N
        termsandconditionsButton.setText("the terms and conditions");
        termsandconditionsButton.setBorder(null);
        termsandconditionsButton.setBorderPainted(false);
        termsandconditionsButton.setContentAreaFilled(false);
        termsandconditionsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        termsandconditionsButton.setFocusPainted(false);
        termsandconditionsButton.setFocusable(false);
        termsandconditionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                termsandconditionsButtonActionPerformed(evt);
            }
        });
        jPanel1.add(termsandconditionsButton);

        rPane.add(jPanel1);
        jPanel1.setBounds(720, 530, 340, 40);

        lbl_signup.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lbl_signup.setForeground(new java.awt.Color(102, 102, 102));
        lbl_signup.setText("Sign Up  ");
        lbl_signup.setBorder(null);
        lbl_signup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rPane.add(lbl_signup);
        lbl_signup.setBounds(720, 60, 110, 40);

        sign_up_button.setBackground(new java.awt.Color(74, 67, 102));
        sign_up_button.setBorderPainted(false);
        sign_up_button.setContentAreaFilled(false);
        sign_up_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sign_up_button.setFocusPainted(false);
        sign_up_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_up_buttonActionPerformed(evt);
            }
        });
        rPane.add(sign_up_button);
        sign_up_button.setBounds(720, 55, 90, 50);

        login_username.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        login_username.setForeground(new java.awt.Color(17, 20, 23));
        login_username.setOpaque(false);
        login_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                login_usernameFocusLost(evt);
            }
        });
        rPane.add(login_username);
        login_username.setBounds(830, 120, 270, 35);

        login_password.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        login_password.setForeground(new java.awt.Color(17, 20, 23));
        login_password.setOpaque(false);
        rPane.add(login_password);
        login_password.setBounds(830, 500, 270, 35);

        login_lbl_username.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/username.png"))); // NOI18N
        rPane.add(login_lbl_username);
        login_lbl_username.setBounds(670, 300, 40, 40);

        login_lbl_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/unlock.png"))); // NOI18N
        rPane.add(login_lbl_password);
        login_lbl_password.setBounds(670, 350, 40, 40);

        loginPanel.setBackground(new java.awt.Color(254, 254, 254));
        loginPanel.setLayout(null);

        loginButton.setForeground(new java.awt.Color(7, 10, 13));
        loginButton.setText("Log In");
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginPanel.add(loginButton);
        loginButton.setBounds(274, 175, 72, 35);

        rPane.add(loginPanel);
        loginPanel.setBounds(760, 240, 400, 230);

        login_lbl_login.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        login_lbl_login.setForeground(new java.awt.Color(48, 52, 57));
        login_lbl_login.setText("Log In");
        rPane.add(login_lbl_login);
        login_lbl_login.setBounds(760, 110, 60, 26);

        img_loader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ring.gif"))); // NOI18N
        rPane.add(img_loader);
        img_loader.setBounds(890, 290, 137, 142);

        getContentPane().add(rPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* public void getDate() {

     Calendar cal = new GregorianCalendar();
     int month = cal.get(Calendar.MONTH);
     int year = cal.get(Calendar.YEAR);
     int day = cal.get(Calendar.DAY_OF_MONTH);

     menu_date.setText((month + 1) + "/" + day + "/" + year);

     int second = cal.get(Calendar.SECOND);
     int zeroMinute = 0;
     int minute = cal.get(Calendar.MINUTE);
     int hour = cal.get(Calendar.HOUR);

     if (minute < 10) {
     menu_time.setText(hour + ":" + zeroMinute + (minute) + ":" + second);
     } else {
     menu_time.setText(hour + ":" + (minute) + ":" + second);
     }

     }
     */
    private void modifyThis() {
        setTitle("DentaCare Alpha");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/teethManager.png")));
        setResizable(false);
        setLocationRelativeTo(null);
        chkbox_agree.setEnabled(false);
        pack();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    }

    final void checkNotNullToShowTerms() {
        if (txt_name != null && txt_username != null && txt_password != null && txt_email != null) {
            if (!txt_name.getText().equalsIgnoreCase("Enter your full name") && !txt_username.getText().equalsIgnoreCase("Enter your username")
                    && !txt_email.getText().equalsIgnoreCase("Your email here") && !Arrays.toString(txt_password.getPassword()).equalsIgnoreCase("Your password here")) {

            }
        }

    }

    final void enableChkBox() {

        checkNotNullToShowTerms();

        String pass = String.valueOf(txt_password.getPassword()).trim();
        int pass_length = pass.length();
        String email_valid = txt_email.getText().trim();

        String emailtoLowerCase = email_valid.toLowerCase();
        if (!txt_name.getText().equals(empty) && !txt_username.getText().equals(empty) && !txt_email.getText().equals(empty) && txt_password.getPassword().length != 0
                && !txt_name.getText().equalsIgnoreCase("Enter your name here") || !txt_name.getText().equalsIgnoreCase("Please re-enter your full name") && !txt_username.getText().equalsIgnoreCase("Enter your username") && !String.valueOf(txt_password.getPassword()).equalsIgnoreCase("Password here")
                && !txt_email.getText().equalsIgnoreCase("Your email here")) {
            if (pass_length > 7 && pass_length < 21) {

                if (email_valid.contains("@") && emailtoLowerCase.contains(".com") && emailtoLowerCase.contains("gmail") || emailtoLowerCase.contains("yahoo")) {
                    chkbox_agree.setEnabled(true);
                    chkbox_agree.setForeground(Color.WHITE);
                } else {
                    chkbox_agree.setEnabled(false);
                    chkbox_agree.setSelected(false);
                }
            }
        }

    }
    private void txt_emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emailFocusGained
        // TODO add your handling code here:
        if (txt_email.getText().trim().equalsIgnoreCase("Your email here")) {
            txt_email.setText("");
        }
        if (txt_email.getText() != null) {
            lbl_null_email.setVisible(false);
        }

    }//GEN-LAST:event_txt_emailFocusGained

    private void txt_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nameMouseClicked
        // TODO add your handling code here:
        if (txt_name.getText().trim().equalsIgnoreCase("Enter your full name")) {
            txt_name.setText("");
        }
        if (txt_name.getText().trim().equalsIgnoreCase("Please re-enter your full name")) {
            txt_name.setText("");
        }


    }//GEN-LAST:event_txt_nameMouseClicked

    private void txt_usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_usernameMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_txt_usernameMouseClicked

    private void txt_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_passwordMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_passwordMouseClicked

    private void txt_emailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_emailMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_emailMouseClicked

    private void txt_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nameFocusGained
        // TODO add your handling code here:

        if (txt_name.getText() != null) {
            lbl_null_name.setVisible(false);
        }

    }//GEN-LAST:event_txt_nameFocusGained

    private void txt_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusGained
        // TODO add your handling code here:
        if (txt_username.getText().trim().equalsIgnoreCase("Enter your username")) {
            txt_username.setText("");
        }
        if (txt_username.getText() != null) {
            lbl_null_username.setVisible(false);
        } else {
            txt_username.setText("");
        }


    }//GEN-LAST:event_txt_usernameFocusGained

    private void txt_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passwordFocusGained
        // TODO add your handling code here:
        if (String.valueOf(txt_password.getPassword()).trim().equalsIgnoreCase("Password here")) {
            txt_password.setText("");
        }
        if (txt_password.getPassword() != null) {
            lbl_null_password.setVisible(false);
        }
    }//GEN-LAST:event_txt_passwordFocusGained

    private void txt_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nameFocusLost
        // TODO add your handling code here:
        if (txt_name.getText().equals(empty)) {
            lbl_null_name.setVisible(true);
            // optional -ROY // txt_name.setText("Enter your full name");
        }

    }//GEN-LAST:event_txt_nameFocusLost

    private void signup_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_buttonActionPerformed
        // TODO add your handling code here:

        //FELLOW DEVS, F
        String pass = String.valueOf(txt_password.getPassword()).trim();
        int pass_length = pass.length();
        String email_valid = txt_email.getText().trim();
        String emailtoLowerCase = email_valid.toLowerCase();
        String sql = "INSERT INTO `registertbl`(`Full Name`, `Username`, `Password`, `Email`) VALUES (?,?,?,?)";
        //String check = "SELECT `Username`, `Email` FROM `registertbl` WHERE `Username` = '" + txt_username.getText() + "'";
        /*String check = "SELECT `Username`, `Email` FROM `registertbl` WHERE `Username`= ? and `Email` = ?"; */

        int counter = 1;

        try {

            for (int c = 0; c < counter; c++) {

                if (chkbox_agree.isSelected() && !txt_name.getText().equals(empty) && !txt_username.getText().equals(empty) && !txt_email.getText().equals(empty) && txt_password.getPassword().length != 0
                        && !txt_name.getText().equalsIgnoreCase("Enter your name here") && !txt_username.getText().equalsIgnoreCase("Enter your username") && !String.valueOf(txt_password.getPassword()).equalsIgnoreCase("Password here")
                        && !txt_email.getText().equalsIgnoreCase("Your email here")) {

                    //check for password validity
                    if (pass_length > 7 && pass_length < 21) {
                        boolean pass_legit = true;
                        if (email_valid.contains("@") && emailtoLowerCase.contains(".com") && emailtoLowerCase.contains("gmail") || emailtoLowerCase.contains("yahoo")) {
                            boolean email_legit = true;
                            String user = txt_username.getText().trim();
                            String email = txt_email.getText().trim();

                            String verify = "SELECT `Username`, `Email` FROM `registertbl` WHERE `Username` = '" + user + "' or `Email` = '" + email + "' ";
                            rs = st.executeQuery(verify);
                            int count = 0;
                            while (rs.next()) {
                                count += 1;
                            }
                            if (count == 1) {
                                Object[] options = {"Take me to the Log-in Page",
                                    "Cancel"};
                                int userOption = JOptionPane.showOptionDialog(null, "It appears that you are trying to sign-up with an existing account.",
                                        "Unable to Sign You Up",
                                        JOptionPane.YES_NO_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,
                                        new ImageIcon(getClass().getResource("/resources/nerd.png")),
                                        options,
                                        options[0]);
                                if (userOption == 0) {
                                    Login login = new Login();
                                    login.setVisible(true);
                                    this.dispose();
                                } else {

                                }

                            } else if (count > 1) {

                                Object[] options = {"Take me to the Log-in Page",
                                    "Cancel"};
                                int userOption = JOptionPane.showOptionDialog(null, "It appears that you are trying to sign-up with an existing account.",
                                        "Unable to Sign You Up",
                                        JOptionPane.YES_NO_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,
                                        new ImageIcon(getClass().getResource("/resources/nerd.png")),
                                        options,
                                        options[0]);
                                if (userOption == 0) {
                                    Login login = new Login();
                                    login.setVisible(true);
                                    this.dispose();
                                }

                            } else {

                                try {
                                    Thread.sleep(500);
                                    SignUp2 signUp2 = new SignUp2();
                                    signUp2.setVisible(true);
                                    this.dispose();

                                    System.out.println("Success verification 1");
                                    txtName = txt_name.getText().trim().toUpperCase().concat(",");
                                    txtUsername = txt_username.getText().trim().toLowerCase();
                                    chrPassword = txt_password.getPassword();
                                    txtPassword = String.valueOf(chrPassword);
                                    txtEmail = txt_email.getText().toLowerCase().trim();

                                    signUp2.txt_name2.setText(txtName);
                                    signUp2.txt_username2.setText(txtUsername);
                                    signUp2.txt_password2.setText(txtPassword);
                                    signUp2.txt_email2.setText(txtEmail);

                                } catch (Exception ex) {

                                }

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "That is not a valid email. Please enter a valid email", "Sign Up Failed!", JOptionPane.ERROR_MESSAGE);
                            System.out.println("checking email validity...");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Your password is not acceptable. Please try a different password", "Sign Up Failed!", JOptionPane.ERROR_MESSAGE);
                        System.out.println("checking password validity...");
                    }

                    {
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Make sure you fill-up all fields completely and agree to the terms and conditions of using this software before we process your registration", "Sign Up Failed. Please Try Again!", JOptionPane.ERROR_MESSAGE);

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {

            if (counter > 0) {
                try {

                    rs.close();
                    pst.close();

                } catch (Exception e) {

                }

            }
        }
        //pst = con.prepareStatement(check);
        // pst = con.prepareStatement(sql);
        // pst.setString(1, txt_name.getText());
        //pst.setString(2, txt_username.getText());

        /* char[] chrtempPass = txt_password.getPassword();
         String tempPass = String.valueOf(chrtempPass).trim();
         txt_password.setText(tempPass);
         */
        //for pw
        // pst.setString(3, Arrays.toString(txt_password.getPassword()));
        // pst.setString(4, txt_email.getText());
        //revise for first name needed -ROY
        //int length = txtName.length();
        //System.out.println(length);
        //checks for any duplications
        // String checkUsername = rs.getString("Username");
        //  String checkEmail = rs.getString("Email");
        // System.out.println("query executed");
        // if (rs.toString().equalsIgnoreCase(txt_username.getText())) {
        //     JOptionPane.showMessageDialog(this, "Error", "The username + checkUsername + is already taken", JFrame.ERROR);
        //    rs.close();
        //     pst.close();
        ////                        }
        /* if (checkEmail.equalsIgnoreCase("txtEmail")) {
         JOptionPane.showMessageDialog(this, "Error", "The same email has already been used. Please try again with a different email.", JFrame.ERROR);
         rs.close();
         pst.close();

         }
         if (checkUsername.equalsIgnoreCase(txtUsername) && checkEmail.equalsIgnoreCase("txtEmail")) {
         JOptionPane.showMessageDialog(this, "Error", "It seems you have already registered. Transferring you to the log-in section...", JFrame.ERROR);
         try {
         rs.close();
         pst.close();
         Thread.sleep(1000);
         this.dispose();
         Login login = new Login();
         login.setVisible(true);

         } catch (Exception ex) {
         System.out.println("wtf?!");
         }
         }
         */
        // pst.execute();\
        //v
        /*                  SignUp2 signUp2 = new SignUp2();
         signUp2.setVisible(true);
         signUp2.pack();
         this.hide();

         signUp2.txt_name2.setText(txtName);
         signUp2.txt_username2.setText(txtUsername);
         signUp2.txt_password2.setText(txtPassword);
         signUp2.txt_email2.setText(txtEmail);
         */

    }//GEN-LAST:event_signup_buttonActionPerformed

    private void jPopupMenu1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPopupMenu1MouseReleased
        // TODO add your handling code here:


    }//GEN-LAST:event_jPopupMenu1MouseReleased

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_formMouseReleased

    private void menu_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_refreshActionPerformed
        // TODO add your handling code here:
        time.currentTimeSignUp(lbl_date, lbl_time);
        revalidate();
        repaint();
        this.doLayout();
    }//GEN-LAST:event_menu_refreshActionPerformed

    private void menu_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menu_exitActionPerformed

    private void contact_fbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contact_fbActionPerformed
        // TODO add your handling code here:
        try {
            Desktop.getDesktop().browse(new URL("https://www.facebook.com/groups/473984372933874/").toURI());
        } catch (Exception e) {
        }

    }//GEN-LAST:event_contact_fbActionPerformed

    private void contact_googleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contact_googleActionPerformed
        // TODO add your handling code here:
        try {
            Desktop.getDesktop().browse(new URL("https://accounts.google.com/ServiceLogin/signinchooser?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin").toURI());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_contact_googleActionPerformed

    private void contact_twitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contact_twitterActionPerformed
        // TODO add your handling code here:
        try {
            Desktop.getDesktop().browse(new URL("https://twitter.com/").toURI());
        } catch (Exception e) {
        }

    }//GEN-LAST:event_contact_twitterActionPerformed

    private void txt_nameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nameMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_nameMouseExited

    private void txt_nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nameKeyTyped
        // TODO add your handling code here:


    }//GEN-LAST:event_txt_nameKeyTyped

    private void txt_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nameKeyPressed
        // TODO add your handling code here:

        boolean checkCapsState = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);

        if (checkCapsState == true) {
            lbl_capslock.setText("CAPS LOCK is on");
        } else {
            lbl_capslock.setText("CAPS LOCK is off");
        }


    }//GEN-LAST:event_txt_nameKeyPressed

    private void txt_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nameKeyReleased
        // TODO add your handling code here:


    }//GEN-LAST:event_txt_nameKeyReleased

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
        // TODO add your handling code here:
        String username = txt_username.getText().trim();
        int username_length = username.length();
        System.out.print(username_length);

        if (txt_username.getText().equals(empty)) {
            lbl_null_username.setVisible(true);
        } else if (!txt_username.getText().equals(empty)) {
            if (username_length >= 3) {

                String txt_username_lower = txt_username.getText().trim().toLowerCase();
                txt_username.setText(txt_username_lower);
            } else if (username_length < 3) {

            }
        }
    }//GEN-LAST:event_txt_usernameFocusLost

    private void txt_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passwordFocusLost
        // TODO add your handling code here:

        String pass = String.valueOf(txt_password.getPassword()).trim();
        int pass_length = pass.length();

        if (pass_length == 0) {

            lbl_null_password.setVisible(true);
            lbl_accepted_password.setVisible(false);
            lbl_unaccepted_password.setVisible(false);

        }
        if (pass_length > 7 && pass_length < 21) {

            lbl_accepted_password.setVisible(true);
            lbl_null_password.setVisible(false);
            lbl_unaccepted_password.setVisible(false);

        } else if (pass_length >= 21 || pass_length < 8 && pass_length > 0) {
            lbl_accepted_password.setVisible(false);
            lbl_unaccepted_password.setVisible(true);
            lbl_null_password.setVisible(false);

        }
    }//GEN-LAST:event_txt_passwordFocusLost

    private void txt_emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emailFocusLost
        // TODO add your handling code here:

        String email_valid = txt_email.getText().trim();
        String emailtoLowerCase = email_valid.toLowerCase();
        email_valid = emailtoLowerCase;
        if (txt_email.getText().equals(empty)) {
            lbl_null_email.setVisible(true);
            lbl_accepted_email.setVisible(false);
            lbl_unaccepted_email.setVisible(false);
        } else if (!txt_email.getText().equals(empty) && !txt_email.getText().equalsIgnoreCase("Your email here") && (email_valid.contains("@") && email_valid.contains(".com")
                && email_valid.contains("gmail") || email_valid.contains("yahoo"))) {

            lbl_accepted_email.setVisible(true);
            lbl_null_email.setVisible(false);
            lbl_unaccepted_email.setVisible(false);

        } else if (!email_valid.contains("@") && !email_valid.contains(".com") && !email_valid.contains("gmail") || !email_valid.contains("yahoo")) {

            lbl_accepted_email.setVisible(false);
            lbl_unaccepted_email.setVisible(true);
            lbl_null_email.setVisible(false);
        }
    }//GEN-LAST:event_txt_emailFocusLost

    private void rPaneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rPaneFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_rPaneFocusGained

    private void rPaneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rPaneKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_rPaneKeyPressed

    private void rPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rPaneMouseClicked
        // TODO add your handling code here:
        int mouseClick = evt.getClickCount();
        if (mouseClick == 10) {
            txt_name.setText("Enter your full name");
        }

    }//GEN-LAST:event_rPaneMouseClicked

    private void lPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaneMouseClicked
        // TODO add your handling code here:
        int mouseClick = evt.getClickCount();
        /* if (mouseClick == 1 && txt_name.getText().trim().equalsIgnoreCase("Enter your full name")) {
         txt_name.setText("");
         } else */
        if (mouseClick == 1 && !txt_name.getText().trim().equalsIgnoreCase("Enter your full name")) {
            String perm = txt_name.getText();
            txt_name.setText(perm);

        }

    }//GEN-LAST:event_lPaneMouseClicked

    private void txt_usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyPressed
        // TODO add your handling code here:

        boolean checkCapsState = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);

        if (checkCapsState == true) {
            lbl_capslock.setText("CAPS LOCK is on");
        } else {
            lbl_capslock.setText("CAPS LOCK is off");
        }
    }//GEN-LAST:event_txt_usernameKeyPressed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
        // TODO add your handling code here:

        boolean checkCapsState = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);

        if (checkCapsState == true) {
            lbl_capslock.setText("CAPS LOCK is on");
        } else {
            lbl_capslock.setText("CAPS LOCK is off");
        }
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void txt_emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyPressed
        // TODO add your handling code here:

        boolean checkCapsState = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);

        if (checkCapsState == true) {
            lbl_capslock.setText("CAPS LOCK is on");
        } else {
            lbl_capslock.setText("CAPS LOCK is off");
        }
    }//GEN-LAST:event_txt_emailKeyPressed

    private void rPaneMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rPaneMouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_rPaneMouseReleased

    private void lPaneMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaneMouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_lPaneMouseReleased

    private void contact_fbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contact_fbMouseEntered
        // TODO add your handling code here:


    }//GEN-LAST:event_contact_fbMouseEntered

    private void contact_fbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contact_fbMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_contact_fbMouseClicked

    private void seePasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seePasswordMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_seePasswordMouseEntered

    private void seePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seePasswordActionPerformed
        // TODO add your handling code here:
        if (seePassword.isSelected()) {
            txt_password.setEchoChar((char) 0);
        } else {
            txt_password.setEchoChar('*');
        }
    }//GEN-LAST:event_seePasswordActionPerformed

    private void menu_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_clearActionPerformed
        // TODO add your handling code here:
        txt_name.setText("");
        txt_username.setText("");
        txt_password.setText("");
        txt_email.setText("");
    }//GEN-LAST:event_menu_clearActionPerformed

    private void toggleColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleColorActionPerformed
        // TODO add your handling code here:
        if (toggleColor.isSelected()) {
            lPane.setBackground(Color.GRAY);
            rPane.setBackground(Color.BLACK);
            txt_name.setBackground(Color.BLACK);
            txt_username.setBackground(Color.BLACK);
            txt_password.setBackground(Color.BLACK);
            txt_email.setBackground(Color.BLACK);
            chkbox_agree.setBackground(Color.BLACK);
            jPanel3.setBackground(Color.WHITE);
            contactPanel.setBackground(Color.BLACK);
            jLayeredPane2.setBackground(Color.DARK_GRAY);

            //set FG
            login.setForeground(Color.WHITE);
            signup_button.setForeground(Color.BLACK);
            toggleColor.setForeground(Color.WHITE);
            lbl_date.setForeground(Color.WHITE);
            lbl_time.setForeground(Color.WHITE);

            setToggleColorIcon("/resources/default tooth.png");
            // toggleColor.setText("Default Theme");

        } else {
            //set Default BG color 
            setDefaultColors();
            // toggleColor.setText("Dark Theme");
            toggleColor.setForeground(Color.BLACK);
            setToggleColorIcon("/resources/dark tooth.png");

        }
    }//GEN-LAST:event_toggleColorActionPerformed

    private void signup_buttonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_signup_buttonFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_signup_buttonFocusLost

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_passwordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_passwordMouseEntered
        // TODO add your handling code here:
        txt_password.setToolTipText("Your password should be at least 8 characters but not exceeding 20 characters");
    }//GEN-LAST:event_txt_passwordMouseEntered

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void txt_nameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nameMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameMousePressed

    private void txt_passwordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_passwordMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordMousePressed

    private void log_in_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_in_buttonActionPerformed
        // TODO add your handling code here:

        /* Login login = new Login();
        login.setVisible(true);
        this.dispose();
         */
        log_in_button.setEnabled(false);

        login_username.setVisible(true);
        login_password.setVisible(true);
        login_lbl_username.setVisible(true);
        login_lbl_password.setVisible(true);
        loginPanel.setVisible(true);
        login_lbl_login.setVisible(true);

        lbl_null_name.setIcon(null);
        lbl_null_username.setIcon(null);
        lbl_null_password.setIcon(null);
        lbl_null_email.setIcon(null);
        lbl_accepted_password.setIcon(null);
        lbl_unaccepted_password.setIcon(null);
        lbl_accepted_email.setIcon(null);
        lbl_unaccepted_email.setIcon(null);

        AnimationClass ac = new AnimationClass();

        ac.jLabelYDown(110, 200, 5, 1, login_lbl_login);
        ac.jTextFieldYDown(120, 300, 5, 1, login_username);
        ac.jPasswordFieldYUp(500, 350, 5, 1, login_password);
        ac.jLabelXRight(670, 788, 5, 1, login_lbl_username);
        ac.jLabelXRight(670, 788, 5, 1, login_lbl_password);

        //rPane
        ac.jLabelYUp(60, -150, 5, 1, lbl_or);
        ac.jLabelYUp(50, -150, 5, 1, login);
        ac.jLabelYUp(150, -150, 5, 1, lbl_name);
        ac.jTextFieldXRight(720, 1350, 5, 2, txt_name);
        jSeparator3.setVisible(false);
        jSeparator1.setVisible(false);
        jSeparator4.setVisible(false);
        jSeparator7.setVisible(false);
        jSeparator5.setVisible(false);
        jSeparator1.setVisible(false);
        lbl_capslock.setVisible(false);
        lbl_null_name.setVisible(false);
        lbl_null_username.setVisible(false);
        lbl_null_password.setVisible(false);
        lbl_null_password.setVisible(false);
        lbl_accepted_password.setVisible(false);
        lbl_null_email.setVisible(false);
        lbl_unaccepted_password.setVisible(false);
        lbl_accepted_email.setVisible(false);
        lbl_unaccepted_email.setVisible(false);
        seePassword.setVisible(false);
        chkbox_agree.setVisible(false);
        termsandconditionsButton.setVisible(false);
        jButton3.setVisible(false);
        signup_button.setVisible(false);
        jPanel3.setVisible(false);

        //  ac.jLabelYDown(620, 800, 10, 1, lbl_contactus);
        ac.jLabelXRight(1060, 1350, 5, 1, jLabel10);
        ac.jTextFieldXRight(720, 1350, 5, 2, txt_email);
        ac.jLabelXRight(720, 1350, 5, 2, lbl_email);
        ac.jPasswordFieldXRight(720, 1350, 5, 2, txt_password);
        ac.jLabelXRight(720, 1350, 5, 2, lbl_username);
        ac.jTextFieldXRight(720, 1350, 5, 2, txt_username);
        ac.jLabelXRight(720, 1350, 5, 2, lbl_password);
        ac.jLabelXRight(800, 1350, 5, 2, passwordProtect);


    }//GEN-LAST:event_log_in_buttonActionPerformed

    private void settingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingButtonActionPerformed
        // TODO add your handling code here:
        Settings s = new Settings(SignUp.this, true);
        s.setVisible(true);


    }//GEN-LAST:event_settingButtonActionPerformed

    private void rPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rPaneMouseEntered
        // TODO add your handling code here:
        enableChkBox();
        AnimationClass ac = new AnimationClass();


    }//GEN-LAST:event_rPaneMouseEntered

    private void chkbox_agreeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkbox_agreeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_chkbox_agreeMouseEntered


    private void termsandconditionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_termsandconditionsButtonActionPerformed
        // TODO add your handling code here:

        Terms terms = new Terms(SignUp.this, true);

        terms.setLocationByPlatform(true);
        terms.pack();
        terms.setVisible(true);
        terms.setAlwaysOnTop(true);
    }//GEN-LAST:event_termsandconditionsButtonActionPerformed

    private void logoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoButtonActionPerformed
        // TODO add your handling code here:

        AnimationClass ac = new AnimationClass();


    }//GEN-LAST:event_logoButtonActionPerformed

    private void passwordProtectMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordProtectMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordProtectMouseReleased

    private void passwordProtectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordProtectMouseEntered
        // TODO add your handling code here:
        //  AnimationClass ac = new AnimationClass();
        // ac.jLabelXRight(800, 1050, 12, 2, jLabel15);

    }//GEN-LAST:event_passwordProtectMouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void sign_up_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_up_buttonActionPerformed
        // TODO add your handling code here:

        log_in_button.setEnabled(true);

        login_username.setVisible(false);
        login_password.setVisible(false);
        login_lbl_username.setVisible(false);
        login_lbl_password.setVisible(false);
        loginPanel.setVisible(false);
        login_lbl_login.setVisible(false);

        lbl_null_name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/nullfield.png")));
        lbl_null_username.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/nullfield.png")));
        lbl_null_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/nullfield.png")));
        lbl_null_email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/nullfield.png")));
        lbl_accepted_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/check.png")));
        lbl_unaccepted_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/invalid.png")));
        lbl_accepted_email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/check.png")));
        lbl_unaccepted_email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/invalid.png")));

        txt_name.setText("Enter your full name");
        txt_username.setText("Enter your username");
        txt_password.setText("Password here");
        txt_email.setText("Your email here");

        AnimationClass ac = new AnimationClass();

        //rPane
        ac.jLabelYDown(-150, 60, 5, 1, lbl_or);
        ac.jLabelYDown(-150, 50, 5, 1, login);
        ac.jLabelYDown(-150, 150, 5, 1, lbl_name);
        ac.jLabelYUp(800, 620, 10, 1, lbl_contactus);
        ac.jLabelXLeft(1350, 1060, 5, 1, jLabel10);
        ac.jLabelXLeft(1350, 720, 5, 2, lbl_email);
        ac.jLabelXLeft(1350, 720, 5, 2, lbl_username);
        ac.jLabelXLeft(1350, 720, 5, 2, lbl_password);
        ac.jLabelXLeft(1350, 800, 5, 2, passwordProtect);

        ac.jTextFieldXLeft(1350, 720, 5, 2, txt_name);
        ac.jTextFieldXLeft(1350, 720, 5, 2, txt_email);
        ac.jPasswordFieldXLeft(1350, 720, 5, 2, txt_password);
        ac.jTextFieldXLeft(1350, 720, 5, 2, txt_username);

        try {
            Thread.sleep(300);
        } catch (Exception ex) {

        }

        jSeparator3.setVisible(true);
        jSeparator1.setVisible(true);
        jSeparator4.setVisible(true);
        jSeparator7.setVisible(true);
        jSeparator5.setVisible(true);
        jSeparator1.setVisible(true);
        lbl_capslock.setVisible(true);
        lbl_null_name.setVisible(false);
        lbl_null_username.setVisible(false);
        lbl_null_password.setVisible(false);
        lbl_null_password.setVisible(false);
        lbl_accepted_password.setVisible(false);
        lbl_null_email.setVisible(false);
        lbl_unaccepted_password.setVisible(false);
        lbl_accepted_email.setVisible(false);
        lbl_unaccepted_email.setVisible(false);
        seePassword.setVisible(true);
        chkbox_agree.setVisible(true);
        termsandconditionsButton.setVisible(true);
        jButton3.setVisible(true);
        signup_button.setVisible(true);
        jPanel3.setVisible(true);


    }//GEN-LAST:event_sign_up_buttonActionPerformed

    @SuppressWarnings("empty-statement")
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:

        //codes and algorithm by Roy
        final String username = login_username.getText();
        final char[] charpassword = login_password.getPassword();
        final String password = String.valueOf(charpassword);
        if (login_username != null && !login_username.getText().equals(empty)) {
            if (login_password != null && !password.equals(empty)) {
                startTimer(4, img_loader);
            }
        }
        hideLoginStuff();
        if (countTimer == 0) {
            validation();
        }

    }//GEN-LAST:event_loginButtonActionPerformed

    private void login_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_login_usernameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_login_usernameFocusLost

    private void chkbox_agreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbox_agreeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkbox_agreeActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int options = JOptionPane.showConfirmDialog(SignUp.this, "Leaving so soon?", ":(", YES_NO_OPTION, HEIGHT, new ImageIcon(getClass().getResource("/resources/nerd.png")));
        if (options == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {

        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignUp.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SignUp.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SignUp.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SignUp.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JCheckBox chkbox_agree;
    private javax.swing.JPanel contactPanel;
    private javax.swing.JButton contact_fb;
    private javax.swing.JButton contact_google;
    private javax.swing.JButton contact_twitter;
    private javax.swing.JLabel img_loader;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JPanel lPane;
    private javax.swing.JLabel lbl_accepted_email;
    private javax.swing.JLabel lbl_accepted_password;
    private javax.swing.JLabel lbl_capslock;
    private javax.swing.JLabel lbl_contactus;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_null_email;
    private javax.swing.JLabel lbl_null_name;
    private javax.swing.JLabel lbl_null_password;
    private javax.swing.JLabel lbl_null_username;
    private javax.swing.JLabel lbl_or;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_signup;
    private javax.swing.JLabel lbl_time;
    private javax.swing.JLabel lbl_unaccepted_email;
    private javax.swing.JLabel lbl_unaccepted_password;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JButton log_in_button;
    private javax.swing.JLabel login;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel login_lbl_login;
    private javax.swing.JLabel login_lbl_password;
    private javax.swing.JLabel login_lbl_username;
    private javax.swing.JPasswordField login_password;
    private javax.swing.JTextField login_username;
    private javax.swing.JButton logoButton;
    private javax.swing.JMenuItem menu_clear;
    private javax.swing.JMenuItem menu_exit;
    private javax.swing.JMenuItem menu_refresh;
    private javax.swing.JLabel passwordProtect;
    private javax.swing.JPanel rPane;
    private javax.swing.JCheckBox seePassword;
    private javax.swing.JButton settingButton;
    private javax.swing.JButton sign_up_button;
    private javax.swing.JButton signup_button;
    public javax.swing.JButton termsandconditionsButton;
    private javax.swing.JToggleButton toggleColor;
    public javax.swing.JTextField txt_email;
    public javax.swing.JTextField txt_name;
    public javax.swing.JPasswordField txt_password;
    public javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

}
