package com.dikbiyik.ws.base;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class BaseAdditionalFields {
    @Column(name = "ID_CUSTOMER_CREATED_BY")
    private Long createdBy;
  
    @Column(name = "ID_CUSTOMER_UPDATE_BY")
    private Long updatedBy;
  
    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;
  
    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;
}
