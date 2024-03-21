package com.sixcandoit.plrecipe_post.feature.post;

import com.sixcandoit.plrecipe_post.query.aggregate.MemberCount;
import com.sixcandoit.plrecipe_post.query.dto.PostDTO;
import com.sixcandoit.plrecipe_post.query.dto.PostHashtagDTO;
import com.sixcandoit.plrecipe_post.query.dto.PostLikeDTO;
import com.sixcandoit.plrecipe_post.command.service.CommandPostServiceImpl;
import com.sixcandoit.plrecipe_post.query.service.PostServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CommandPostServiceImplTestsByMyBatis {

    @Autowired
    private PostServiceImpl postServiceImpl;

    @Test
    void selectAllPost() {

        List<PostDTO> posts = postServiceImpl.selectAllPost();
        posts.forEach(System.out::println);

        assertNotNull(posts);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void selectPost(int postId) {
        List<PostDTO> postList = postServiceImpl.selectPost(postId);

        postList.forEach(System.out::println);

        assertTrue(!postList.isEmpty());
    }

//    @ParameterizedTest
//    @ValueSource(ints = {1, 2})
//    void selectMemberPosts(int memberId) {
//        List<PostDTO> postList = postServiceImpl.selectMemberPosts(memberId);
//
//        postList.forEach(System.out::println);
//
//        assertTrue(!postList.isEmpty());
//    }

    @ParameterizedTest
    @ValueSource(strings = {"Y", "N"})
    void selectPostsByStatus(String postStatus) {
        List<PostDTO> postList = postServiceImpl.selectPostsByStatus(postStatus);

        postList.forEach(System.out::println);

        assertTrue(!postList.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"ONE", "TWO", "MANY"})
    void selectPostsByMemberCounts(MemberCount memberCount) {
        List<PostDTO> postList = postServiceImpl.selectPostsByMemberCounts(memberCount);

        postList.forEach(System.out::println);

        assertTrue(!postList.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {1})
    void selectPostHashtags(int postId) {
        List<PostHashtagDTO> postList = postServiceImpl.selectPostHashtags(postId);

        postList.forEach(System.out::println);

        assertTrue(!postList.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 8})
    void selectPostByLikes(int postId) {

        List<PostLikeDTO> postList = postServiceImpl.selectPostByLikes(postId);
        postList.forEach(System.out::println);

        assertTrue(!postList.isEmpty());
    }

}
