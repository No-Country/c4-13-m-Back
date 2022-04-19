/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.IPETM69.EscuelaTecnica.auth.dto;

import com.IPETM69.EscuelaTecnica.auth.entity.RoleEntity;
import com.IPETM69.EscuelaTecnica.auth.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListUserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private RoleEntity role;

    public ListUserDTO(UserEntity user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.role = user.getRole();
    }
    
}
