/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sise.TiendaTecnologica.main;

import com.sise.TiendaTecnologica.ui.LoginUI;

/**
 *
 * @author Alex_PC
 */
public class Main {
    
    public static void main(String[] args){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
        if ("Windows".equals(info.getName())){
            javax.swing.UIManager.setLookAndFeel(info.getClassName());
            break;
        }    
    }
    new LoginUI().setVisible(true);
} catch (Exception e){
System.out.println(e);
}
        
}
}
