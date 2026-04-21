package com.example.sample.repository;

import com.example.sample.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    // 필요한 쿼리 메서드를 추가하세요.
    // 예: List<Item> findByNameContaining(String name);
}
