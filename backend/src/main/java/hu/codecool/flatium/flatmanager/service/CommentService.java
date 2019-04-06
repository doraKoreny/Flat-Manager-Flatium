package hu.codecool.flatium.flatmanager.service;

import hu.codecool.flatium.flatmanager.model.forum.Comment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void deleteComment(int commentId){
        this.comments = comments.stream()
                        .filter(comment -> comment.getId() != commentId)
                        .collect(Collectors.toList());
    }

    public void updateComment(int commentId,String message){
        comments.forEach(comment ->{
            if (comment.getId() == commentId) {
                comment.setMessage(message);
                comment.setTimeStamp(LocalDate.now());
            }
        });
    }

    public Comment getComment(int commentId){
        for (Comment comment: comments){
            if(comment.getId() == commentId){
                return comment;
            }
        }
        return null;
    }

    public List<Comment> getComments(){
        return this.comments;
    }

}
