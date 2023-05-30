package com.nocountry.backend.controller.productController;

import com.nocountry.backend.dto.product.SubcategoryDTO;
import com.nocountry.backend.model.entity.Subcategory;
import com.nocountry.backend.repository.product_repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/subcategories")
public class SubCategoryController {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    //todo get children category***********************************************

    @GetMapping
    public ResponseEntity<List<SubcategoryDTO>> getAllSubcategories() {

        List<Subcategory> subcategories = subcategoryRepository.findAll();

        if (subcategories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<SubcategoryDTO> subcategoryDTOs = new ArrayList<>();

        for (Subcategory subcategory : subcategories) {
            SubcategoryDTO subcategoryDTO = new SubcategoryDTO();
            subcategoryDTO.setId(subcategory.getId());
            subcategoryDTO.setName(subcategory.getName());

            subcategoryDTOs.add(subcategoryDTO);
        }

        return ResponseEntity.ok(subcategoryDTOs);
    }

}
