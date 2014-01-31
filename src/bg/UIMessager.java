/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bg;

import bg.LanguageManager.Language;
import javax.swing.JOptionPane;

/**
 * @brief Use JOptionPane to show message dialog with/without specific language
 * @author Mako Chang
 */
public class UIMessager {
    public UIMessager(){
    }
    
    /**
     * @brief Show message dialog without specific language in PLAIN_MESSAGE
     * @param msg Showing msg
     */
    public static void showNotice(String msg){
        JOptionPane.showMessageDialog(null, msg, "Notice", JOptionPane.PLAIN_MESSAGE);
    }
    
    /**
     * @brief Show message dialog without specific language in INFORMATION_MESSAGE
     * @param msg Showing msg
     */
    public static void showInfo(String msg){
        JOptionPane.showMessageDialog(null, msg, "Infomation", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * @brief Show message dialog without specific language in WARNING_MESSAGE
     * @param msg Showing msg
     */
    public static void showWarning(String msg){
        JOptionPane.showMessageDialog(null, msg, "Warning",JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * @brief Show message dialog without specific language in ERROR_MESSAGE
     * @param msg Showing msg
     */
    public static void showError(String msg){
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * @brief Show message dialog with specific language in PLAIN_MESSAGE
     * @param msgLabel Message label in language xml file
     * @param selectedLanguage 0 for EN, 1 for ZH_TW
     */
    public static void showNotice(String msgLabel,int selectedLanguage){
        LanguageManager lanManager = new LanguageManager(selectedLanguage);
        JOptionPane.showMessageDialog(null, lanManager.getLanTextList().get(msgLabel), "Notice", JOptionPane.PLAIN_MESSAGE);
    }
    
    /**
     * @brief Show message dialog with specific language in INFORMATION_MESSAGE
     * @param msgLabel Message label in language xml file
     * @param selectedLanguage 0 for EN, 1 for ZH_TW
     */
    public static void showInfo(String msgLabel,int selectedLanguage){
        LanguageManager lanManager = new LanguageManager(selectedLanguage);
        JOptionPane.showMessageDialog(null, lanManager.getLanTextList().get(msgLabel), "Infomation", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * @brief Show message dialog with specific language in WARNING_MESSAGE
     * @param msgLabel Message label in language xml file
     * @param selectedLanguage 0 for EN, 1 for ZH_TW
     */
    public static void showWarning(String msgLabel,int selectedLanguage){
        LanguageManager lanManager = new LanguageManager(selectedLanguage);
        JOptionPane.showMessageDialog(null, lanManager.getLanTextList().get(msgLabel), "Warning",JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * @brief Show message dialog with specific language in ERROR_MESSAGE
     * @param msgLabel Message label in language xml file
     * @param selectedLanguage 0 for EN, 1 for ZH_TW
     */
    public static void showError(String msgLabel,int selectedLanguage){
        LanguageManager lanManager = new LanguageManager(selectedLanguage);
        JOptionPane.showMessageDialog(null, lanManager.getLanTextList().get(msgLabel), "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * @param lanManager
     * @brief Show message dialog with specific language in PLAIN_MESSAGE
     * @param msgLabel Message label in language xml file
     */
    public static void showNotice(String msgLabel,LanguageManager lanManager){
        JOptionPane.showMessageDialog(null, lanManager.getLanTextList().get(msgLabel), "Notice", JOptionPane.PLAIN_MESSAGE);
    }
    
    /**
     * @param lanManager
     * @brief Show message dialog with specific language in INFORMATION_MESSAGE
     * @param msgLabel Message label in language xml file 
     */
    public static void showInfo(String msgLabel,LanguageManager lanManager){
        JOptionPane.showMessageDialog(null, lanManager.getLanTextList().get(msgLabel), "Infomation", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * @param lanManager
     * @brief Show message dialog with specific language in WARNING_MESSAGE
     * @param msgLabel Message label in language xml file 
     */
    public static void showWarning(String msgLabel,LanguageManager lanManager){
        JOptionPane.showMessageDialog(null, lanManager.getLanTextList().get(msgLabel), "Warning",JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * @param lanManager
     * @brief Show message dialog with specific language in ERROR_MESSAGE
     * @param msgLabel Message label in language xml file 
     */
    public static void showError(String msgLabel,LanguageManager lanManager){
        JOptionPane.showMessageDialog(null, lanManager.getLanTextList().get(msgLabel), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
