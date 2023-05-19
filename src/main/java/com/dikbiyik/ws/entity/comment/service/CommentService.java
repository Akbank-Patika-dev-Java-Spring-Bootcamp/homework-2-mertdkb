package com.dikbiyik.ws.entity.comment.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dikbiyik.ws.base.BaseAdditionalFields;
import com.dikbiyik.ws.base.service.BaseService;
import com.dikbiyik.ws.entity.comment.Comment;
import com.dikbiyik.ws.entity.comment.dto.CommentGetResponseDto;
import com.dikbiyik.ws.entity.comment.dto.CommentPostRequestDto;
import com.dikbiyik.ws.entity.comment.dto.CommentPostResponseDto;
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

    public CommentPostResponseDto postComment(CommentPostRequestDto dtoRequest){
        Product product = productRepository.findById(dtoRequest.productId()).orElseThrow();
        User user = userRepository.findById(dtoRequest.userId()).orElseThrow();

        Comment comment = commentMapper.commentPostDtoRequestToComment(dtoRequest);
        comment.setProduct(product);
        comment.setUser(user);

        return commentMapper.commentToCommentPostDtoResponse(this.save(comment));
    }

    public void deleteComment(Long id){
        this.deleteById(id);
    }

    //users comments
    public List<CommentGetResponseDto> getAllUserCommentsByUserId(Long id){
        User user = userRepository.findById(id).orElseThrow();
        return commentMapper.commentsToCommentGetResponseDtos(user.getComments());
    }

    //products comment
    public List<CommentGetResponseDto> getAllProductCommentsByProductId(Long id){
        Product product = productRepository.findById(id).orElseThrow();
        return commentMapper.commentsToCommentGetResponseDtos(product.getComments());
    }


}
