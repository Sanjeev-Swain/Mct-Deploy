package com.example.MCTBlogging.util;

import com.example.MCTBlogging.dao.PostRepo;
import com.example.MCTBlogging.model.Comment;
import com.example.MCTBlogging.model.Post;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class CommentValidation {
    @Autowired
    PostRepo postRepository;

    public Comment setComment(String commentData) {
        JSONObject json = new JSONObject(commentData);
        Comment settingComment = new Comment();
        settingComment.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        settingComment.setDescription(json.getString("description"));
        settingComment.setCommentLikes(json.getInt("commentLikes"));

        String postId = json.getString("post");
        Post currentPost = postRepository.findById(Integer.valueOf(postId)).get();
        settingComment.setPost(currentPost);

        return settingComment;
    }

    public JSONObject convertingComment(Comment comments) {
        JSONObject json = new JSONObject();
        json.put("commentId", comments.getCommentId());
        json.put("createdDate", comments.getCreatedDate());
        json.put("description", comments.getDescription());
        json.put("commentLikes", comments.getCommentLikes());

        Post post = comments.getPost();
        JSONObject postObject = new JSONObject();
        postObject.put("postId", post.getPostId());
        postObject.put("postName", post.getPostName());
        json.put("post", postObject);

        return json;
    }
}
