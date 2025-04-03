package com.xtracise;

import com.xtracise.models.Usuari;
import javax.swing.JOptionPane;
import at.favre.lib.crypto.bcrypt.BCrypt;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import com.formdev.flatlaf.FlatClientProperties;
import com.xtracise.models.Usuari;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 * This class provides a dialog for user authentication within the XTRACISE system.
 * It verifies credentials against stored password hashes.
 *
 * @author aaron
 */
public class LoginDialog extends javax.swing.JDialog {

    /** The BCrypt verifyer used for password authentication. */
    private static final BCrypt.Verifyer verifyer = BCrypt.verifyer();
    /** The user object for the successfully authenticated individual. */
    private Usuari loggedInUser = null;
    /** Tracks whether the login attempt was successful. */
    private boolean successful = false;

    /**
     * Retrieves the user instance for the successfully authenticated individual.
     *
     * @return An instance of Usuari representing the logged-in user.
     */
    public Usuari getLoggedInUser() {
        return loggedInUser;
    }

    /**
     * Constructs the dialog, assigning a parent Frame and a modal setting.
     *
     * @param parent The parent frame for this dialog.
     * @param modal  Whether the dialog should be modal.
     */
    public LoginDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method initializes the form and creates the UI components.
     * It is auto-generated and should not be modified to preserve behavior.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setLayout(new MigLayout("fill,insets 20", "[grow]", "[][][][]"));

        JPanel panel = new JPanel(new MigLayout("wrap 2,fillx,insets 0", "[][grow]", "[]10[]10[]"));
        JLabel titleLabel = new JLabel("XTRACISE LOGIN");
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 18));
        panel.add(titleLabel, "span 2,align center,gapbottom 20");

        jtfEmail = new JTextField();
        jtfEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter email");
        panel.add(new JLabel("Email:"));
        panel.add(jtfEmail, "w 250!");

        jpfPassword = new JPasswordField();
        jpfPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter password");
        panel.add(new JLabel("Password:"));
        panel.add(jpfPassword, "w 250!");

        add(panel, "growx, wrap");

        jbLogin = new JButton("Login");
        jbLogin.setBackground(new Color(63, 81, 181));
        jbLogin.setForeground(Color.WHITE);
        jbLogin.setFocusPainted(false);
        jbLogin.setPreferredSize(new Dimension(120, 40));
        add(jbLogin, "align center");

        jbLogin.addActionListener(this::jbLoginActionPerformed);
        setMinimumSize(new Dimension(400, 300));
        pack();
    }
    // </editor-fold>                        

    /**
     * Determines whether the login dialog was closed after a successful login.
     *
     * @return true if the user has successfully logged in; false otherwise.
     */
    public boolean isSuccessful() {
        return successful;
    }

    /**
     * Event handler that verifies user credentials and resolves login success or failure.
     *
     * @param evt The event triggered by clicking the login button.
     */
    private void jbLoginActionPerformed(java.awt.event.ActionEvent evt) {
        String email = jtfEmail.getText();
        String password = new String(jpfPassword.getPassword());
        try {
            Usuari user = DataAccess.getUser(email);
            if (user != null && validatePassword(password, user.getPasswordHash())) {
                successful = true;
                loggedInUser = user;
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
                jpfPassword.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Validates a plain-text password against a stored bcrypt hash.
     *
     * @param password  The plain-text password to check.
     * @param passHash  The bcrypt hash stored in the system.
     * @return          true if the password matches; false otherwise.
     */
    private boolean validatePassword(String password, String passHash) {
        try {
            BCrypt.Result result = verifyer.verify(
                password.getBytes(StandardCharsets.UTF_8),
                passHash.getBytes(StandardCharsets.UTF_8)
            );
            return result.verified;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Generates a bcrypt hash from a plain-text password, intended for user registration.
     *
     * @param plainTextPassword The plain-text password to be hashed.
     * @return                  The resulting bcrypt hash string.
     */
    public static String hashPassword(String plainTextPassword) {
        return new String(
            BCrypt.withDefaults().hash(
                12,
                plainTextPassword.getBytes(StandardCharsets.UTF_8)
            ),
            StandardCharsets.UTF_8
        );
    }

    // Variables declaration - do not modify                     
    /** The login button that triggers the verification process. */
    private javax.swing.JButton jbLogin;
    /** Label for the email field (auto-generated placeholder reference). */
    private javax.swing.JLabel jlEmail;
    /** Label for the password field (auto-generated placeholder reference). */
    private javax.swing.JLabel jlPassword;
    /** The password field used to capture user credentials. */
    private javax.swing.JPasswordField jpfPassword;
    /** The email field used to capture user credentials. */
    private javax.swing.JTextField jtfEmail;
    // End of variables declaration                   
}
