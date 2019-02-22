package hu.codecool.flatium.flatmanager.controller;

import hu.codecool.flatium.flatmanager.api.CommentUpdateRequest;
import hu.codecool.flatium.flatmanager.building.Building;
import hu.codecool.flatium.flatmanager.forum.Comment;
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

    @RequestMapping(
            path = "/get-comments",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<List<Comment>> getComments() {
        return ResponseEntity.ok(commentService.getComments());
    }

    @RequestMapping(
            path = "/delete-comment",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<String> deleteComment(@RequestBody int commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok("Comment succesfully deleted");
    }

    @RequestMapping(
            path = "/update-comment",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<String> updateComment(@RequestBody CommentUpdateRequest commentUpdateRequest) {
        commentService.updateComment(commentUpdateRequest.getCommentId(),commentUpdateRequest.getComment());
        return ResponseEntity.ok("Comment succesfully updated");
    }

}
