/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.padroes;

/**
 *
 * @author beruas
 */

/**
 * Representa um animal mamífero no zoológico.
 * 
 * @author Felkng <⁢felkng374 at @gmail.com>>
 */
public class Animal implements Mamifero {

    // Espécie do animal
    String nomeEspecie;
    // Coordenada X da localização do animal
    Integer posicaoX;
    // Coordenada Y da localização do animal
    Integer posicaoY;

    /**
     * Obtém o nome da espécie do animal.
     * @return O nome da espécie.
     */
    public String getNomeEspecie() {
        return nomeEspecie;
    }

    /**
     * Define o nome da espécie do animal.
     * @param nomeEspecie O nome da espécie.
     */
    public void setNomeEspecie(String nomeEspecie) {
        this.nomeEspecie = nomeEspecie;
    }

    /**
     * Obtém a coordenada X da localização do animal.
     * @return A coordenada X.
     */
    public Integer getPosicaoX() {
        return posicaoX;
    }

    /**
     * Define a coordenada X da localização do animal.
     * @param posicaoX A coordenada X.
     */
    public void setPosicaoX(Integer posicaoX) {
        this.posicaoX = posicaoX;
    }

    /**
     * Obtém a coordenada Y da localização do animal.
     * @return A coordenada Y.
     */
    public Integer getPosicaoY() {
        return posicaoY;
    }

    /**
     * Define a coordenada Y da localização do animal.
     * @param posicaoY A coordenada Y.
     */
    public void setPosicaoY(Integer posicaoY) {
        this.posicaoY = posicaoY;
    }

    /**
     * Construtor da classe Animal.
     * @param nomeEspecie O nome da espécie do animal.
     */
    public Animal(String nomeEspecie) {
        this.nomeEspecie = nomeEspecie;
    }

    /**
     * Desloca o animal para uma nova posição aleatória no zoológico.
     */
    @Override
    public void deslocar() {
        setPosicaoX((int) (Math.random() * 100));
        setPosicaoY((int) (Math.random() * 100));
        System.out.println(this.nomeEspecie + " deslocou para: (" + getPosicaoX() + "," + getPosicaoY() + ")");
    }

}