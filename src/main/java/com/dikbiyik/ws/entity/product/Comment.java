package com.dikbiyik.ws.entity.product;

import com.dikbiyik.ws.entity.base.BaseEntity;

import jakarta.persistence.Entity;
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
    @JoinColumn(name="PRODUCT_ID", nullable=false)
    private Product product;
}
