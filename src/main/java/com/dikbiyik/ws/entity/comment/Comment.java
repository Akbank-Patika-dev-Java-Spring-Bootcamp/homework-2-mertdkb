package com.dikbiyik.ws.entity.comment;

import com.dikbiyik.ws.base.BaseEntity;
import com.dikbiyik.ws.entity.product.Product;
import com.dikbiyik.ws.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(generator = "Comment", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Comment", sequenceName = "COMMENT_ID_SEQ")
    private Long id;

    private String commentBody;

    @ManyToOne
    @JsonIgnoreProperties(value = { "comments" })
    @JoinColumn(name="PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @JsonIgnoreProperties(value = { "comments" })
    private User user;
}
