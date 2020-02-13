/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umg.so.processmanager;

import com.umg.so.views.UIProcess;
import com.umg.so.views.UIProcessReadFile;

/**
 *
 * @author Ronaldo Lemus
 */
public class main {
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      Thread hilo = new Thread(new Runnable(){
          @Override
          public void run() {
              new UIProcess().setVisible(true);
          }
          
      });
        
      Thread hilo2 = new Thread(new Runnable(){
          @Override
          public void run() {
              new UIProcessReadFile().setVisible(true);
          }
          
      });
      hilo.start();
      hilo2.start();
    }
}
