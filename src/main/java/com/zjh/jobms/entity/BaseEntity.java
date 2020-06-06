package com.zjh.jobms.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class BaseEntity {

    @Id
    @Column(length = 36)
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    @Column(nullable = false,columnDefinition = "timestamp default current_timestamp")
    private Date createdDate;

    @Column(nullable = false,columnDefinition = "timestamp default current_timestamp")
    private Date modifiedDate;

    @Column(length = 36)
    private String createUser;

    @Column(length = 36)
    private String updateUser;
}
