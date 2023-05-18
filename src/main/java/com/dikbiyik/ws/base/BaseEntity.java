package com.dikbiyik.ws.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable, Cloneable, BaseEntityModel {
    @Embedded
    private BaseAdditionalFields baseAdditionalFields;
}
