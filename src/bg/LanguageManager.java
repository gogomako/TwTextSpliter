/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bg;

import gui.TwTextSpliterGUI;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Mako Chang
 */
public final class LanguageManager {
    private Language lanSet = Language.EN;
    private HashMap<String,String> lanTextList = new HashMap<String,String>();
    
    public LanguageManager(){
    }
    
    public LanguageManager(int selectedLanguage){
        switch(selectedLanguage){
            case 0:
                lanTextList = readLanguageFile(Language.EN);
                lanSet = Language.EN;
                break;
            case 1:
                lanTextList = readLanguageFile(Language.ZH_TW);
                lanSet = Language.ZH_TW;
                break;
            default:
                break;
        }
    }
    
    public LanguageManager(Language lanSet){
        switch(lanSet){
            case EN:
                lanTextList = readLanguageFile(Language.EN);
                lanSet = Language.EN;
                break;
            case ZH_TW:
                lanTextList = readLanguageFile(Language.ZH_TW);
                lanSet = Language.ZH_TW;
                break;
            default:
                break;
        }
    }

    /**
     * @return the lanSet
     */
    public Language getLanSet() {
        return lanSet;
    }

    /**
     * @param lanSet the lanSet to set
     */
    /*
    public void setLanSet(Language lanSet) {
        this.lanSet = lanSet;
    }*/
    public void setLanSetEN() {
        this.lanSet = Language.EN;
    }
    public void setLanSetTH_TW() {
        this.lanSet = Language.ZH_TW;
    }

    /**
     * @return the lanTextList
     */
    public HashMap<String,String> getLanTextList() {
        return lanTextList;
    }

    /**
     * @param lanTextList the lanTextList to set
     */
    public void setLanTextList(HashMap<String,String> lanTextList) {
        this.lanTextList = lanTextList;
    }
    
    public enum Language{
        EN,
        ZH_TW
    }
    
    /**
     * @marker If add any new element in xml, please check this enum
     * Every enum map to a internal node in language xml file
     */
    public enum NodeCategory{
        TEXTFIELD("textfield"),
        MESSAGE("msg"),
        VALID("valid"),
        WARNING("warning"),
        ERROR("error"),
        BUTTONTEXT("button");
        
