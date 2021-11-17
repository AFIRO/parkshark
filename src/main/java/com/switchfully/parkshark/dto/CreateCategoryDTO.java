package com.switchfully.parkshark.dto;

public class CreateCategoryDTO {

    private final String categoryName;

    private CreateCategoryDTO(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }


    public static final class CreateCategoryDTOBuilder {
        private String categoryName;

        private CreateCategoryDTOBuilder() {
        }

        public static CreateCategoryDTOBuilder aCreateCategoryDTO() {
            return new CreateCategoryDTOBuilder();
        }

        public CreateCategoryDTOBuilder withCategoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public CreateCategoryDTO build() {
            return new CreateCategoryDTO(categoryName);
        }
    }
}
