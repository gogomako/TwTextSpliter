/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author Mako Chang
 */
public class Spliter {

    File input_file;
    BufferedReader buf_reader;
    BufferedWriter buf_writer;
    String input_encoding = File_encoding.UTF8.getText();
    Integer output_file_name_index = 0;
    String output_file_name;
    private String output_file_name_format = "1+%d.txt";
    String output_encoding = File_encoding.UTF8.getText();

    /**
     * @return the output_file_name_format
     */
    public String getOutput_file_name_format() {
        return output_file_name_format;
    }

    /**
     * @param output_file_name_format the output_file_name_format to set
     */
    public void setOutput_file_name_format(String output_file_name_format) {
        this.output_file_name_format = output_file_name_format;
    }
    
    /**
     * @brief An enum to specify split method
     */
    public enum Split_method{
        SPLIT_BY_LINES,
        SPLIT_BY_SIZE,
        SPLIT_BY_CUSTOM_DELIMITER
    }
    
    public enum Size_unit{
        KB,
        MB,
        GB
    }
    
    public enum File_encoding{
        UTF8("UTF-8");
        
        //costomized enum constructor
        private File_encoding(String text){
            this.text = text;
        }
        
        private String text;

        public String valueOf(){
            return text;
        }
        
        @Override
        public String toString(){
            return text;
        }
        
        public String getText(){
            return text;
        }
    }

    public Spliter() {
        this.output_file_name = set_output_file_name();
    }
    
    public Spliter(File input_fd) {
        this.input_file = input_fd;
        this.output_file_name = set_output_file_name();
    }

    public Spliter(Split_method method, File input_fd) {
        this.input_file = input_fd;
        this.output_file_name = set_output_file_name();
    }


    private String set_output_file_name() {
        int index_offset = 0;
        String output_file_name = getOutput_file_name_format();

        if (getOutput_file_name_format().startsWith("1+")) {
            index_offset = 1;
        }

        if (getOutput_file_name_format().contains("+")) {
            output_file_name = getOutput_file_name_format().substring(2);
        }

        if (index_offset != 0) {
            return String.format(output_file_name, output_file_name_index + index_offset);
        } else {
            return String.format(output_file_name, output_file_name_index);
        }
    }
    
    /**
     * @brief Split input file by lines
     * @param lines get from TF_lines_per_file
     * @return LanguageManager.LeafNodeLabel Let UI shows corresponed text to user
     */
    public LanguageManager.LeafNodeLabel split_by_lines(int lines){
        if (lines <= 0) {
            return LanguageManager.LeafNodeLabel.LINES_ERROR;// let UI check LINES_NULL
        }
        
        Integer line_counter;
        
        try{
            buf_reader = new BufferedReader(new FileReader(input_file));
            String tmp_line = buf_reader.readLine();//read the first line from file
            line_counter = 1;//already read one line

            buf_writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(output_file_name), output_encoding));//set the output stream encoding as utf-8
            
