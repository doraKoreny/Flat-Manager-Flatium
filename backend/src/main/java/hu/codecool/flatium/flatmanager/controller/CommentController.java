package hu.codecool.flatium.flatmanager.controller;

import hu.codecool.flatium.flatmanager.api.CommentUpdateRequest;
import hu.codecool.flatium.flatmanager.model.forum.Comment;
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
    FlatUserStorageService flatUserStorage;

    @Autowired
    CommentService commentService;

    @PostMapping(path = "/add-comment")
    public String addComment(@RequestBody Comment comment) {
        commentService.addComment(comment);
        return "Comment succesfully added";
    }

    @GetMapping(path = "/get-comments")
    public ResponseEntity<List<Comment>> getComments() {
        return ResponseEntity.ok(commentService.getComments());
    }

    @DeleteMapping(path = "/delete-comment")
    public ResponseEntity<String> deleteComment(@RequestBody int commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok("Comment succesfully deleted");
    }

    @PostMapping(path = "/update-comment")
    public ResponseEntity<String> updateComment(@RequestBody CommentUpdateRequest commentUpdateRequest) {
        commentService.updateComment(commentUpdateRequest.getCommentId(),commentUpdateRequest.getComment());
        return ResponseEntity.ok("Comment succesfully updated");
    }

}
