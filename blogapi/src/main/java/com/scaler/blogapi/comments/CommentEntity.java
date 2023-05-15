package com.scaler.blogapi.comments;

import com.scaler.blogapi.articles.ArticleEntity;
import com.scaler.blogapi.common.BaseEntity;
import com.scaler.blogapi.users.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Getter
@Entity(name="comments")
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CommentEntity  extends BaseEntity {

    @Column(length = 100)
    String title;

    @Column(nullable = false,length = 1000)
    String body;

    @ManyToOne
    UserEntity author;

    @ManyToOne
    ArticleEntity article;


}
