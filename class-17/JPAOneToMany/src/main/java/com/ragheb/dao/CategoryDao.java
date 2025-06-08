package com.ragheb.dao;

import entity.Category;

public interface CategoryDao {

    void saveCategory(Category category);

    Category fetchCategory(Integer categoryId);

    void removeCategory(Integer categoryId);
}
