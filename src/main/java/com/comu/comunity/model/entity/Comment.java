package com.comu.comunity.model.entity;

import com.comu.comunity.dto.CommentRequestDto;
import com.comu.comunity.dto.CommentResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "comment")
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Setter
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;


    @Setter
    @Column(name ="member_id")
    private Long memberId;

    @Setter
    @Column(name ="member_name")
    private String memberName;

    @Setter
    @Column(name = "contents")
    private String contents;


    public  Comment(CommentRequestDto requestDto) {
        this.memberName = requestDto.getName();
        this.contents = requestDto.getContents();
    }

    public void update(CommentRequestDto requestDto) {
        this.memberName = requestDto.getName();
        this.contents = requestDto.getContents();
    }

    public CommentResponseDto to() {
        return new CommentResponseDto(this);
    }
}
