package hu.codecool.flatium.flatmanager.repository;

import hu.codecool.flatium.flatmanager.model.forum.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
