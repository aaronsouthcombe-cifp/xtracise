/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.xtracise;

import javax.swing.JOptionPane;
import com.xtracise.models.Usuari;
import com.xtracise.models.Workout;
import com.xtracise.models.Exercici;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
/**
 *
 * @author aaron
 */
public class MainJFrame extends javax.swing.JFrame {

    private DefaultListModel<Usuari> userListModel;
    private DefaultTableModel workoutTableModel;
    private Usuari currentUser;
    /**
     * Creates new form NewJFrame
     */
    public MainJFrame() {
        initComponents();
        setupModels();
        jspSplitPane.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlCompanyLogo = new javax.swing.JLabel();
        jlCompanyWebsite = new javax.swing.JLabel();
        jbLogin = new javax.swing.JButton();
        jspSplitPane = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlUsers = new javax.swing.JList<>();
        jtWorkouts = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jlCompanyLogo.setText("CompanyLogo");

        jlCompanyWebsite.setText("Website");

        jbLogin.setText("Press to login!");
        jbLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLoginActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jlUsers);

        jspSplitPane.setLeftComponent(jScrollPane1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtWorkouts.setViewportView(jTable1);

        jspSplitPane.setRightComponent(jtWorkouts);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jlCompanyLogo)
                        .addGap(18, 18, 18)
                        .addComponent(jlCompanyWebsite))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(499, 499, 499)
                        .addComponent(jbLogin)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 101, Short.MAX_VALUE)
                .addComponent(jspSplitPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(327, 327, 327))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCompanyLogo)
                    .addComponent(jlCompanyWebsite))
                .addGap(41, 41, 41)
                .addComponent(jspSplitPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(jbLogin)
                .addGap(81, 81, 81))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void setupModels() {
        // setup models for later use
        userListModel = new DefaultListModel<>();
        jlUsers.setModel(userListModel);
        
        // setup table with column headers
        workoutTableModel = new DefaultTableModel(
        new String[] {"Date", "# Exercises", "Exercises", "Comments"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable1.setModel(workoutTableModel);
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);

        // listen and show data for selected Usuari object
        jlUsers.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Usuari selectedUser = jlUsers.getSelectedValue();
                    if (selectedUser != null) {
                        loadWorkoutsForUser(selectedUser);
                    }
                }
            }
        });
    }

    private void loadUsersForInstructor() {
        userListModel.clear();
        ArrayList<Usuari> users = DataAccess.getAllUsersByInstructor(currentUser.getId());
        for (Usuari user : users) {
            userListModel.addElement(user);
        }
    }

    private void loadWorkoutsForUser(Usuari user) {
        workoutTableModel.setRowCount(0);
        ArrayList<Workout> workouts = DataAccess.getWorkoutsPerUser(user);

        for (Workout workout : workouts) {
            ArrayList<Exercici> exercicis = DataAccess.getExercicisPerWorkout(workout);

            // format exercises for table
            StringBuilder exerciseNames = new StringBuilder();
            for (int i = 0; i < exercicis.size(); i++) {
                if (i > 0) {
                    exerciseNames.append(", ");
                }
                exerciseNames.append(exercicis.get(i).getDescripcio()); // descripcio es el exercici en si
            }

            workoutTableModel.addRow(new Object[] {
                workout.getForDate(),
                exercicis.size(),
                exerciseNames.toString(),
                workout.getComments()
            });
        }
    } 
    
    
    private boolean isLoggedIn = false;
    private void jbLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLoginActionPerformed
        if (!isLoggedIn) {
            LoginDialog loginDialog = new LoginDialog(this, true);
            loginDialog.setLocationRelativeTo(this);
            loginDialog.setVisible(true);

            if (loginDialog.isSuccessful()) {
                currentUser = loginDialog.getLoggedInUser();
                isLoggedIn = true;
                if (currentUser.isInstructor()) {
                    jspSplitPane.setVisible(true);
                    loadUsersForInstructor();
                }
                JOptionPane.showMessageDialog(this,
                        "Login successful!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                jbLogin.setText("Logout");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Login failed!",
                        "Try again",
                        JOptionPane.INFORMATION_MESSAGE);
                loginDialog.setLocationRelativeTo(this);
                loginDialog.setVisible(true);
            }
        } else {
            currentUser = null;
            jspSplitPane.setVisible(false);
            userListModel.clear();
            workoutTableModel.setRowCount(0);
            isLoggedIn = false;
            jbLogin.setText("Login");
        }
    }//GEN-LAST:event_jbLoginActionPerformed

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbLogin;
    private javax.swing.JLabel jlCompanyLogo;
    private javax.swing.JLabel jlCompanyWebsite;
    private javax.swing.JList<Usuari> jlUsers;
    private javax.swing.JSplitPane jspSplitPane;
    private javax.swing.JScrollPane jtWorkouts;
    // End of variables declaration//GEN-END:variables
}
