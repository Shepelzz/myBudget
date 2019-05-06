package com.myBudget.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY_TYPE")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class CategoryType extends AbstractEntity {

    @Column(name = "NAME")
    private String name;

}
