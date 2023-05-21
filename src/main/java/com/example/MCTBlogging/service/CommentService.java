package com.example.MCTBlogging.service;

import com.example.MCTBlogging.dao.CommentRepo;
import com.example.MCTBlogging.model.Comment;
import com.example.MCTBlogging.util.CommentValidation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepo commentRepository;
    @Autowired
    CommentValidation commentValidation;

    public int postComment(Comment comments) {
        return commentRepository.save(comments).getCommentId();
    }

    public JSONArray getById(String postId, String commentId) {
        JSONArray responseArray = new JSONArray();
        if (null != commentId && commentRepository.findById(Integer.valueOf(commentId)).isPresent()) {
            Comment comments = commentRepository.findById(Integer.valueOf(commentId)).get();
            JSONObject json = commentValidation.convertingComment(comments);
            responseArray.put(json);
        }
        return responseArray;
    }

    public JSONArray getAllComment() {
        JSONArray response = new JSONArray();
        List<Comment> commentList = commentRepository.findAll();
        for (Comment comments : commentList) {
            JSONObject json = commentValidation.convertingComment(comments);
            response.put(json);
        }
        return response;
    }

    public void put(String commentId, Comment updateComment) {
        if (null != commentId && commentRepository.findById(Integer.valueOf(commentId)).isPresent()) {
            Comment olderComment = commentRepository.findById(Integer.valueOf(commentId)).get();
            olderComment.setDescription(updateComment.getDescription());
            olderComment.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            olderComment.setPost(updateComment.getPost());
            olderComment.setCommentLikes(updateComment.getCommentLikes());
            commentRepository.save(olderComment);
        }
    }

    public void delete(String commentId) {
        commentRepository.deleteById(Integer.valueOf(commentId));
    }
}
