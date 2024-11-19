package org.example.ecommerce.repository;

import org.example.ecommerce.entity.Category;
import org.example.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}

