/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umg.so.processmanager.models;

/**
 *
 * @author Ronaldo Lemus
 */
public final class ProcessModel {

    private String name;
    private int status;
    private String description;
    private final long timeStamp;
    private boolean doStop = false;
    private Thread task;

    public Thread getTask() {
        return task;
    }

    public void setTask(Thread task) {
        this.task = task;
    }

    public void init() {
        if (task != null) {
            this.task.start();
        }
    }

    public synchronized void doStop() {
        this.doStop = true;
    }

    protected synchronized boolean keepRunning() {
        return this.doStop == false;
    }

    public ProcessModel(String name, String description, Thread task) {
        this.status = 0;
        this.description = description;
        this.name = name;
        this.timeStamp = System.currentTimeMillis();
        this.task = task;
        this.init();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setStatus(int estado) {
        this.status = estado;
    }

    public String getStatus() {
        return description;
    }

    public String getStatusString() {
        switch (this.status) {
            case 0:
                return "Preparado";
            case 1:
                return "Pausado";
            case 2:
                return "Ejecucion";
            default:
                return "Na/na";
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

}
