package com.igo.apiDelivery.repository;

import com.igo.apiDelivery.model.Bag;
import com.igo.apiDelivery.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
