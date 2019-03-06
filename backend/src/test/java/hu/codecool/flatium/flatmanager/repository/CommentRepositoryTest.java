package hu.codecool.flatium.flatmanager.repository;

import hu.codecool.flatium.flatmanager.model.flat.Person;
import hu.codecool.flatium.flatmanager.model.flat.contacts.PersonType;
import hu.codecool.flatium.flatmanager.model.forum.Comment;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private FlatUserRepository flatUserRepository;

    @Test
    public void saveOneSimple() {
        Person flatUser = Person.builder()
                .name("Something")
                .email("something@codecool.hu")
                .phoneNumber("06803889876")
                .type(PersonType.FLATUSER)
                .build();
        Comment comment = new Comment(1, "This is the message by Something");
        comment.setFlatUserId(1);
        flatUserRepository.save(flatUser);
        commentRepository.save(comment);

        List<Comment> commentList = commentRepository.findAll();
        Assert.assertEquals(1, commentList.size());
    }

}