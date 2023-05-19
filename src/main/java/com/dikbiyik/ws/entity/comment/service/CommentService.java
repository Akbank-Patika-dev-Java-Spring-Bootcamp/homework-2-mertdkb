package com.dikbiyik.ws.entity.comment.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dikbiyik.ws.base.BaseAdditionalFields;
import com.dikbiyik.ws.base.service.BaseService;
import com.dikbiyik.ws.entity.comment.Comment;
import com.dikbiyik.ws.entity.comment.dto.CommentPostDtoRequest;
import com.dikbiyik.ws.entity.comment.dto.CommentPostDtoResponse;
import com.dikbiyik.ws.entity.comment.mapper.CommentMapper;
import com.dikbiyik.ws.entity.comment.repository.CommentRepository;
import com.dikbiyik.ws.entity.product.Product;
import com.dikbiyik.ws.entity.product.repository.ProductRepository;
import com.dikbiyik.ws.entity.user.User;
import com.dikbiyik.ws.entity.user.repository.UserRepository;

@Service
public class CommentService extends BaseService<Comment, CommentRepository>{
    
    private final CommentMapper commentMapper;

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper, ProductRepository productRepository, UserRepository userRepository){
        super(commentRepository);
        this.commentMapper = commentMapper;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public CommentPostDtoResponse postComment(CommentPostDtoRequest dtoRequest){
        Product product = productRepository.findById(dtoRequest.productId()).orElseThrow();
        User user = userRepository.findById(dtoRequest.userId()).orElseThrow();

        Comment comment = commentMapper.commentPostDtoRequestToComment(dtoRequest);
        comment.setProduct(product);
        comment.setUser(user);

        return commentMapper.commentToCommentPostDtoResponse(this.save(comment));
    }

    @Override
    public void delete(Comment entity) {
        // TODO Auto-generated method stub
        super.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        super.deleteById(id);
    }

    @Override
    public List<Comment> findAll() {
        // TODO Auto-generated method stub
        return super.findAll();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        // TODO Auto-generated method stub
        return super.findById(id);
    }

    @Override
    public Comment findByIdWithControl(Long id) {
        // TODO Auto-generated method stub
        return super.findByIdWithControl(id);
    }

    @Override
    public boolean isExist(Long id) {
        // TODO Auto-generated method stub
        return super.isExist(id);
    }

    @Override
    public Comment save(Comment entity) {
        // TODO Auto-generated method stub
        return super.save(entity);
    }
}
