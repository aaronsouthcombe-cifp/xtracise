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
    private DefaultListModel<Exercici> exercicisModel;
    private boolean isLoggedIn = false;
    /**
     * Creates new form NewJFrame
     */
    public MainJFrame() {
        initComponents();
        setupModels();
        setupExercisesList();
        jspSplitPane.setVisible(false);
        jbCreateWorkout.setVisible(false);
        jScrollPane2.setVisible(false);
        jbEditWorkout.setVisible(false);
        jbDeleteWorkout.setVisible(false);
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
        jbCreateWorkout = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlWorkoutExercises = new javax.swing.JList<>();
        jbEditWorkout = new javax.swing.JButton();
        jbDeleteWorkout = new javax.swing.JButton();

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

        jlUsers.setModel(new DefaultListModel<Usuari>());
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

        jbCreateWorkout.setText("Create Workout");
        jbCreateWorkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCreateWorkoutActionPerformed(evt);
            }
        });

        jlWorkoutExercises.setModel(new javax.swing.AbstractListModel<Exercici>() {
            Exercici[] exercicis = { };
            public int getSize() { return exercicis.length; }
            public Exercici getElementAt(int i) { return exercicis[i]; }
        });
        jScrollPane2.setViewportView(jlWorkoutExercises);

        jbEditWorkout.setText("Edit Workout");
        jbEditWorkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditWorkoutActionPerformed(evt);
            }
        });

        jbDeleteWorkout.setText("Delete Workout");
        jbDeleteWorkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteWorkoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 101, Short.MAX_VALUE)
                .addComponent(jspSplitPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jlCompanyLogo)
                        .addGap(18, 18, 18)
                        .addComponent(jlCompanyWebsite))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(419, 419, 419)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbEditWorkout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbCreateWorkout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbDeleteWorkout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCompanyLogo)
                    .addComponent(jlCompanyWebsite))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jspSplitPane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbLogin)
                    .addComponent(jbCreateWorkout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEditWorkout)
                    .addComponent(jbDeleteWorkout))
                .addGap(50, 50, 50))
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
        exercicisModel.clear();
        ArrayList<Workout> workouts = DataAccess.getWorkoutsPerUser(user);

        for (Workout workout : workouts) {
            ArrayList<Exercici> exercicis = DataAccess.getExercicisPerWorkout(workout);

            StringBuilder exerciseNames = new StringBuilder();
            for (int i = 0; i < exercicis.size(); i++) {
                if (i > 0) {
                    exerciseNames.append(", ");
                }
                exerciseNames.append(exercicis.get(i).getDescripcio());
            }

            workoutTableModel.addRow(new Object[] {
                workout.getForDate(),
                exercicis.size(),
                exerciseNames.toString(),
                workout.getComments()
            });
        }
    } 
    
    
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
                    jScrollPane2.setVisible(true);
                    loadUsersForInstructor();
                }
                JOptionPane.showMessageDialog(this,
                        "Login successful!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                jbLogin.setText("Logout");
                jbEditWorkout.setVisible(currentUser.isInstructor());
                jbDeleteWorkout.setVisible(currentUser.isInstructor());
                jbCreateWorkout.setVisible(currentUser.isInstructor());
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
            jScrollPane2.setVisible(false);
            isLoggedIn = false;
            jbLogin.setText("Login");
            jbCreateWorkout.setVisible(false);
            jbEditWorkout.setVisible(false);
            jbDeleteWorkout.setVisible(false);
        }
    }//GEN-LAST:event_jbLoginActionPerformed

    private void jbCreateWorkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCreateWorkoutActionPerformed
        Usuari selectedUser = jlUsers.getSelectedValue();
        if (selectedUser != null) {
            CreateWorkoutDialog dialog = new CreateWorkoutDialog(this, true, selectedUser);
            dialog.setVisible(true);

            if (dialog.isSuccessful()) {
                // Refresh the workouts table so they show up
                loadWorkoutsForUser(selectedUser);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Please select a user first",
                    "No user selected",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbCreateWorkoutActionPerformed

    // worst code i've ever written... deletes and creates in one go to "edit"
    private void jbEditWorkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditWorkoutActionPerformed
         int row = jTable1.getSelectedRow();
        if (row >= 0) {
            Usuari selectedUser = jlUsers.getSelectedValue();
            String date = (String) jTable1.getValueAt(row, 0);

            ArrayList<Workout> workouts = DataAccess.getWorkoutsPerUser(selectedUser);
            workouts.stream()
                   .filter(w -> w.getForDate().equals(date))
                   .findFirst()
                   .ifPresent(w -> {
                        // delete the old workout
                        DataAccess.deleteWorkout(w.getId());

                        // create new workout
                        CreateWorkoutDialog dialog = new CreateWorkoutDialog(this, true, selectedUser);
                        dialog.setVisible(true);

                        // magic! workout "edited"
                        loadWorkoutsForUser(selectedUser);
                   });
        } else {
            JOptionPane.showMessageDialog(this,
                "Please select a workout to edit",
                "No workout selected",
                JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbEditWorkoutActionPerformed

    private void jbDeleteWorkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteWorkoutActionPerformed
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            // add confirmation. not done in edit for obvious reasons...
            if (JOptionPane.showConfirmDialog(this, "Delete this workout?", 
                "Confirm Delete", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                Usuari selectedUser = jlUsers.getSelectedValue();
                String date = (String) jTable1.getValueAt(row, 0);
                ArrayList<Workout> workouts = DataAccess.getWorkoutsPerUser(selectedUser);

                workouts.stream()
                       .filter(w -> w.getForDate().equals(date))
                       .findFirst()
                       .ifPresent(w -> {
                            DataAccess.deleteWorkout(w.getId());
                            loadWorkoutsForUser(selectedUser);
                       });
            }
        } else {
            JOptionPane.showMessageDialog(this,
                "Please select a workout to delete",
                "No workout selected",
                JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbDeleteWorkoutActionPerformed

    
    private void setupExercisesList() {
        exercicisModel = new DefaultListModel<>();
        jlWorkoutExercises.setModel(exercicisModel);

        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow >= 0) {
                        showExercisesForWorkout(selectedRow);
                    } else {
                        exercicisModel.clear();
                    }
                }
            }
        });
    }
    
    private void showExercisesForWorkout(int selectedRow) {
        exercicisModel.clear();
        
        // Get the workout date from the selected row
        String workoutDate = (String) workoutTableModel.getValueAt(selectedRow, 0);
        
        // Get the currently selected user
        Usuari selectedUser = jlUsers.getSelectedValue();
        if (selectedUser != null) {
            // Find the matching workout
            ArrayList<Workout> workouts = DataAccess.getWorkoutsPerUser(selectedUser);
            for (Workout workout : workouts) {
                if (workout.getForDate().equals(workoutDate)) {
                    // Get and display exercises for this workout
                    ArrayList<Exercici> exercicis = DataAccess.getExercicisPerWorkout(workout);
                    for (Exercici exercici : exercicis) {
                        exercicisModel.addElement(exercici);
                    }
                    jScrollPane2.setVisible(true);
                    break;
                }
            }
        }
    }

    
    
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbCreateWorkout;
    private javax.swing.JButton jbDeleteWorkout;
    private javax.swing.JButton jbEditWorkout;
    private javax.swing.JButton jbLogin;
    private javax.swing.JLabel jlCompanyLogo;
    private javax.swing.JLabel jlCompanyWebsite;
    private javax.swing.JList<Usuari> jlUsers;
    private javax.swing.JList<Exercici> jlWorkoutExercises;
    private javax.swing.JSplitPane jspSplitPane;
    private javax.swing.JScrollPane jtWorkouts;
    // End of variables declaration//GEN-END:variables
}
