/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Splash;

import Formularios.Interfaz;
import UpperEssential.UpperEssentialLookAndFeel;
//import capgras.ScreenSplash;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Alex
 */
public class SplashScreen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException, InstantiationException {
        
        
        
        try {
            // TODO code application logic 
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Frame f = new Frame();
            f.setSize(270, 270);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            
            //UIManager.setLookAndFeel(new UpperEssentialLookAndFeel());
            
//            UIManager.setLookAndFeel(new UpperEssentialLookAndFeel("C:\\Users\\Alex\\Documents\\NetBeansProjects\\Capgras_6\\Librerias\\MaterialBlue.theme"));
            UIManager.setLookAndFeel(new UpperEssentialLookAndFeel("C:\\Users\\Alex\\Documents\\NetBeansProjects\\Capgras_6\\Librerias\\CapgrasBlue.theme"));
//            UIManager.setLookAndFeel(new UpperEssentialLookAndFeel("C:\\Users\\Alex\\Documents\\NetBeansProjects\\Capgras_6\\Librerias\\Upper.theme"));
//            UIManager.setLookAndFeel(new UpperEssentialLookAndFeel("C:\\Users\\Alex\\Documents\\NetBeansProjects\\Capgras_6\\Librerias\\Monica.theme"));
//            UIManager.setLookAndFeel(new UpperEssentialLookAndFeel("C:\\Users\\Alex\\Documents\\NetBeansProjects\\Capgras_6\\Librerias\\Veronica.theme"));
            
//        
//        Interfaz lib = new Interfaz();
//        lib.setLocationRelativeTo(null);
//        lib.setVisible(true);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
