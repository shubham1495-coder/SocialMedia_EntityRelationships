package com.Social.media;

import com.Social.media.Repository.PostRepository;
import com.Social.media.Repository.SocialGroupRepository;
import com.Social.media.Repository.SocialProfileRepository;
import com.Social.media.Repository.SocialUserRepository;
import com.Social.media.models.Post;
import com.Social.media.models.SocialGroup;
import com.Social.media.models.SocialProfile;
import com.Social.media.models.SocialUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    private final SocialUserRepository userRepository;
    private final SocialGroupRepository socialGroupRepository;
    private final SocialProfileRepository socialProfileRepository;
    private final PostRepository postRepository;

    public DataInitializer(SocialUserRepository userRepository, SocialGroupRepository socialGroupRepository, SocialProfileRepository socialProfileRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.socialGroupRepository = socialGroupRepository;
        this.socialProfileRepository = socialProfileRepository;
        this.postRepository = postRepository;
    }

    @Bean
    public CommandLineRunner initializeData(){
        return args -> {
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();
            SocialUser user4 = new SocialUser();

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
            userRepository.save(user4);

            SocialGroup Group1 = new SocialGroup();
            SocialGroup Group2 = new SocialGroup();

            Group1.getSocialUsers().add(user1);
            Group1.getSocialUsers().add(user2);

            Group2.getSocialUsers().add(user3);
            Group2.getSocialUsers().add(user4);

            socialGroupRepository.save(Group1);
            socialGroupRepository.save(Group2);

            user1.getGroups().add(Group1);
            user2.getGroups().add(Group1);
            user3.getGroups().add(Group2);
            user4.getGroups().add(Group2);

//            userRepository.save(user1);
//            userRepository.save(user2);
//            userRepository.save(user3);
//            userRepository.save(user4);

            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();
            Post post4 = new Post();

            post1.setSocialUser(user1);
            post2.setSocialUser(user2);
            post3.setSocialUser(user3);
            post4.setSocialUser(user4);

            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);
            postRepository.save(post4);

            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();
            SocialProfile profile4 = new SocialProfile();

            profile1.setSocialUser(user1);
            user1.setSocialProfile(profile1);
            profile2.setSocialUser(user2);
            user2.setSocialProfile(profile2);
            profile3.setSocialUser(user3);
            user3.setSocialProfile(profile3);
            profile4.setSocialUser(user4);
            user4.setSocialProfile(profile4);

            socialProfileRepository.save(profile1);
            socialProfileRepository.save(profile2);
            socialProfileRepository.save(profile3);
            socialProfileRepository.save(profile4);

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
            userRepository.save(user4);
        };
    }
}
