package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.CreateCategoryDTO;
import com.switchfully.parkshark.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CreateCategoryDTO createCategoryDTO){
        return Category.CategoryBuilder.aCategory()
                .withCategoryName(createCategoryDTO.getCategoryName())
                .build();
    }

}
