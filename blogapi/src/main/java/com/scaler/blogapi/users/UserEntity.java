package com.scaler.blogapi.users;

import com.scaler.blogapi.articles.ArticleEntity;
import com.scaler.blogapi.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter

@ToString
@Entity(name = "users")
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class UserEntity extends BaseEntity {

    @NonNull
    @Column(nullable = false,unique = true,length = 30)
    String userName;

    @NonNull
    @Column(nullable = false,unique = true,length = 50)
    String email;

    @NonNull
    @Column(nullable = false)
    String password;

    @Column
    String bio;

    @ManyToMany(targetEntity = UserEntity.class,mappedBy = "following")
    List<UserEntity> followers;

    @ManyToMany
    List<UserEntity> following;

    @ManyToMany(targetEntity = ArticleEntity.class,mappedBy = "likes")
    List<ArticleEntity> favouriteArticles;



}
