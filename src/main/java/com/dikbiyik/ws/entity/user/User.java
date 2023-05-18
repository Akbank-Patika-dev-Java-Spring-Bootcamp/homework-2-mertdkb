package com.dikbiyik.ws.entity.user;

import com.dikbiyik.ws.entity.base.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "APPUSER")
@Getter
@Setter
public class User extends BaseEntity{ 
    
    @Id
    @GeneratedValue(generator = "User", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "User", sequenceName = "USER_ID_SEQ")
    private Long id;

    @NotBlank
    @Column(name = "USERNAME", nullable = false)
    private String username;

    @NotNull
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @NotNull
    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Email
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "USER_TYPE")
    @Enumerated(EnumType.STRING)
    private AppUserType userType;
}