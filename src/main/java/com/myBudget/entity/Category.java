package com.myBudget.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Category extends AbstractEntity{

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name="CATEGORY_TYPE_ID")
    private CategoryType categoryType;


    
}
