/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentalApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentalApp extends JFrame {
    private String vehicleType;
    private String customerName;
    private String phoneNumber;
    private String selectedVehicle;
    private double rentalPrice;
    private int rentalDays;

    
    private JPanel panel1;
    private JButton motorButton;
    private JButton mobilButton;

   
    private JPanel panel2;
    private JTextField nameField;
    private JTextField phoneField;
    private JRadioButton[] vehicleButtons;
    private ButtonGroup vehicleGroup;
    private JTextField daysField;
    private JButton saveButton;

   
    private JPanel panel3;
    private JLabel nameLabel;
    private JLabel phoneLabel;
    private JLabel vehicleLabel;
    private JLabel daysLabel;
    private JLabel totalPriceLabel;
    private JButton finishButton;

    public RentalApp() {
        setTitle("Aplikasi Rental Kendaraan");
        setSize(380, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel1 = new JPanel(new FlowLayout());
        motorButton = new JButton("Motor");
        mobilButton = new JButton("Mobil");
        panel1.add(motorButton);
        panel1.add(mobilButton);

        panel2 = new JPanel(new GridLayout(9, 1));
        nameField = new JTextField(10);
        phoneField = new JTextField(10);
        panel2.add(new JLabel("Nama Penyewa:"));
        panel2.add(nameField);
        panel2.add(new JLabel("Nomor Telepon:"));
        panel2.add(phoneField);
        panel2.add(new JLabel("Pilih Kendaraan:"));
        vehicleButtons = new JRadioButton[3];
        vehicleGroup = new ButtonGroup();
        
        JPanel vehiclePanel = new JPanel(new FlowLayout());
        for (int i = 0; i < vehicleButtons.length; i++) {
            vehicleButtons[i] = new JRadioButton();
            vehiclePanel.add(vehicleButtons[i]);
            vehicleGroup.add(vehicleButtons[i]);
        }
        panel2.add(vehiclePanel);
        panel2.add(new JLabel("Jumlah Hari Sewa :"));
        daysField = new JTextField(5);
        panel2.add(daysField);
        saveButton = new JButton("Simpan");
        panel2.add(saveButton);

        
        panel3 = new JPanel(new GridLayout(8, 2));
        nameLabel = new JLabel();
        phoneLabel = new JLabel();
        vehicleLabel = new JLabel();
        daysLabel = new JLabel();
        totalPriceLabel = new JLabel();
        panel3.add(nameLabel);
        panel3.add(phoneLabel);
        panel3.add(vehicleLabel);
        panel3.add(daysLabel);
        panel3.add(totalPriceLabel);
        finishButton = new JButton("Selesai");
        panel3.add(finishButton);

        
        motorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vehicleType = "Motor";
                showDetailFrame();
            }
        });

        mobilButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vehicleType = "Mobil";
                showDetailFrame();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                customerName = nameField.getText();
                phoneNumber = phoneField.getText();
                for (int i = 0; i < vehicleButtons.length; i++) {
                    if (vehicleButtons[i].isSelected()) {
                        selectedVehicle = "Kendaraan " + (i + 1);
                        rentalPrice = (i + 1) * 150000; 
                        break;
                    }
                }
                rentalDays = Integer.parseInt(daysField.getText());
                showSummaryFrame();
            }
        });

        finishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });

        add(panel1);
        setVisible(true);
    }

    private void showDetailFrame() {
        getContentPane().removeAll();
        add(panel2);
        revalidate();
        repaint();
    }

    private void showSummaryFrame() {
        getContentPane().removeAll();
        nameLabel.setText("Nama Penyewa: " + customerName);
        phoneLabel.setText("Nomor Telepon: " + phoneNumber);
        vehicleLabel.setText("Jenis Kendaraan: " + selectedVehicle + ", Harga Sewa per Hari: Rp" + rentalPrice);
        daysLabel.setText("Jumlah Hari Sewa: " + rentalDays);
        totalPriceLabel.setText("Total Harga Sewa: Rp" + (rentalDays * rentalPrice));
        add(panel3);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RentalApp();
            }
        });
    }
}
    