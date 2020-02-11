/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umg.so.processmanager;


import java.util.List;
import java.util.Random;

/**
 *
 * @author Ronaldo Lemus
 */

public class ProcessMaganer {

    private List<Object> ThreadList;
    private Object current;
    private Random random;
    
    
    public ProcessMaganer() {
        //this. processList = new ArrayList<>();
        //Runnable r = new ReadFileThread("Archivos", "Lectura de archivo de texto");

        //this.processList.add(new Thread (new ReadFileThread("Archivos", "Lectura de archivo de texto")));
    }

    public void next() {
        int randomIndex = random.nextInt(ThreadList.size());
        if (this.current != null) {
            
        }
     

    }

    public ProcessMaganer setStatus(boolean status) {
        return this;
    }


//    
//    public void start(){
//        for(Thread t : this.processList){
//            t.start();
//        }
//    }
//    
//    public List<Thread> getProcessList(){
//        return this.processList;
//    }
//    
}
