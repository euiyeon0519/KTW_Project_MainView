package com.example.kicktheworld_test.Stay.Repository;

import com.example.kicktheworld_test.Stay.Entity.Stay;
import com.example.kicktheworld_test.Stay.dto.StaySearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StayRepositoryCustom {
    Page<Stay> getAdminStayPage(StaySearchDto staySearchDto, Pageable pageable);
}
