/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.padroes;

/**
 *
 * @author beruas
 */
public class Flyweight {

    // Lista de espécies de animais disponíveis no zoológico
    private static final String[] especiesAnimais = {"Onça", "Leão", "Lobo", "Gorila", "Chimpanzé", "Orangotango", "Zebra", "Vaca", "Girafa"};

    /**
     * Método principal da aplicação.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        for(int i=0; i<40; i++){
            Animal novoAnimal = AnimalFactory.getAnimal(obterEspecieAleatoria());
            novoAnimal.deslocar();
        }
    }
    
    /**
     * Retorna uma espécie de animal aleatória da lista de espécies disponíveis.
     * @return Uma espécie de animal aleatória.
     */
    private static String obterEspecieAleatoria(){
        return especiesAnimais[(int)(Math.random()*especiesAnimais.length)];
    }
}