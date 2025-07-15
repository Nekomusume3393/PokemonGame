/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon.pokedex.entity;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author May5th
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {
    
    private String username;
    private String password;
    private String displayName;
    @Builder.Default
    private String image = "photo.png";
    private boolean manager;
    
}
