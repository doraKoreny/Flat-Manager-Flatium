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

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;


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
                .birthDate(LocalDate.of(1998, 12, 29))
                .build();
        Comment comment = new Comment(0, "This is the message by Something");
        flatUserRepository.saveAndFlush(flatUser);
        commentRepository.saveAndFlush(comment);

        List<Comment> commentList = commentRepository.findAll();
        Assert.assertEquals(1, commentList.size());
    }

}