            while (tmp_line != null) {
                line_counter++;//count units
                
                //write into output file
                try {
                    buf_writer.write(tmp_line);
                    buf_writer.newLine();
                    buf_writer.flush();
                } catch (IOException ex) {
                    Logger.getLogger(Spliter.class.getName()).log(Level.SEVERE, null, ex);
                    return LanguageManager.LeafNodeLabel.FILE_WRITTING_FAILED;
                }
                
                //create new files
                if (line_counter.equals(lines)) {//change to new file
                    line_counter = 0;
                    output_file_name_index++;
                    output_file_name = set_output_file_name();
                    buf_writer = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream(output_file_name), output_encoding));
                }
                
                tmp_line = buf_reader.readLine();//read next line from file
            }
            
            buf_writer.close();
            buf_reader.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Spliter.class.getName()).log(Level.SEVERE, null, ex);
            return LanguageManager.LeafNodeLabel.FILE_NOT_FOUND;
        } catch (IOException ex) {
            Logger.getLogger(Spliter.class.getName()).log(Level.SEVERE, null, ex);
            return LanguageManager.LeafNodeLabel.UNKNOWN_ERROR;
        }  
        return LanguageManager.LeafNodeLabel.SUCCESS;
    }
    
    /**
     * @param unit get from CB_size_unit
     * @brief Split input file by size
     * @param size get from TF_size_per_file; default unit is byte
     * @return LanguageManager.LeafNodeLabel Let UI shows corresponed text to user
     */
    public LanguageManager.LeafNodeLabel split_by_size(int size, Size_unit unit) {
        if (size <= 0) {
            return LanguageManager.LeafNodeLabel.SIZE_ERROR;// let UI check SIZE_NULL
        }
        
        Integer file_size_counter = 0;

        try {
            buf_reader = new BufferedReader(new FileReader(input_file));
            String tmp_line = buf_reader.readLine();//read the first line from file

            buf_writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(output_file_name), output_encoding));//set the output stream encoding as utf-8
            
            switch (unit) {
                case KB:
                    size = size << 10;//KB to byte
                    break;
                case MB:
                    //MB is selected
                    size = size << 20;//MB to byte
                    break;
                case GB:
                    //GB is selected
                    size = size << 30;//GB to byte
                    break;
                default:
                    return LanguageManager.LeafNodeLabel.UNKNOWN_ERROR;
            }
            
            while (tmp_line != null) {
                file_size_counter += tmp_line.getBytes(input_encoding).length;
                //TODO : other encoding type
                
                //write into output file
                try {
                    buf_writer.write(tmp_line);
                    buf_writer.newLine();
                    buf_writer.flush();
                } catch (IOException ex) {
                    Logger.getLogger(Spliter.class.getName()).log(Level.SEVERE, null, ex);
                    return LanguageManager.LeafNodeLabel.FILE_WRITTING_FAILED;
                }
                
                if (file_size_counter.intValue() >= size) {//change to new file
                    file_size_counter = 0;
                    output_file_name_index++;
                    output_file_name = set_output_file_name();
                    buf_writer = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream(output_file_name), output_encoding));
                }
                tmp_line = buf_reader.readLine();//read next line from file
            }
            
            buf_writer.close();
            buf_reader.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Spliter.class.getName()).log(Level.SEVERE, null, ex);
            return LanguageManager.LeafNodeLabel.FILE_NOT_FOUND;
        } catch (IOException ex) {
            Logger.getLogger(Spliter.class.getName()).log(Level.SEVERE, null, ex);
            return LanguageManager.LeafNodeLabel.UNKNOWN_ERROR;
        }
        return LanguageManager.LeafNodeLabel.SUCCESS;
    }
    
    /**
     * @brief Split input file by costomized delimiter
     * @param delimiter get from TF_custom_delimiter
     * @return LanguageManager.LeafNodeLabel Let UI shows corresponed text to user
     */
    public LanguageManager.LeafNodeLabel split_by_costom_delimiter(String delimiter){
        if (delimiter.isEmpty()){
            return LanguageManager.LeafNodeLabel.DELIMITER_ERROR;// let UI check DELIMITER_NULL
        }
        
        //TODO RE input
        //Pattern pattern = Pattern.compile(delimiter, Pattern.UNICODE_CHARACTER_CLASS);
        
        try {
            buf_reader = new BufferedReader(new FileReader(input_file));
            String tmp_line = buf_reader.readLine();//read the first line from file

            buf_writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(output_file_name), output_encoding));//set the output stream encoding as utf-8

            while (tmp_line != null) {
                //write into output file
                try {
                    buf_writer.write(tmp_line);
                    buf_writer.newLine();
                    buf_writer.flush();
                } catch (IOException ex) {
                    Logger.getLogger(Spliter.class.getName()).log(Level.SEVERE, null, ex);
                    return LanguageManager.LeafNodeLabel.FILE_WRITTING_FAILED;
                }
                //TODO match RE
                if (Pattern.matches(delimiter,tmp_line)) {//change to new file
                    output_file_name_index++;
                    output_file_name = set_output_file_name();
                    buf_writer = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream(output_file_name), "UTF-8"));
                }
                tmp_line = buf_reader.readLine();//read next line from file
            }
            buf_writer.close();
            buf_reader.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Spliter.class.getName()).log(Level.SEVERE, null, ex);
            return LanguageManager.LeafNodeLabel.FILE_NOT_FOUND;
        } catch (IOException ex) {
            Logger.getLogger(Spliter.class.getName()).log(Level.SEVERE, null, ex);
            return LanguageManager.LeafNodeLabel.UNKNOWN_ERROR;
        }
        return LanguageManager.LeafNodeLabel.SUCCESS;
    }
    /*

     * @brief This is a function to split text file with specific way
     * @pre Input a text file
     * @post Split the file with specific way
     * @todo Split by costomized delimiter
     * 
     * @return void

    private void split(
            Spliter.Split_method method,    ///< The way how to split this file 
            File input_fd           ///< A file descriptor points to this file
    ){
        BufferedReader buf_reader;
        BufferedWriter buf_writer;
        String tmp_line;
        Integer output_file_name_index = 0;
        String output_file_name = set_output_file_name(output_file_name_format, output_file_name_index);
        
        //split_method.SPLIT_BY_LINES only
        Integer line_counter = 1;
        Integer split_by_lines = 0;
        if (method == Spliter.Split_method.SPLIT_BY_LINES) {
            try {
                split_by_lines = Integer.parseInt(TF_lines_per_file.getText());
            } catch (NumberFormatException ex) {
                Logger.getLogger(TwTextSpliterGUI.class.getName()).log(Level.SEVERE, null, ex);
                UIMessager.showInfo(LanguageManager.LeafNodeLabel.LINES_NULL.getText(),CB_language.getSelectedIndex());
                return;
            }
            if (split_by_lines.intValue() <= 0) {
                UIMessager.showError(LanguageManager.LeafNodeLabel.LINES_ERROR.getText(),CB_language.getSelectedIndex());
                return;
            }
        }
        
        //split_method.SPLIT_BY_SIZE only
        Integer file_size_counter = 0;
        Integer split_by_size = 0;//unit of split_by_size is byte
        if (method == Spliter.Split_method.SPLIT_BY_SIZE) {
            try {
                split_by_size = Integer.parseInt(TF_size_per_file.getText());
            } catch (NumberFormatException ex) {
                Logger.getLogger(TwTextSpliterGUI.class.getName()).log(Level.SEVERE, null, ex);
                UIMessager.showInfo(LanguageManager.LeafNodeLabel.SIZE_NULL.getText(),CB_language.getSelectedIndex());
                return;
            }

            if (split_by_size.intValue() <= 0) {
                UIMessager.showError(LanguageManager.LeafNodeLabel.SIZE_ERROR.getText(),CB_language.getSelectedIndex());
                return;
            }
            
            switch (CB_size_per_file.getSelectedIndex()) {
                case 0:
                    //KB is selected
                    split_by_size = split_by_size.intValue() << 10;//KB to byte
                    break;
                case 1:
                    //MB is selected
                    split_by_size = split_by_size.intValue() << 20;//MB to byte
                    break;
                case 2:
                    //GB is selected
                    split_by_size = split_by_size.intValue() << 30;//GB to byte
                    break;
                default:
                    //nothing
            }
        }
        
        //split_method.SPLIT_BY_CUSTOM_DELIMITER only
        String split_by_delimiter = TF_custom_delimiter.getText();
        Pattern pattern = Pattern.compile(split_by_delimiter, Pattern.UNICODE_CHARACTER_CLASS);
        //Matcher matcher = pattern.matcher();
        if(method == Spliter.Split_method.SPLIT_BY_CUSTOM_DELIMITER){}
        
        try {

            buf_reader = new BufferedReader(new FileReader(input_fd));
            tmp_line = buf_reader.readLine();//read the first line from file

            buf_writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(output_file_name), "UTF-8"));//set the output stream encoding as utf-8

            while (tmp_line != null) {

                //count units
                switch(method){
                    case SPLIT_BY_LINES:
                        line_counter++;
                        break;
                    case SPLIT_BY_SIZE:
                        file_size_counter += tmp_line.getBytes(utf8).length;
                        //System.out.println("fiie_size_counter: "+file_size_counter);//debug msg
                        //TODO : other encoding type
                        break;
                    case SPLIT_BY_CUSTOM_DELIMITER:
                        //TODO
                        break;
                    default:
                        //nothing
                    
                }

                //write into output file
                try {
                    buf_writer.write(tmp_line);
                    buf_writer.newLine();
                    buf_writer.flush();
                } catch (IOException ex) {
                    Logger.getLogger(TwTextSpliterGUI.class.getName()).log(Level.SEVERE, null, ex);
                    UIMessager.showError(LanguageManager.LeafNodeLabel.FILE_WRITTING_FAILED.getText(),CB_language.getSelectedIndex());
                    return;
                }
                
                //create new files
                switch (method) {
                    case SPLIT_BY_LINES:

                        if (line_counter.equals(split_by_lines)) {//change to new file
                            line_counter = 0;
                            output_file_name_index++;
                            output_file_name = set_output_file_name(output_file_name_format, output_file_name_index);
                            buf_writer = new BufferedWriter(new OutputStreamWriter(
                                    new FileOutputStream(output_file_name), "UTF-8"));
                        }
                        break;

                    case SPLIT_BY_SIZE:

                        if (file_size_counter.intValue() >= split_by_size.intValue()) {//change to new file
                            file_size_counter = 0;
                            output_file_name_index++;
                            output_file_name = set_output_file_name(output_file_name_format, output_file_name_index);
                            buf_writer = new BufferedWriter(new OutputStreamWriter(
                                    new FileOutputStream(output_file_name), "UTF-8"));
                        }
                        break;
                    case SPLIT_BY_CUSTOM_DELIMITER:
                        //TODO
                        break;
                    default:
                    //nothing
                }

                tmp_line = buf_reader.readLine();//read next line from file
            }
            buf_writer.close();
            buf_reader.close();
            UIMessager.showNotice("File splitted successfully");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TwTextSpliterGUI.class.getName()).log(Level.SEVERE, null, ex);
            UIMessager.showError(LanguageManager.LeafNodeLabel.FILE_NOT_FOUND.getText(),CB_language.getSelectedIndex());
        } catch (IOException ex) {
            Logger.getLogger(TwTextSpliterGUI.class.getName()).log(Level.SEVERE, null, ex);
            UIMessager.showError(LanguageManager.LeafNodeLabel.UNKNOWN_ERROR.getText(),CB_language.getSelectedIndex());
        }
    }
    */
    
}
