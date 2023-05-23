package com.dikbiyik.ws.comment.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dikbiyik.ws.base.BaseAdditionalFields;
import com.dikbiyik.ws.base.service.BaseService;
import com.dikbiyik.ws.comment.Comment;
import com.dikbiyik.ws.comment.dto.CommentGetResponseDto;
import com.dikbiyik.ws.comment.dto.CommentPostRequestDto;
import com.dikbiyik.ws.comment.dto.CommentPostResponseDto;
import com.dikbiyik.ws.comment.mapper.CommentMapper;
import com.dikbiyik.ws.comment.repository.CommentRepository;
import com.dikbiyik.ws.product.Product;
import com.dikbiyik.ws.product.repository.ProductRepository;
import com.dikbiyik.ws.user.User;
import com.dikbiyik.ws.user.repository.UserRepository;

@Service
public class CommentService extends BaseService<Comment, CommentRepository>{

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, ProductRepository productRepository, UserRepository userRepository){
        super(commentRepository);
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public Comment saveComment(CommentPostRequestDto requestDto) {
        Comment comment = new Comment();
        comment.setCommentBody(requestDto.commentBody());

        User user = userRepository.findById(requestDto.userId()).orElseThrow();
        comment.setUser(user);

        Product product = productRepository.findById(requestDto.productId()).orElseThrow();
        comment.setProduct(product);

        return super.save(comment);
    }


    //users comments
    public List<Comment> getAllUserCommentsByUserId(Long id){
        User user = userRepository.findById(id).orElseThrow();
        return user.getComments();
    }

    //products comment
    public List<Comment> getAllProductCommentsByProductId(Long id){
        Product product = productRepository.findById(id).orElseThrow();
        return product.getComments();
    }

    public void deleteComment(Long id) {
        Comment comment = super.findByIdWithControl(id);
        super.delete(comment);
    }



}
