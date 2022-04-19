package com.IPETM69.EscuelaTecnica.auth.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NonNull
    private String firstName;
    
    @NonNull
    private String lastName;
    
    @NonNull
    @Email
    private String email;
    
    @NonNull
    private String password;
    
    @ManyToOne
    @NonNull
    private RoleEntity role;
    
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date deletedAt;
   
    
}
