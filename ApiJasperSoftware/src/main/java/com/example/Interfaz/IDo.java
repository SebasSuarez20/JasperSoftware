/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Interfaz;

import com.example.Model.responseGeneric;

/**
 *
 * @author programador3
 */
public interface IDo {
  
    public String url="src/main/resources/static/Report";
    public responseGeneric generalInforme(String path,int companyCode,int doNo);
}
