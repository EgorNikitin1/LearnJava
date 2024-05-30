package ru.muctr.Task12.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.muctr.Task12.models.Guitar;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuitarsRepository extends JpaRepository<Guitar, Integer> {
    List<Guitar> findAllByPriceLessThan(int price);
    List<Guitar> findFirstByName(String name);

}
