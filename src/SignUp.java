/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dentalsoftwareapp;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.sql.*;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerdb", "root", "");
            st = con.createStatement();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
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
        signIn_color = signIn.getForeground();
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
        signIn.setForeground(signIn_color);
        signup_button.setForeground(signup_button_color);
        lbl_date.setForeground(lbl_date_color);
        lbl_time.setForeground(lbl_time_color);

    }

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
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        lbl_date = new javax.swing.JLabel();
        lbl_time = new javax.swing.JLabel();
        seePassword = new javax.swing.JCheckBox();
        signIn = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        txt_email = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        chkbox_agree = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        signup_button = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_null_name = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
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
        jLabel16 = new javax.swing.JLabel();
        sign_in_button = new javax.swing.JButton();
        lbl_accepted_email = new javax.swing.JLabel();
        lbl_unaccepted_email = new javax.swing.JLabel();
        settingButton = new javax.swing.JButton();

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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rPane.setBackground(new java.awt.Color(0, 204, 255));
        rPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rPaneMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rPaneMouseReleased(evt);
            }
        });
        rPane.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rPaneFocusGained(evt);
            }
        });
        rPane.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rPaneKeyPressed(evt);
            }
        });
        rPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lPane.setBackground(new java.awt.Color(0, 102, 102));
        lPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lPaneMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lPaneMouseReleased(evt);
            }
        });
        lPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 2, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 255));
        jLabel3.setText("Alpha");
        lPane.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 50, 30));

        jSeparator2.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lPane.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 630, 10));

        jSeparator6.setBackground(new java.awt.Color(36, 47, 65));
        jSeparator6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lPane.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 570, 20));

        jLabel11.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("<LOGO HERE> ");
        lPane.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, -1, 120));

        jLabel9.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("A dentist gets to the root of the problem");
        lPane.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 50));

        jLabel6.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Keep track of your patients with ");
        lPane.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 420, 50));

        jLabel14.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("DentaCare");
        lPane.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 150, 50));

        jLayeredPane2.setBackground(new java.awt.Color(0, 204, 204));
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

        lPane.add(jLayeredPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 50));

        rPane.add(lPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 780));

        seePassword.setBorder(null);
        seePassword.setContentAreaFilled(false);
        seePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seePassword.setFocusable(false);
        seePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/antieye.png"))); // NOI18N
        seePassword.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/eye.png"))); // NOI18N
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
        rPane.add(seePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 380, 40, -1));

        signIn.setBackground(new java.awt.Color(204, 204, 204));
        signIn.setFont(new java.awt.Font("Constantia", 2, 24)); // NOI18N
        signIn.setForeground(new java.awt.Color(51, 51, 51));
        signIn.setText("Sign in");
        signIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rPane.add(signIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 50, 80, 70));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("FULL NAME");
        rPane.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 80, 40));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("PASSWORD");
        rPane.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, 80, 40));
        rPane.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 570, 140, 10));
        rPane.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 230, 470, 10));
        rPane.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, 470, 10));
        rPane.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 410, 470, 10));

        txt_email.setBackground(new java.awt.Color(0, 204, 255));
        txt_email.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setText("Your email here");
        txt_email.setBorder(null);
        txt_email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_emailMouseClicked(evt);
            }
        });
        txt_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emailFocusLost(evt);
            }
        });
        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_emailKeyPressed(evt);
            }
        });
        rPane.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 470, 470, 30));

        txt_name.setBackground(new java.awt.Color(0, 204, 255));
        txt_name.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        txt_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_name.setText("Enter your full name");
        txt_name.setBorder(null);
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
        txt_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nameFocusLost(evt);
            }
        });
        txt_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nameKeyTyped(evt);
            }
        });
        rPane.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, 470, 30));

        txt_username.setBackground(new java.awt.Color(0, 204, 255));
        txt_username.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        txt_username.setForeground(new java.awt.Color(255, 255, 255));
        txt_username.setText("Enter your username ");
        txt_username.setToolTipText("a valid username should only contain small characters");
        txt_username.setBorder(null);
        txt_username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_usernameMouseClicked(evt);
            }
        });
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usernameKeyPressed(evt);
            }
        });
        rPane.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, 470, 30));

        txt_password.setBackground(new java.awt.Color(0, 204, 255));
        txt_password.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setText("Password here");
        txt_password.setBorder(null);
        txt_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_passwordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_passwordMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_passwordMousePressed(evt);
            }
        });
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        txt_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_passwordFocusLost(evt);
            }
        });
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });
        rPane.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 380, 430, 30));

        chkbox_agree.setBackground(new java.awt.Color(0, 204, 255));
        chkbox_agree.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        chkbox_agree.setForeground(new java.awt.Color(255, 255, 255));
        chkbox_agree.setText("I agree to the terms and conditions");
        chkbox_agree.setBorder(null);
        chkbox_agree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbox_agreeActionPerformed(evt);
            }
        });
        rPane.add(chkbox_agree, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 540, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signup_button.setBackground(new java.awt.Color(255, 255, 255));
        signup_button.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        signup_button.setForeground(new java.awt.Color(255, 255, 255));
        signup_button.setText("Sign Up");
        signup_button.setToolTipText("");
        signup_button.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        signup_button.setBorderPainted(false);
        signup_button.setContentAreaFilled(false);
        signup_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signup_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_buttonActionPerformed(evt);
            }
        });
        signup_button.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                signup_buttonFocusLost(evt);
            }
        });
        jPanel3.add(signup_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 50));

        rPane.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 590, 210, 50));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Contact Us");
        rPane.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 620, 80, 30));
        rPane.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 500, 470, 10));

        jButton3.setBackground(new java.awt.Color(36, 47, 65));
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
        rPane.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 550, 140, 20));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Already a member?");
        rPane.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 550, 140, 20));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("USERNAME");
        rPane.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, 80, 40));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("EMAIL");
        rPane.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 420, 50, 40));

        lbl_null_name.setBackground(new java.awt.Color(36, 47, 65));
        lbl_null_name.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_null_name.setForeground(new java.awt.Color(255, 255, 255));
        lbl_null_name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/nullfield.png"))); // NOI18N
        lbl_null_name.setToolTipText("Cannot be blank");
        rPane.add(lbl_null_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 20, 20));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/security checked.png"))); // NOI18N
        jLabel15.setToolTipText("This software is highly optimized to prevent any unathorized access (eg., hackers)");
        rPane.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 340, 20, 20));

        lbl_null_username.setBackground(new java.awt.Color(36, 47, 65));
        lbl_null_username.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_null_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_null_username.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/nullfield.png"))); // NOI18N
        lbl_null_username.setToolTipText("Cannot be blank");
        rPane.add(lbl_null_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, 20, 20));

        lbl_null_password.setBackground(new java.awt.Color(36, 47, 65));
        lbl_null_password.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_null_password.setForeground(new java.awt.Color(255, 255, 255));
        lbl_null_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/nullfield.png"))); // NOI18N
        lbl_null_password.setToolTipText("Cannot be blank");
        rPane.add(lbl_null_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 390, 20, 20));

        lbl_null_email.setBackground(new java.awt.Color(36, 47, 65));
        lbl_null_email.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_null_email.setForeground(new java.awt.Color(255, 255, 255));
        lbl_null_email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/nullfield.png"))); // NOI18N
        lbl_null_email.setToolTipText("Cannot be blank");
        rPane.add(lbl_null_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 480, 20, 20));

        lbl_capslock.setBackground(new java.awt.Color(36, 47, 65));
        lbl_capslock.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lbl_capslock.setForeground(new java.awt.Color(255, 255, 255));
        lbl_capslock.setToolTipText("Cannot be blank");
        rPane.add(lbl_capslock, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 170, 140, 20));

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
        rPane.add(toggleColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 0, 40, 40));

        lbl_accepted_password.setBackground(new java.awt.Color(36, 47, 65));
        lbl_accepted_password.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_accepted_password.setForeground(new java.awt.Color(255, 255, 255));
        lbl_accepted_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/check.png"))); // NOI18N
        lbl_accepted_password.setToolTipText("Your password strength is up to our standards!");
        rPane.add(lbl_accepted_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 390, 20, 20));

        lbl_unaccepted_password.setBackground(new java.awt.Color(36, 47, 65));
        lbl_unaccepted_password.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_unaccepted_password.setForeground(new java.awt.Color(255, 255, 255));
        lbl_unaccepted_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/invalid.png"))); // NOI18N
        lbl_unaccepted_password.setToolTipText("Your password is unacceptable");
        rPane.add(lbl_unaccepted_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 390, 20, 20));

        contactPanel.setBackground(new java.awt.Color(0, 204, 255));

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

        javax.swing.GroupLayout contactPanelLayout = new javax.swing.GroupLayout(contactPanel);
        contactPanel.setLayout(contactPanelLayout);
        contactPanelLayout.setHorizontalGroup(
            contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanelLayout.createSequentialGroup()
                .addComponent(contact_fb, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contact_google, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contact_twitter, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        contactPanelLayout.setVerticalGroup(
            contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanelLayout.createSequentialGroup()
                .addComponent(contact_fb, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contactPanelLayout.createSequentialGroup()
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contact_google, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contactPanelLayout.createSequentialGroup()
                        .addComponent(contact_twitter, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        rPane.add(contactPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 650, 240, 80));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Sign Up or ");
        rPane.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 130, 40));

        sign_in_button.setBackground(new java.awt.Color(0, 204, 255));
        sign_in_button.setBorder(null);
        sign_in_button.setContentAreaFilled(false);
        sign_in_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sign_in_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_in_buttonActionPerformed(evt);
            }
        });
        rPane.add(sign_in_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, 70, 30));

        lbl_accepted_email.setBackground(new java.awt.Color(36, 47, 65));
        lbl_accepted_email.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_accepted_email.setForeground(new java.awt.Color(255, 255, 255));
        lbl_accepted_email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/check.png"))); // NOI18N
        lbl_accepted_email.setToolTipText("Your email is valid");
        rPane.add(lbl_accepted_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 480, 20, 20));

        lbl_unaccepted_email.setBackground(new java.awt.Color(36, 47, 65));
        lbl_unaccepted_email.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_unaccepted_email.setForeground(new java.awt.Color(255, 255, 255));
        lbl_unaccepted_email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/invalid.png"))); // NOI18N
        lbl_unaccepted_email.setToolTipText("This is not a valid email");
        rPane.add(lbl_unaccepted_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 480, 20, 20));

        settingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/support.png"))); // NOI18N
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
        rPane.add(settingButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 0, 40, 40));

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
        pack();
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

        //FELLOW DEVS, 
        // THIS NEEDS A LOT OF REVISE AND OPTIMISATION!! -ROY
        String pass = String.valueOf(txt_password.getPassword()).trim();
        int pass_length = pass.length();
        String email_valid = txt_email.getText().trim();
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
                        if (email_valid.contains("@") && email_valid.contains(".com") && email_valid.contains("gmail") || email_valid.contains("yahoo")) {

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
                                    txtPassword = String.valueOf(chrPassword).trim();
                                    txtEmail = txt_email.getText().trim();

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

    private void chkbox_agreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbox_agreeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkbox_agreeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
        if (txt_username.getText().equals(empty)) {
            lbl_null_username.setVisible(true);
        } else {
            String txt_username_lower = txt_username.getText().trim().toLowerCase();
            txt_username.setText(txt_username_lower);
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
            signIn.setForeground(Color.WHITE);
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

    private void sign_in_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_in_buttonActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_sign_in_buttonActionPerformed

    private void settingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_settingButtonActionPerformed

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
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JCheckBox chkbox_agree;
    private javax.swing.JPanel contactPanel;
    private javax.swing.JButton contact_fb;
    private javax.swing.JButton contact_google;
    private javax.swing.JButton contact_twitter;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
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
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_null_email;
    private javax.swing.JLabel lbl_null_name;
    private javax.swing.JLabel lbl_null_password;
    private javax.swing.JLabel lbl_null_username;
    private javax.swing.JLabel lbl_time;
    private javax.swing.JLabel lbl_unaccepted_email;
    private javax.swing.JLabel lbl_unaccepted_password;
    private javax.swing.JMenuItem menu_clear;
    private javax.swing.JMenuItem menu_exit;
    private javax.swing.JMenuItem menu_refresh;
    private javax.swing.JPanel rPane;
    private javax.swing.JCheckBox seePassword;
    private javax.swing.JButton settingButton;
    private javax.swing.JLabel signIn;
    private javax.swing.JButton sign_in_button;
    private javax.swing.JButton signup_button;
    private javax.swing.JToggleButton toggleColor;
    public javax.swing.JTextField txt_email;
    public javax.swing.JTextField txt_name;
    public javax.swing.JPasswordField txt_password;
    public javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

}
