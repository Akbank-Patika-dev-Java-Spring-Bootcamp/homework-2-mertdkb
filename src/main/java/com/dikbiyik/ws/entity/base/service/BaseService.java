package com.dikbiyik.ws.entity.base.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.dikbiyik.ws.entity.base.BaseAdditionalFields;
import com.dikbiyik.ws.entity.base.BaseEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BaseService<E extends BaseEntity, R extends JpaRepository<E, Long>> {
    
    private final R repository;

    public E save(E entity){

        BaseAdditionalFields baseAdditionalFields = entity.getBaseAdditionalFields();
        
        if (baseAdditionalFields == null){
          baseAdditionalFields = new BaseAdditionalFields();
        }
    
        if (entity.getId()  == null){
          baseAdditionalFields.setCreateDate(LocalDateTime.now());
        }
    
        baseAdditionalFields.setUpdateDate(LocalDateTime.now());
    
        entity.setBaseAdditionalFields(baseAdditionalFields);
        entity = repository.save(entity);
    
        return entity;
      }
    
      public List<E> findAll() {
        return repository.findAll();
      }
    
      public void deleteById(Long id){
        repository.deleteById(id);
      }
    
      public void delete(E entity){
        repository.delete(entity);
      }
    
      public Optional<E> findById(Long id){
        return repository.findById(id);
      }
    
      public E findByIdWithControl(Long id){
        return repository.findById(id).orElseThrow();
      }
    
      public boolean isExist(Long id){
        return repository.existsById(id);
      }
}
