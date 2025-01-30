package com.xtracise;

import com.formdev.flatlaf.FlatClientProperties;
import com.xtracise.models.Exercici;
import com.xtracise.models.Usuari;
import com.xtracise.models.Workout;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CreateWorkoutDialog extends javax.swing.JDialog {
    private Usuari user;
    private boolean successful = false;
    private JList<Exercici> jlExercicis;
    private JTextField jtfDate;
    private JButton jbSave;

    public CreateWorkoutDialog(java.awt.Frame parent, boolean modal, Usuari user) {
        super(parent, modal);
        this.user = user;
        initComponents();
        setupData();
    }

    private void initComponents() {
        setLayout(new MigLayout("fill,insets 20", "[grow]", "[][grow][]"));
        
        JPanel header = new JPanel(new MigLayout("insets 0", "[][grow]", ""));
        header.add(new JLabel("Date:"));
        jtfDate = new JTextField();
        jtfDate.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "YYYY-MM-DD");
        header.add(jtfDate, "w 150!");
        add(header, "growx, wrap");
        
        jlExercicis = new JList<>();
        JScrollPane scrollPane = new JScrollPane(jlExercicis);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Select Exercises"));
        add(scrollPane, "grow, wrap");
        
        JPanel footer = new JPanel(new MigLayout("insets 0", "push[]", ""));
        jbSave = new JButton("Save Workout");
        jbSave.setBackground(new Color(56, 142, 60));
        jbSave.setForeground(Color.WHITE);
        jbSave.setFocusPainted(false);
        footer.add(jbSave);
        add(footer, "growx");
        
        jbSave.addActionListener(this::jbSaveActionPerformed);
        setMinimumSize(new Dimension(500, 400));
        pack();
    }

    private void setupData() {
        jtfDate.setText(java.time.LocalDate.now().toString());
        DefaultListModel<Exercici> model = new DefaultListModel<>();
        DataAccess.getAllExercicis().forEach(model::addElement);
        jlExercicis.setModel(model);
    }

    private void jbSaveActionPerformed(java.awt.event.ActionEvent evt) {
        if (jlExercicis.getSelectedValuesList().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select at least one exercise", 
                "No Exercises Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Workout workout = new Workout();
            workout.setForDate(jtfDate.getText());
            workout.setIdUsuari(user.getId());
            ArrayList<Exercici> selected = new ArrayList<>(jlExercicis.getSelectedValuesList());
            DataAccess.insertWorkout(workout, selected);
            successful = true;
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Save Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean isSuccessful() { return successful; }
}
