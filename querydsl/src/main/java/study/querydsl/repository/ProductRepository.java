package study.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import study.querydsl.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // 쿼리 메서드 - 인기상품 10위 반환
    List<Product> findTop10ByOrderByPopularityDesc();

}