package com.dikbiyik.ws.entity.product;

import java.util.List;

import com.dikbiyik.ws.entity.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(generator = "Product", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Product", sequenceName = "PRODUCT_ID_SEQ")
    private Long id;

    @NotBlank
    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @NotBlank
    @Column(name = "PRICE", nullable = false)
    private int Price;

    @JsonIgnoreProperties
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Comment> comments;

}
