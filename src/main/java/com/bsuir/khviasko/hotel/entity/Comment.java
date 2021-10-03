package com.bsuir.khviasko.hotel.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Data
@EqualsAndHashCode
public class Comment implements Serializable {
    public static final String COMMENT_CLASS_NAME = "Comment";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime createDate;

    @Column(name = "text_comment")
    private String textComment;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id")
    private Room room;
}
