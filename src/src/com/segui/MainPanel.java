package com.segui;

import javax.swing.*;

/**
 * Created by cristi on 08.05.2017.
 */
public class MainPanel {
    private JButton urlInputButton;
    private JButton saveButton;
    private JButton exportButton;
    private JButton convertButton;
    private JButton previewButton;
    private JTextArea textArea1;
    private JButton optionsButton;
    public  JPanel contentPane;

    public MainPanel() {
        contentPane = new JPanel();

        urlInputButton = new JButton("Url input");
        saveButton = new JButton("Save");
        exportButton = new JButton("Export");
        convertButton = new JButton("Convert");
        previewButton = new JButton("Preview");
        optionsButton = new JButton("Advanced options");
        textArea1 = new JTextArea(80, 80);
        
        contentPane.add(urlInputButton);
        contentPane.add(saveButton);
        contentPane.add(exportButton);
        contentPane.add(convertButton);
        contentPane.add(previewButton);
        contentPane.add(textArea1);
        contentPane.add(optionsButton);
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame("XWiki converter");
        MainPanel jp = new MainPanel();

        jf.setContentPane(jp.getContentPane());
        jf.setVisible(true);
    }
}
