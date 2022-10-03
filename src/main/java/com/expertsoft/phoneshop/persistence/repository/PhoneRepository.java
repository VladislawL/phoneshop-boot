package com.expertsoft.phoneshop.persistence.repository;

import com.expertsoft.phoneshop.persistence.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    @Query("select p from Phone p where (upper(p.brand) like upper(concat('%', :query, '%')) " +
            "or upper(p.model) like upper(concat('%', :query, '%'))) " +
            "and p.price between :priceStart and :priceEnd")
    Page<Phone> findPhonesByQueryAndPrice(@Param("query") String brand,
                                          @Param("priceStart") BigDecimal priceStart,
                                          @Param("priceEnd") BigDecimal priceEnd,
                                          Pageable pageable);

}
