package com.example.kicktheworld_test.Eatery.Repository;

import com.example.kicktheworld_test.Eatery.Entity.Eatery;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// crud 제공
public interface EateryRepository extends JpaRepository<Eatery, Long> {

}
