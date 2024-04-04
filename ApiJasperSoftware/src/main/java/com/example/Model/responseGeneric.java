/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Model;

/**
 *
 * @author programador3
 */
public class responseGeneric {

    
    private String message;
    private int Status;
    private String base64;

    public responseGeneric(String _message,int _Status,String _base64) {
        this.message = _message;
        this.Status = _Status;
        this.base64 = _base64;
    }
    
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
