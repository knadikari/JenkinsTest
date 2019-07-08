/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jenkinstest;

/**
 *
 * @author kuadlk
 */
public class Cal {
    public int add(int num1, int num2) {
        return(num1 + num2);
    }
    
    public int sub(int num1, int num2) {
        return (num1 > num2) ? (num1 - num2) : (num2 - num1);
    }
}
