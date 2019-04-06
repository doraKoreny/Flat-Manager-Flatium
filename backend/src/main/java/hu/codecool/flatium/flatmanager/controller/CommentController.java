package hu.codecool.flatium.flatmanager.controller;

import hu.codecool.flatium.flatmanager.api.CommentUpdateRequest;
import hu.codecool.flatium.flatmanager.model.forum.Comment;
import hu.codecool.flatium.flatmanager.repository.CommentRepository;
import hu.codecool.flatium.flatmanager.repository.FlatUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    FlatUserRepository flatUserRepository;

    @Autowired
    CommentRepository commentRepository;

    @PostMapping(path = "/add-comment")
    public String addComment(@RequestBody Comment comment) {
        commentRepository.save(comment);
        return "Comment succesfully added";
    }

    @GetMapping(path = "/get-comments")
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @GetMapping(path = "/get-comments/{user-id}")
    public List<Comment> getCommentsByUserId(@PathVariable("user-id") String userId) {
        return commentRepository.findCommentsByFlatUserId(Integer.parseInt(userId));
    }

    @DeleteMapping(path = "/delete-comment")
    public String deleteComment(@RequestBody int commentId, int userId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalStateException("Comment not found."));
        if (comment.getFlatUserId() == userId) {
            commentRepository.deleteById(commentId);
            return "Comment succesfully deleted";
        }
        return "Comment not deleted";
    }

    @PostMapping(path = "/update-comment")
    public String updateComment(@RequestBody CommentUpdateRequest commentUpdateRequest) {
        Comment comment = commentRepository.findById(commentUpdateRequest.getCommentId()).orElseThrow(()->new IllegalStateException("no comment"));
        comment.setMessage(commentUpdateRequest.getComment());
        commentRepository.save(comment);
        return "Comment succesfully updated";
    }

}
