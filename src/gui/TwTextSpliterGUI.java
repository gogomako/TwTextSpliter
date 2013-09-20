/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Mako Chang
 */
public class TwTextSpliterGUI extends javax.swing.JFrame { 
    //final private Integer split_by_lines = 0;
    //final private Integer split_by_size = 0;
    //final private String split_by_delimiter = "";
    private String output_file_name_format="%d.txt";
    JFileChooser file_chooser = new JFileChooser();
    Charset utf8 = Charset.forName("UTF-8");//defind char set
    

    /**
     * Creates new form TwTextSpliterGUI
     */
    public TwTextSpliterGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG_splitby = new javax.swing.ButtonGroup();
        LB_filepath = new javax.swing.JLabel();
        TF_file_path = new javax.swing.JTextField();
        CB_language = new javax.swing.JComboBox();
        LB_language = new javax.swing.JLabel();
        LB_splitby = new javax.swing.JLabel();
        RB_lines_per_file = new javax.swing.JRadioButton();
        RB_custom_delimiter = new javax.swing.JRadioButton();
        RB_size_per_file = new javax.swing.JRadioButton();
        TF_lines_per_file = new javax.swing.JTextField();
        TF_size_per_file = new javax.swing.JTextField();
        CB_size_per_file = new javax.swing.JComboBox();
        BT_split = new javax.swing.JButton();
        BT_browse = new javax.swing.JButton();
        TF_custom_delimiter = new javax.swing.JTextField();
        LB_input_encoding = new javax.swing.JLabel();
        CB_delete_source = new javax.swing.JCheckBox();
        LB_output_encoding = new javax.swing.JLabel();
        CB_input_encoding = new javax.swing.JComboBox();
        CB_output_encoding = new javax.swing.JComboBox();
        LB_output_filename = new javax.swing.JLabel();
        LB_output_file_path = new javax.swing.JLabel();
        TF_output_file_path = new javax.swing.JTextField();
        BT_save_as = new javax.swing.JButton();
        CB_output_file_name_format = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LB_filepath.setText("Input File Path");

        TF_file_path.setEditable(false);

