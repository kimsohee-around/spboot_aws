package com.around.soh.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor   //기본생성자 자동 추가
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //auto_increment
    private long id;
    
    @Column(length = 500,nullable = false)
    private String title;
    
    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;
    
    private String author;
    
    @Builder
    public Posts(String title,String content, String author){
        this.title=title;
        this.content = content;
        this.author=author;
    }
        
}
