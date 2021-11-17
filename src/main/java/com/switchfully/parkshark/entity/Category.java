package com.switchfully.parkshark.entity;

import javax.persistence.*;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cat_id")
    private int id;

    @Column(name = "cat_name")
    private String categoryName;

    public Category() {
    }


    private Category(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }


    public static final class CategoryBuilder {
        private int id;
        private String categoryName;

        private CategoryBuilder() {
        }

        public static CategoryBuilder aCategory() {
            return new CategoryBuilder();
        }

        public CategoryBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public CategoryBuilder withCategoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public Category build() {
            return new Category(id, categoryName);
        }
    }

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
