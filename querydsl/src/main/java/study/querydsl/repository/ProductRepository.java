package study.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.querydsl.entity.Product;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    // 쿼리 메서드 - 인기상품 10위 반환
//    List<Product> findTop10ByOrderByPopularityDesc();
//
//    // 쿼리 어노테이션 - 최근 등록 상품 중 인기 10위 반환
//    @Query("SELECT p FROM Product p WHERE p.createdAt >= :startDate ORDER BY p.popularity DESC")
//    List<Product> findRecentPopularProducts(@Param("startDate") LocalDateTime startDate, Pageable pageable);
}