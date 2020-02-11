/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umg.os.processmanager.process;

import com.umg.so.processmanager.models.ProcessModel;

/**
 *
 * @author Ronaldo Lemus
 */
public class ReadFileThread implements Runnable{

    
    int value = 0;
    private boolean running;
    public ReadFileThread(){
        this.running = false;
    }
    
    @Override
    public void run() {
        while(running) {
            
            System.out.println("Running: " + value);
            value++;
            
        }
    }
    
    
}
