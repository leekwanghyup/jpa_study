package jpabook.start;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "MEMBER", uniqueConstraints = {
        @UniqueConstraint( // 유니크 제약 조건 추가
                name = "NAME_AGE_UNIQUE",
                columnNames = {"NAME", "AGE"}
        )
})
public class Member {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME", nullable = false, length = 10) // 제약 조건 추가
    private String username;

    private Integer age;

    // == 추가
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;
}
