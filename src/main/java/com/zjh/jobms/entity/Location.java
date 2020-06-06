package com.zjh.jobms.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Data
@NoArgsConstructor
public class Location extends BaseEntity{

    private String city;

    private String state;

    private String country;
}
