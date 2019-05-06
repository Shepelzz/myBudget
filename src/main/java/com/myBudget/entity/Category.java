package com.myBudget.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Category extends AbstractEntity{

    @Column(name = "NAME")
    private String name;

    
}
