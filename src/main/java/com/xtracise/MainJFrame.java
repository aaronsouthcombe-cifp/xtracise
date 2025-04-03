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
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.BorderFactory;

import net.miginfocom.swing.MigLayout;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class provides the main JFrame for the corporate XTRACISE application,
 * facilitating user login, workout management, and interface rendering.
 *
 * @author aaron
 */
public class MainJFrame extends javax.swing.JFrame {

    /** The model representing the list of users. */
    private DefaultListModel<Usuari> userListModel;
    /** The model representing the table of workouts. */
    private DefaultTableModel workoutTableModel;
    /** The currently logged-in user. */
    private Usuari currentUser;
    /** The model used to hold exercise data. */
    private DefaultListModel<Exercici> exercicisModel;
    /** Flag indicating login status. */
    private boolean isLoggedIn = false;
    
    /**
     * Creates new form NewJFrame, sets up various UI components and initializes the application.
     */
    public MainJFrame() {
        initComponents();
        try {
            ImageIcon icon = new ImageIcon("src/main/resources/gym.jpg");
            Image image = icon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH); // Using fixed size since component size might not be set yet
            jlCompanyLogo.setIcon(new ImageIcon(image));
            jlCompanyLogo.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        jlCompanyWebsite.setText("<html><a href='http://xtracise.example.com'>Xtracise</a></html>");
        jlCompanyWebsite.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jlCompanyWebsite.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               try {
                   Desktop.getDesktop().browse(new URI("http://xtracise.example.com"));
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
           }
        });
        setupModels();
        setupExercisesList();
        jspSplitPane.setVisible(false);
        jbCreateWorkout.setVisible(false);
        jScrollPane2.setVisible(false);
        jbEditWorkout.setVisible(false);
        jbDeleteWorkout.setVisible(false);
    }

    /**
     * Auto-generated method for initializing UI components. No modifications
     * should be made to preserve runtime behavior.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
            
        jlCompanyLogo = new JLabel();
        jlCompanyWebsite = new JLabel();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new MigLayout("fill,insets 20 20 20 20", "[grow]", "[][grow][]"));

        // Header with logo and title
        JPanel header = new JPanel(new MigLayout("insets 0", "[][grow]", ""));
        header.setOpaque(true);
        header.setBackground(new Color(245, 245, 245));

        jlCompanyLogo.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 20));
        header.add(jlCompanyLogo);

        JLabel title = new JLabel("XTRACISE WORKOUT MANAGER");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(new Color(33, 150, 243));
        header.add(title, "wrap");

        JLabel subtitle = new JLabel("Professional Fitness Management System");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitle.setForeground(new Color(117, 117, 117));
        header.add(subtitle, "gapbottom 20");

        add(header, "growx, wrap");


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new MigLayout("fill,insets 20", "[grow]", "[][grow][]"));
        
        title.setFont(title.getFont().deriveFont(Font.BOLD, 20));
        header.add(title, "gapbottom 20");
        add(header, "wrap");
        
        jspSplitPane = new JSplitPane();
        jlUsers = new JList<>();
        JScrollPane userScroll = new JScrollPane(jlUsers);
        userScroll.setBorder(BorderFactory.createTitledBorder("Clients"));
        
        jTable1 = new JTable();
        JScrollPane workoutScroll = new JScrollPane(jTable1);
        workoutScroll.setBorder(BorderFactory.createTitledBorder("Workouts"));
        
        jspSplitPane.setLeftComponent(userScroll);
        jspSplitPane.setRightComponent(workoutScroll);
        add(jspSplitPane, "grow, wrap");
        
        JPanel controls = new JPanel(new MigLayout("insets 0", "[][][][]", ""));
        jbLogin = createButton("Login", new Color(63, 81, 181));
        jbLogin.addActionListener(this::jbLoginActionPerformed);
        jbCreateWorkout = createButton("Create", new Color(56, 142, 60));
        jbCreateWorkout.addActionListener(this::jbCreateWorkoutActionPerformed);
        jbEditWorkout = createButton("Edit", new Color(255, 167, 38));
        jbEditWorkout.addActionListener(this::jbEditWorkoutActionPerformed);
        jbDeleteWorkout = createButton("Delete", new Color(229, 57, 53));
        jbDeleteWorkout.addActionListener(this::jbDeleteWorkoutActionPerformed);
        
        controls.add(jbLogin);
        controls.add(jbCreateWorkout);
        controls.add(jbEditWorkout);
        controls.add(jbDeleteWorkout);
        add(controls, "growx, wrap");
        
        jScrollPane2 = new JScrollPane();
        jlWorkoutExercises = new JList<>();
        jScrollPane2.setViewportView(jlWorkoutExercises);
        jScrollPane2.setBorder(BorderFactory.createTitledBorder("Exercises"));
        add(jScrollPane2, "h 200!, growx");
        
        setMinimumSize(new Dimension(800, 600));
        pack();
    } 
    // </editor-fold>                        

    /**
     * Creates a button with the specified text and background color.
     *
     * @param text The label for the button.
     * @param bg   The background color of the button.
     * @return     A configured JButton.
     */
    private JButton createButton(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(100, 35));
        return btn;
    }
    
    /**
     * Sets up the data models for both the user list and workouts table,
     * and configures selection listeners.
     */
    private void setupModels() {
        userListModel = new DefaultListModel<>();
        jlUsers.setModel(userListModel);
        
        workoutTableModel = new DefaultTableModel(
            new String[]{"ID", "Date", "Exercises", "Comments"}, 0) {
                public boolean isCellEditable(int row, int column) { return false; }
            };
        jTable1.setModel(workoutTableModel);
        jTable1.getColumnModel().removeColumn(jTable1.getColumnModel().getColumn(0));
        jlUsers.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Usuari selected = jlUsers.getSelectedValue();
                if (selected != null) loadWorkoutsForUser(selected);
            }
        });
    }

    /**
     * Toggles visibility of the main split pane, the exercises pane, and
     * the workout control buttons.
     *
     * @param visible true if components should be shown; false otherwise.
     */
    private void toggleVisibility(boolean visible) {
        jspSplitPane.setVisible(visible);
        jScrollPane2.setVisible(visible);
        jbCreateWorkout.setVisible(visible);
        jbEditWorkout.setVisible(visible);
        jbDeleteWorkout.setVisible(visible);
    }

    /**
     * Loads the users supervised by the current instructor (if any) into the user list model.
     */
    private void loadUsersForInstructor() {
        userListModel.clear();
        DataAccess.getAllUsersByInstructor(currentUser.getId()).forEach(userListModel::addElement);
    }

    /**
     * Loads all workouts associated with the specified user into the workouts table.
     *
     * @param user The user whose workouts are to be displayed.
     */
    private void loadWorkoutsForUser(Usuari user) {
        workoutTableModel.setRowCount(0);
        DataAccess.getWorkoutsPerUser(user).forEach(workout -> {
            ArrayList<Exercici> exercises = DataAccess.getExercicisPerWorkout(workout);
            workoutTableModel.addRow(new Object[]{
                workout.getId(),
                workout.getForDate(),
                exercises.size() + " exercises",
                workout.getComments()
            });
        });
    }    
    
    /**
     * Handles login and logout button clicks. If not logged in, displays the login dialog.
     * Upon successful login, loads relevant data. If logged in, performs logout.
     *
     * @param evt The event triggered by the button click.
     */
    private void jbLoginActionPerformed(java.awt.event.ActionEvent evt) {
        if (!isLoggedIn) {
            LoginDialog loginDialog = new LoginDialog(this, true);
            loginDialog.setVisible(true);

            if (loginDialog.isSuccessful()) {
                currentUser = loginDialog.getLoggedInUser();
                isLoggedIn = true;
                if (currentUser.isInstructor()) {
                    loadUsersForInstructor();
                    toggleVisibility(true);
                }
                jbLogin.setText("Logout");
                JOptionPane.showMessageDialog(this, 
                    "Welcome, " + currentUser.getNom() + "!", 
                    "Login Success", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            currentUser = null;
            isLoggedIn = false;
            toggleVisibility(false);
            workoutTableModel.setRowCount(0);
            exercicisModel.clear();
            jbLogin.setText("Login");
        }
    }

    /**
     * Event handler for creating a new workout. Displays a dialog for the selected user.
     *
     * @param evt The event triggered by clicking the create button.
     */
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

    /**
     * Event handler for editing an existing workout. Internally deletes and recreates it for demonstration.
     *
     * @param evt The event triggered by clicking the edit button.
     */
    private void jbEditWorkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditWorkoutActionPerformed
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            int workoutId = (Integer) workoutTableModel.getValueAt(row, 0);
            Usuari selectedUser = jlUsers.getSelectedValue();

            DataAccess.getWorkoutsPerUser(selectedUser).stream()
                .filter(w -> w.getId() == workoutId)
                .findFirst()
                .ifPresent(w -> {
                try {
                    DataAccess.deleteWorkout(w.getId());
                } catch (SQLException ex) {
                    Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

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

    /**
     * Event handler for deleting an existing workout from the database.
     *
     * @param evt The event triggered by clicking the delete button.
     */
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
                    try {
                        DataAccess.deleteWorkout(w.getId());
                    } catch (SQLException ex) {
                        Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
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

    /**
     * Configures the exercise list model and adds listeners to synchronize with the workout selection.
     */
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

    /**
     * Displays the exercises tied to a specific workout row in the exercise list component.
     *
     * @param selectedRow The selected row index in the workouts table.
     */
    private void showExercisesForWorkout(int selectedRow) {
        exercicisModel.clear();
        if(selectedRow >= 0) {
            int workoutId = (Integer) workoutTableModel.getValueAt(selectedRow, 0);  // Get from first column
            Workout workout = new Workout();
            workout.setId(workoutId);

            ArrayList<Exercici> exercicis = DataAccess.getExercicisPerWorkout(workout);
            exercicis.forEach(exercicisModel::addElement);
        }
    }

    /**
     * The main entry point which applies the FlatIntelliJLaf look and feel and displays this JFrame.
     *
     * @param args the command line arguments.
     */
    public static void main(String args[]) {
        FlatIntelliJLaf.setup();
        EventQueue.invokeLater(() -> new MainJFrame().setVisible(true));
    }

    // Variables declaration - do not modify                     
    /** Scroll pane to display the exercises for the selected workout. */
    private javax.swing.JScrollPane jScrollPane2;
    /** Table that displays the workouts for a user. */
    private javax.swing.JTable jTable1;
    /** Button to create a new workout. */
    private javax.swing.JButton jbCreateWorkout;
    /** Button to delete an existing workout. */
    private javax.swing.JButton jbDeleteWorkout;
    /** Button to edit an existing workout. */
    private javax.swing.JButton jbEditWorkout;
    /** Button to manage user login/logout. */
    private javax.swing.JButton jbLogin;
    /** Label to display the company's logo. */
    private javax.swing.JLabel jlCompanyLogo;
    /** Label to display the company's website link. */
    private javax.swing.JLabel jlCompanyWebsite;
    /** List component holding the clients or users. */
    private javax.swing.JList<Usuari> jlUsers;
    /** List component showing exercises within the selected workout. */
    private javax.swing.JList<Exercici> jlWorkoutExercises;
    /** The split pane dividing the user list and the workout table. */
    private javax.swing.JSplitPane jspSplitPane;
    // End of variables declaration                   
}
