/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon.pokedex.util;

import pokemon.pokedex.entity.User;

/**
 *
 * @author May5th
 */
public class XAuth {
    
    public static User user = User.builder()
            .username("ashketchum1")
            .password("123")
            .displayName("AshKetchum")
            .image("photo.png")
            .manager(true)
            .build();
    
}