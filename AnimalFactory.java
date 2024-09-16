/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.padroes;

import java.util.HashMap;

/**
 *
 * @author beruas
 */
public class AnimalFactory {

    // Mapa para armazenar as instâncias de animais já criadas
    private static final HashMap<String, Animal> mapaAnimais = new HashMap<>();

    /**
     * Obtém uma instância de um animal. Se a espécie já existir no mapa,
     * a instância existente é retornada. Caso contrário, uma nova instância é
     * criada e adicionada ao mapa.
     * 
     * @param nomeEspecie O nome da espécie do animal.
     * @return A instância do animal.
     */
    public static Animal getAnimal(final String nomeEspecie) {
        Animal animal = mapaAnimais.get(nomeEspecie);
        if (animal == null) {
            animal = new Animal(nomeEspecie);
            mapaAnimais.put(nomeEspecie, animal);
            System.out.println("NOVO MAMIFERO ADCIONADO AO ZOOLÓGICO: " + nomeEspecie);
        }
        return animal;
    }

}