        CB_language.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "English", "正體中文" }));
        CB_language.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_languageActionPerformed(evt);
            }
        });

        LB_language.setText("Language");

        LB_splitby.setText("Split By");

        BG_splitby.add(RB_lines_per_file);
        RB_lines_per_file.setText("Lines per File");
        RB_lines_per_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_lines_per_fileActionPerformed(evt);
            }
        });

        BG_splitby.add(RB_custom_delimiter);
        RB_custom_delimiter.setText("Custom Delimiter");
        RB_custom_delimiter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_custom_delimiterActionPerformed(evt);
            }
        });

        BG_splitby.add(RB_size_per_file);
        RB_size_per_file.setText("Size per File");

        TF_lines_per_file.setMaximumSize(new java.awt.Dimension(100000, 100000));
        TF_lines_per_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_lines_per_fileActionPerformed(evt);
            }
        });

        TF_size_per_file.setMaximumSize(new java.awt.Dimension(100000, 100000));

        CB_size_per_file.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "KB", "MB", "GB" }));
        CB_size_per_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_size_per_fileActionPerformed(evt);
            }
        });

        BT_split.setText("Split");
        BT_split.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_splitActionPerformed(evt);
            }
        });

        BT_browse.setText("Browse...");
        BT_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_browseActionPerformed(evt);
            }
        });

        LB_input_encoding.setText("Input Encoding");

        CB_delete_source.setText("Delete source after splited");

        LB_output_encoding.setText("Output Encoding");

        CB_input_encoding.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AUTO", "ANSI", "UTF-8" }));

        CB_output_encoding.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AUTO", "ANSI", "UTF-8" }));

        LB_output_filename.setText("Output file name");

        LB_output_file_path.setText("Output File Path");

        TF_output_file_path.setEditable(false);
        TF_output_file_path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_output_file_pathActionPerformed(evt);
            }
        });

        BT_save_as.setText("Save As...");

        CB_output_file_name_format.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1,2,3...", "01,02,03...", "0,1,2...", "00,01,02..." }));
        CB_output_file_name_format.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_output_file_name_formatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LB_filepath)
                            .addComponent(LB_output_file_path)
                            .addComponent(LB_output_filename)
                            .addComponent(LB_splitby))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RB_custom_delimiter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(TF_size_per_file, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(CB_size_per_file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(TF_custom_delimiter)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RB_lines_per_file)
                                    .addComponent(RB_size_per_file))
                                .addGap(20, 20, 20)
                                .addComponent(TF_lines_per_file, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TF_file_path, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BT_browse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TF_output_file_path, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BT_save_as, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(CB_output_file_name_format, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LB_input_encoding)
                            .addComponent(LB_output_encoding)
                            .addComponent(LB_language))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CB_language, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CB_output_encoding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CB_input_encoding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(CB_delete_source)))
                                .addGap(18, 18, 18)
                                .addComponent(BT_split, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB_filepath)
                    .addComponent(TF_file_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_browse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_output_file_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_save_as)
                    .addComponent(LB_output_file_path))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB_output_filename)
                    .addComponent(CB_output_file_name_format, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LB_splitby)
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RB_lines_per_file)
                            .addComponent(TF_lines_per_file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RB_size_per_file)
                            .addComponent(TF_size_per_file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CB_size_per_file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RB_custom_delimiter)
                            .addComponent(TF_custom_delimiter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB_input_encoding)
                    .addComponent(CB_input_encoding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB_output_encoding)
                    .addComponent(CB_output_encoding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB_language)
                    .addComponent(CB_language, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BT_split)
                    .addComponent(CB_delete_source))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CB_languageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_languageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_languageActionPerformed

    private void RB_lines_per_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_lines_per_fileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RB_lines_per_fileActionPerformed

    private void RB_custom_delimiterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_custom_delimiterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RB_custom_delimiterActionPerformed

    private void CB_size_per_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_size_per_fileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_size_per_fileActionPerformed

    private void BT_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_browseActionPerformed
        file_chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        file_chooser.setFileFilter(new TypeOfFile());
        file_chooser.setMultiSelectionEnabled(false);
        
        int rVal = file_chooser.showOpenDialog(TwTextSpliterGUI.this);
        
        if (rVal == JFileChooser.APPROVE_OPTION) {
            renew_TF_input_file_path();
            renew_TF_output_file_path();
        }
        if (rVal == JFileChooser.CANCEL_OPTION) {
            //TODO
        }
    }//GEN-LAST:event_BT_browseActionPerformed

    private void BT_splitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_splitActionPerformed
        
        File input_fd = new File(TF_file_path.getText());
        BufferedReader buf_reader;
        BufferedWriter buf_writer;
        String tmp_line;
        Integer output_file_name_index = 0;
        String output_file_name = set_output_file_name(output_file_name_format, output_file_name_index);
        
        if(RB_lines_per_file.isSelected()){
            
            /*========================== split the file by lines ==========================*/
            
            final Integer split_by_lines;
            try{
                split_by_lines = Integer.parseInt(TF_lines_per_file.getText());
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please input the lines", "Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            Integer line_counter = 0;

            try {
                buf_reader = new BufferedReader(new FileReader(input_fd));
                tmp_line = buf_reader.readLine();//read the first line from file
                
                //System.out.println("line:" + split_by_lines);//test
                
                buf_writer = new BufferedWriter( new OutputStreamWriter( 
                        new FileOutputStream(output_file_name),"UTF-8" ) );//set the output stream encoding as utf-8
 
                while(tmp_line != null){
                    
                    line_counter++;
                    //System.out.println(tmp_line);//test
                    try{
                        buf_writer.write(tmp_line);//write into output file
                        buf_writer.newLine();
                        buf_writer.flush();
                    }catch(IOException e){
                        //System.out.println("Warning: writer wrote error");
                        JOptionPane.showMessageDialog(null, "Error: an error occured when writing into file", "Warning",JOptionPane.WARNING_MESSAGE);
                    }
                    
                    if(line_counter == split_by_lines){//change to new file
                        
                        //buf_writer.close();//close the old output file
                        
                        line_counter = 0;
                        output_file_name_index++;
                        output_file_name = set_output_file_name(output_file_name_format, output_file_name_index);
                        buf_writer = new BufferedWriter( new OutputStreamWriter ( 
                                new FileOutputStream(output_file_name),"UTF-8") );
                        
                        //System.out.println("==============");//test
                        
                    }
                    
                    tmp_line = buf_reader.readLine();//read next line from file
                }
                buf_writer.close();
                buf_reader.close();
                JOptionPane.showMessageDialog(null, "File splitted successfully", "Notice",JOptionPane.WARNING_MESSAGE);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error: file not found", "Warning",JOptionPane.WARNING_MESSAGE);
                return;
            } catch (IOException ex) {
                Logger.getLogger(TwTextSpliterGUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error: unknown error occured", "Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            
        }else if(RB_size_per_file.isSelected()){
            
            /*========================== split the file by size ==========================*/
            /*
            int file_size_counter = 0;
            Integer split_by_size;//unit of split_by_size is byte
            try{
                split_by_size = Integer.parseInt(TF_size_per_file.getText());
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please input the size", "Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            split_by_size = split_by_size << 10;//KB to byte
            
            TODO
            if(unit is mb){
                split_by_size *= 1024
            }else if(unit is gb){
                split_by_size *= 1024*1024;
            }
            
            try{
                
                buf_reader = new BufferedReader(new FileReader(input_fd));
                tmp_line = buf_reader.readLine();//read the first line from file
                
                buf_writer = new BufferedWriter( new OutputStreamWriter( 
                        new FileOutputStream(output_file_name),"UTF-8" ) );//set the output stream encoding as utf-8
                
                while(tmp_line != null){
                    
                    file_size_counter += tmp_line.getBytes(utf8).length;
                    //TODO : other encoding type
                    
                    try{
                        buf_writer.write(tmp_line);//write into output file
                        buf_writer.newLine();
                        buf_writer.flush();
                    }catch(IOException e){
                        //System.out.println("Warning: writer wrote error");
                        JOptionPane.showMessageDialog(null, "Error: an error occured when writing into file", "Warning",JOptionPane.WARNING_MESSAGE);
                    }
                    
                    if(file_size_counter >= split_by_size){//change to new file
                        
                        //buf_writer.close();//close the old output file
                        
                        file_size_counter = 0;
                        output_file_name_index++;
                        output_file_name = set_output_file_name(output_file_name_format, output_file_name_index);
                        buf_writer = new BufferedWriter( new OutputStreamWriter ( 
                                new FileOutputStream(output_file_name),"UTF-8") );
                        
                        //System.out.println("==============");//test
                        
                    }
                    
                    tmp_line = buf_reader.readLine();//read next line from file
                }
                buf_writer.close();
                buf_reader.close();
                JOptionPane.showMessageDialog(null, "File splitted successfully", "Notice",JOptionPane.WARNING_MESSAGE);
                
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error: file not found", "Warning",JOptionPane.WARNING_MESSAGE);
                return;
            } catch (IOException ex) {
                Logger.getLogger(TwTextSpliterGUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error: unknown error occured", "Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }*/
        }else if(RB_custom_delimiter.isSelected()){
            
            /*========================== split the file by custom delimiter ==========================*/
            
            final String split_by_delimiter = TF_custom_delimiter.getText();
            
            
            
            
        }else{
            //didnt select any split method
            JOptionPane.showMessageDialog(null, "You must select a split method", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
        if(CB_delete_source.isSelected()){
            input_fd.delete();
        }
    }//GEN-LAST:event_BT_splitActionPerformed

    private enum split_method{
        SPLIT_BY_LINES,
        SPLIT_BY_SIZE,
        SPLIT_BY_CUSTOM_DELIMITER
    }
    
    private void split(split_method method,File input_fd){
        BufferedReader buf_reader;
        BufferedWriter buf_writer;
        String tmp_line;
        Integer output_file_name_index = 0;
        String output_file_name = set_output_file_name(output_file_name_format, output_file_name_index);
        
        //split_method.SPLIT_BY_LINES only
        Integer line_counter = 0;
        Integer split_by_lines = 0;
        if(method == split_method.SPLIT_BY_LINES){
            try{
                split_by_lines = Integer.parseInt(TF_lines_per_file.getText());
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please input the lines", "Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        
        //split_method.SPLIT_BY_SIZE only
        int file_size_counter = 0;
        Integer split_by_size = 0;//unit of split_by_size is byte
        if(method == split_method.SPLIT_BY_SIZE){
            try{
                split_by_size = Integer.parseInt(TF_size_per_file.getText());
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please input the size", "Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            split_by_size = split_by_size << 10;//KB to byte
            
            /*
             * TODO
            if(unit is mb){
                split_by_size *= 1024
            }else if(unit is gb){
                split_by_size *= 1024*1024;
            }*/
        }
        
        try {

            buf_reader = new BufferedReader(new FileReader(input_fd));
            tmp_line = buf_reader.readLine();//read the first line from file

            buf_writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(output_file_name), "UTF-8"));//set the output stream encoding as utf-8

            while (tmp_line != null) {

                
                if(method == split_method.SPLIT_BY_SIZE){
                    file_size_counter += tmp_line.getBytes(utf8).length;
                    //TODO : other encoding type
                }else if(method == split_method.SPLIT_BY_LINES){
                    line_counter++;
                }

                try {
                    buf_writer.write(tmp_line);//write into output file
                    buf_writer.newLine();
                    buf_writer.flush();
                } catch (IOException e) {
                    System.out.println("Error: an error occured when writing into file");
                    JOptionPane.showMessageDialog(null, "Error: an error occured when writing into file", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(method == split_method.SPLIT_BY_SIZE){
                    if(split_by_size == 0){
                        System.out.println("Error: invalid size");
                        JOptionPane.showMessageDialog(null, "Error: invalid size", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    
                    if (file_size_counter >= split_by_size) {//change to new file
                        file_size_counter = 0;
                        output_file_name_index++;
                        output_file_name = set_output_file_name(output_file_name_format, output_file_name_index);
                        buf_writer = new BufferedWriter(new OutputStreamWriter(
                                new FileOutputStream(output_file_name), "UTF-8"));
                    }
                }else if(method ==split_method.SPLIT_BY_LINES){
                    if(split_by_lines == 0){
                        System.out.println("Error: invalid number of line");
                        JOptionPane.showMessageDialog(null, "Error: invalid number of lines", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    
                    if(line_counter == split_by_lines){//change to new file
                        line_counter = 0;
                        output_file_name_index++;
                        output_file_name = set_output_file_name(output_file_name_format, output_file_name_index);
                        buf_writer = new BufferedWriter( new OutputStreamWriter ( 
                                new FileOutputStream(output_file_name),"UTF-8") );
                    }
                }

                tmp_line = buf_reader.readLine();//read next line from file
            }
            buf_writer.close();
            buf_reader.close();
            JOptionPane.showMessageDialog(null, "File splitted successfully", "Notice", JOptionPane.WARNING_MESSAGE);

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error: file not found", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } catch (IOException ex) {
            Logger.getLogger(TwTextSpliterGUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: unknown error occured", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }
    
    private String set_output_file_name(final String output_file_name_format,Integer output_file_name_index){
        int index_offset = 0;
        String output_file_name = output_file_name_format;
        
        /*
        try{
            index_offset = Integer.parseInt(output_file_name_format);
        }catch(NumberFormatException e){
        }*/
        
        if(output_file_name_format.startsWith("1+")){
            index_offset = 1;
        }
        
        if(output_file_name_format.contains("+")){
            output_file_name = output_file_name_format.substring(2);
        }
        
        //System.out.println("index_offset:"+index_offset);//test 
        //System.out.println("output file name:"+String.format(output_file_name, output_file_name_index+index_offset));//test
        if(index_offset != 0){
            return String.format(output_file_name, output_file_name_index+index_offset);
        }else{
            return String.format(output_file_name, output_file_name_index);
        }
    }
    
    private void TF_lines_per_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_lines_per_fileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_lines_per_fileActionPerformed

    private void CB_output_file_name_formatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_output_file_name_formatActionPerformed
        renew_output_file_name_format(CB_output_file_name_format.getSelectedIndex());
        renew_TF_output_file_path();
    }//GEN-LAST:event_CB_output_file_name_formatActionPerformed

    private void TF_output_file_pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_output_file_pathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_output_file_pathActionPerformed

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
            java.util.logging.Logger.getLogger(TwTextSpliterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TwTextSpliterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TwTextSpliterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TwTextSpliterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TwTextSpliterGUI().setVisible(true);
            }
        });
    }
    
    private void renew_output_file_name_format(int index){
        switch(index){
            case 0:
                output_file_name_format = "1+%d.txt";
                break;
            case 1:
                output_file_name_format = "1+%02d.txt";
                break;
            case 2:
                output_file_name_format = "%d.txt";
                break;
            case 3:
                output_file_name_format = "%02d.txt";
                break;
            default:
                break;
        }
    }
    
    private void renew_TF_input_file_path(){
        TF_file_path.setText(file_chooser.getCurrentDirectory().toString()+"\\"+file_chooser.getName(file_chooser.getSelectedFile()));
    }
    
    private void renew_TF_output_file_path(){
        if(TF_file_path.getText().equals("")){
            //do nothing
        }else{
            renew_output_file_name_format(CB_output_file_name_format.getSelectedIndex());
            TF_output_file_path.setText(file_chooser.getCurrentDirectory().toString()+"\\"+output_file_name_format);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BG_splitby;
    private javax.swing.JButton BT_browse;
    private javax.swing.JButton BT_save_as;
    private javax.swing.JButton BT_split;
    private javax.swing.JCheckBox CB_delete_source;
    private javax.swing.JComboBox CB_input_encoding;
    private javax.swing.JComboBox CB_language;
    private javax.swing.JComboBox CB_output_encoding;
    private javax.swing.JComboBox CB_output_file_name_format;
    private javax.swing.JComboBox CB_size_per_file;
    private javax.swing.JLabel LB_filepath;
    private javax.swing.JLabel LB_input_encoding;
    private javax.swing.JLabel LB_language;
    private javax.swing.JLabel LB_output_encoding;
    private javax.swing.JLabel LB_output_file_path;
    private javax.swing.JLabel LB_output_filename;
    private javax.swing.JLabel LB_splitby;
    private javax.swing.JRadioButton RB_custom_delimiter;
    private javax.swing.JRadioButton RB_lines_per_file;
    private javax.swing.JRadioButton RB_size_per_file;
    private javax.swing.JTextField TF_custom_delimiter;
    private javax.swing.JTextField TF_file_path;
    private javax.swing.JTextField TF_lines_per_file;
    private javax.swing.JTextField TF_output_file_path;
    private javax.swing.JTextField TF_size_per_file;
    // End of variables declaration//GEN-END:variables
}


class TypeOfFile extends FileFilter  
{  
 //Type of file that should be display in JFileChooser will be set here  
 //We choose to display only directory and text file  
 public boolean accept(File f)  
 {  
  return f.isDirectory()||f.getName().toLowerCase().endsWith(".txt");  
 }  
  
 //Set description for the type of file that should be display  
 public String getDescription()  
 {  
  return ".txt (text file)";  
 }  
}

