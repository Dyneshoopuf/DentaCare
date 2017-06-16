package dentalsoftwareapp;

import java.awt.Toolkit;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Roy
 */
public class TermsAndConditions extends javax.swing.JFrame {

    /**
     * Creates new form TermsAndConditions
     */

    public TermsAndConditions() {
        initComponents();
        setTitle("Terms and Conditions");
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/teethManager.png")));
        pack();
        setLocationRelativeTo(rootPane);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jScrollPane1.setBackground(new java.awt.Color(153, 153, 153));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(153, 153, 153));
        jTextArea1.setRows(5);
        jTextArea1.setText("Terms and conditions before using this software \n\nBefore using this software, you must agree to the following statements\n\n1) Intellectual Property\nDentaCare remains and shall remain exclusively the property of its makers, \nComputer Scientist Students of AMA Computer College of Parañaque. \nSee students\n\n1.1\nTherefore, it is only just to have all the rights reserved in this software for \nthese students who were and the only ones who made this software. \n\n1.2\nSuch support from any other software developers, engineers, \nprogrammers and or other professions outside AMA Computer College\nwere not entertained/received.\nTherefore, all credits are to be directed only, and strictly only, to its \nmakers who are/were the students of AMA Computer College, Parañaque.\n\n1.3\nDentaCare was created for the sole purpose of Computer studies brought \nabout by Computer Science, Software Engineering Course. Without \nexemption, this software aims to let the students of AMA Computer College, \nParañaque build systematized programs that target dentists who would \nwant to manage their patients more efficiently.\nSee about app.\n\n1.3.1\nHence, DentaCare must be fairly used only for educational purpose and \npersonal use. \n\n1.3.2\nIn addition, DentaCare is exclusively designed only for dentists and shall \nremain strictly to its sole premises.\n\n1.4\nDistribution of DentaCare without grant, intended or unintended, is strictly\nprohibited and will resort to an absolute punishment under the Law. \n\n1.5\nEverything that is included in this software application, including logos, featres, contents, and functionality, are owned\nby the Computer Scientist Students of AMA Computer College.\n\n2) Liability \nUser/s of this software must be aware of possible consequences of using \nDentaCare for their personal use. \n\n2.1\nDentaCare was made by students who promised to help dentists through \nthis app. (See 1.3) \n\n2.1.2\nThus, any damage/s problem/s that this software may bring to its users will \nnot be directed to its makers but to the user who agreed to all propositions \nbeforehand.\n");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TermsAndConditions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TermsAndConditions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TermsAndConditions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TermsAndConditions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TermsAndConditions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