        //costomized enum constructor
        private NodeCategory(String text){
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
    
    /**
     * @marker If add any new element in xml, please check this enum
     * Every enum map to a leaf node in language xml file
     */
    public enum LeafNodeLabel{
        INPUT_FILE_PATH("input_file_path"),
        OUTPUT_FILE_PATH("output_file_path"),
        OUTPUT_FILE_NAME("output_file_name"),
        SPLIT_BY("split_by"),
        INPUT_ENCODING("input_encoding"),
        OUTPUT_ENCODING("output_encoding"),
        LANGUAGE("language"),
        LINES_PER_FILE("lines_per_file"),
        SIZE_PER_FILE("size_per_file"),
        CUSTOM_DELIMITER("custom_delimiter"),
        DELETE_SOURCE("delete_source_after_splited"),
        AUTO("auto"),
        SUCCESS("success"),
        LINES_NULL("lines_null"),
        SIZE_NULL("size_null"),
        DELIMITER_NULL("delimiter_null"),
        SPLIT_METHOD_NULL("split_method_null"),
        LINES_ERROR("lines_error"),
        SIZE_ERROR("size_error"),
        DELIMITER_ERROR("delimiter_error"),
        FILE_WRITTING_FAILED("file_writting_failed"),
        FILE_NOT_FOUND("file_not_found"),
        UNKNOWN_ERROR("unknown_error"),
        BROWSE("browse"),
        SAVE_AS("save_as"),
        SPLIT("split");
        
        //costomized enum constructor
        private LeafNodeLabel(String text){
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
    
    private HashMap<String,String> readLanguageFile(Language lan){
        SAXBuilder builder = new SAXBuilder();
        HashMap<String,String> lanTextList = new HashMap<String,String>();
        Document document = new Document();
        try {
            switch (lan) {
                case EN:
                    document = (Document) builder.build(new File("src\\resource\\language\\en.xml"));
                    break;
                case ZH_TW:
                    document = (Document) builder.build(new File("src\\resource\\language\\zh-tw.xml"));
                    break;
            }
        } catch (IOException | JDOMException ex) {
            Logger.getLogger(TwTextSpliterGUI.class.getName()).log(Level.SEVERE, null, ex);
            UIMessager.showError("Open language resource file failed");
            return null;
        }
        
        Element root_node = document.getRootElement();

        Element textfield_node = root_node.getChild(NodeCategory.TEXTFIELD.getText());
        Element msg_node = root_node.getChild(NodeCategory.MESSAGE.getText());
        Element button_node = root_node.getChild(NodeCategory.BUTTONTEXT.getText());

        addTextFieldChildrenText(lanTextList, textfield_node);
        addMsgChildrenText(lanTextList, msg_node);
        addButtonChildrenText(lanTextList, button_node);
        return lanTextList;
    }
    
    private HashMap<String,String> readLanguageFile(){
        SAXBuilder builder = new SAXBuilder();
        HashMap<String,String> lanTextList = new HashMap<String,String>();
        Document document = new Document();
        try {
            switch (this.lanSet) {
                case EN:
                    document = (Document) builder.build(new File("src\\resource\\language\\en.xml"));
                    break;
                case ZH_TW:
                    document = (Document) builder.build(new File("src\\resource\\language\\zh-tw.xml"));
                    break;
            }
        } catch (IOException | JDOMException ex) {
            Logger.getLogger(TwTextSpliterGUI.class.getName()).log(Level.SEVERE, null, ex);
            UIMessager.showError("Open language resource file failed");
            return null;
        }
        
        Element root_node = document.getRootElement();

        Element textfield_node = root_node.getChild(NodeCategory.TEXTFIELD.getText());
        Element msg_node = root_node.getChild(NodeCategory.MESSAGE.getText());
        Element button_node = root_node.getChild(NodeCategory.BUTTONTEXT.getText());

        addTextFieldChildrenText(lanTextList, textfield_node);
        addMsgChildrenText(lanTextList, msg_node);
        addButtonChildrenText(lanTextList, button_node);
        return lanTextList;
    }
    
    public void changeLanguage(Language newLan){
        getLanTextList().clear();
        this.lanTextList = readLanguageFile(newLan);
    }
    
    /**
     * @brief Read text from node textField in language xml file
     * @param lanTextList store values of leaf node in language xml file
     * @param textfield_node internal node of language xml file
     * @marker If add any new element in xml, please check this function
     */
    private void addTextFieldChildrenText(HashMap<String,String> lanTextList, Element textfield_node){
        lanTextList.put(LeafNodeLabel.INPUT_FILE_PATH.getText(),textfield_node.getChildText(LeafNodeLabel.INPUT_FILE_PATH.getText()));
        lanTextList.put(LeafNodeLabel.OUTPUT_FILE_PATH.getText(),textfield_node.getChildText(LeafNodeLabel.OUTPUT_FILE_PATH.getText()));
        lanTextList.put(LeafNodeLabel.OUTPUT_FILE_NAME.getText(),textfield_node.getChildText(LeafNodeLabel.OUTPUT_FILE_NAME.getText()));
        lanTextList.put(LeafNodeLabel.SPLIT_BY.getText(),textfield_node.getChildText(LeafNodeLabel.SPLIT_BY.getText()));
        lanTextList.put(LeafNodeLabel.INPUT_ENCODING.getText(),textfield_node.getChildText(LeafNodeLabel.INPUT_ENCODING.getText()));
        lanTextList.put(LeafNodeLabel.OUTPUT_ENCODING.getText(),textfield_node.getChildText(LeafNodeLabel.OUTPUT_ENCODING.getText()));
        lanTextList.put(LeafNodeLabel.LANGUAGE.getText(),textfield_node.getChildText(LeafNodeLabel.LANGUAGE.getText()));
        lanTextList.put(LeafNodeLabel.LINES_PER_FILE.getText(),textfield_node.getChildText(LeafNodeLabel.LINES_PER_FILE.getText()));
        lanTextList.put(LeafNodeLabel.SIZE_PER_FILE.getText(),textfield_node.getChildText(LeafNodeLabel.SIZE_PER_FILE.getText()));
        lanTextList.put(LeafNodeLabel.CUSTOM_DELIMITER.getText(),textfield_node.getChildText(LeafNodeLabel.CUSTOM_DELIMITER.getText()));
        lanTextList.put(LeafNodeLabel.DELETE_SOURCE.getText(),textfield_node.getChildText(LeafNodeLabel.DELETE_SOURCE.getText()));
        lanTextList.put(LeafNodeLabel.AUTO.getText(),textfield_node.getChildText(LeafNodeLabel.AUTO.getText()));
    }
    
    /**
     * @brief Read text from node msg in language xml file
     * @param lanTextList store values of leaf node in language xml file
     * @param msg_node internal node of language xml file
     * @marker If add any new element in xml, please check this function
     */
    private void addMsgChildrenText(HashMap<String,String> lanTextList, Element msg_node){
        Element valid_node = msg_node.getChild(NodeCategory.VALID.getText());
        lanTextList.put(LeafNodeLabel.SUCCESS.getText(), valid_node.getChildText(LeafNodeLabel.SUCCESS.getText()));
        
        Element warning_node = msg_node.getChild(NodeCategory.WARNING.getText());
        lanTextList.put(LeafNodeLabel.LINES_NULL.getText(),warning_node.getChildText(LeafNodeLabel.LINES_NULL.getText()));
        lanTextList.put(LeafNodeLabel.SIZE_NULL.getText(),warning_node.getChildText(LeafNodeLabel.SIZE_NULL.getText()));
        lanTextList.put(LeafNodeLabel.DELIMITER_NULL.getText(),warning_node.getChildText(LeafNodeLabel.DELIMITER_NULL.getText()));
        lanTextList.put(LeafNodeLabel.SPLIT_METHOD_NULL.getText(),warning_node.getChildText(LeafNodeLabel.SPLIT_METHOD_NULL.getText()));
        
        Element error_node = msg_node.getChild(NodeCategory.ERROR.getText());
        lanTextList.put(LeafNodeLabel.LINES_ERROR.getText(),error_node.getChildText(LeafNodeLabel.LINES_ERROR.getText()));
        lanTextList.put(LeafNodeLabel.SIZE_ERROR.getText(),error_node.getChildText(LeafNodeLabel.SIZE_ERROR.getText()));
        lanTextList.put(LeafNodeLabel.DELIMITER_ERROR.getText(),error_node.getChildText(LeafNodeLabel.DELIMITER_ERROR.getText()));
        lanTextList.put(LeafNodeLabel.FILE_WRITTING_FAILED.getText(),error_node.getChildText(LeafNodeLabel.FILE_WRITTING_FAILED.getText()));
        lanTextList.put(LeafNodeLabel.FILE_NOT_FOUND.getText(),error_node.getChildText(LeafNodeLabel.FILE_NOT_FOUND.getText()));
        lanTextList.put(LeafNodeLabel.UNKNOWN_ERROR.getText(),error_node.getChildText(LeafNodeLabel.UNKNOWN_ERROR.getText()));
    }
    
    /**
     * @brief Read text from node button in language xml file
     * @param lanTextList store values of leaf node in language xml file
     * @param btn_node internal node of language xml file
     * @marker If add any new element in xml, please check this function
     */
    private void addButtonChildrenText(HashMap<String,String> lanTextList, Element btn_node){
        lanTextList.put(LeafNodeLabel.BROWSE.getText(),btn_node.getChildText(LeafNodeLabel.BROWSE.getText()));
        lanTextList.put(LeafNodeLabel.SAVE_AS.getText(),btn_node.getChildText(LeafNodeLabel.SAVE_AS.getText()));
        lanTextList.put(LeafNodeLabel.SPLIT.getText(),btn_node.getChildText(LeafNodeLabel.SPLIT.getText()));
    }
}
