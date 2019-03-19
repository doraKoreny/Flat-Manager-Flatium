package hu.codecool.flatium.flatmanager.controller;

import hu.codecool.flatium.flatmanager.api.CommentUpdateRequest;
import hu.codecool.flatium.flatmanager.model.forum.Comment;
import hu.codecool.flatium.flatmanager.repository.CommentRepository;
import hu.codecool.flatium.flatmanager.repository.FlatUserRepository;
import hu.codecool.flatium.flatmanager.service.CommentService;
import hu.codecool.flatium.flatmanager.service.FlatUserStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
        return "Comment succesfully added"; // make every response JSON
    }

    @GetMapping(path = "/get-comments")
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @DeleteMapping(path = "/delete-comment")
    public String deleteComment(@RequestBody int commentId) {
        commentRepository.deleteById(commentId);
        return "Comment succesfully deleted";
    }

    @PostMapping(path = "/update-comment")
    public String updateComment(@RequestBody CommentUpdateRequest commentUpdateRequest) {
        Comment comment = commentRepository.findById(commentUpdateRequest.getCommentId()).orElseThrow(()->new IllegalStateException("no comment"));
        comment.setMessage(commentUpdateRequest.getComment());
        commentRepository.save(comment);


        return "Comment succesfully updated";
    }

}
