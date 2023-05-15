package com.scaler.blogapi.articles;

import com.scaler.blogapi.common.BaseEntity;
import com.scaler.blogapi.users.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Getter
@Entity(name="articles")
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class ArticleEntity  extends BaseEntity {

    @NonNull
    @Column(nullable = false,length = 150)
    String title;

    @NonNull
    @Column(nullable = false,length = 100)
    String slug;
    @Column(length = 250)
    String subTitle;

    @NonNull
    @Column(nullable = false,length = 3000)
    String body;

    @NonNull
    @ManyToOne
    UserEntity author;

    @ManyToMany(targetEntity = UserEntity.class)
    @JoinTable(
            name = "article_likes",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    List<UserEntity> likes;



}
