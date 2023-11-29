package com.example.kicktheworld_test.Eatery.Service;

import com.example.kicktheworld_test.Eatery.Dto.EateryDto;
import com.example.kicktheworld_test.Eatery.Entity.Eatery;
import com.example.kicktheworld_test.Eatery.Repository.EateryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EateryService {

    private final EateryRepository eateryRepository;

    // 추가
    public EateryDto save(EateryDto eateryDto) {
        Eatery savedEatery = eateryRepository.save(eateryDto.toEntity());
        return EateryDto.fromEntity(savedEatery);
    }

    // 전체 조회
    public List<EateryDto> findAll() {
        List<Eatery> eateries = eateryRepository.findAll();
        return EateryDto.listFromEntities(eateries);
    }

    // 단건 조회
    public EateryDto findById(long id) {
        Eatery eatery = eateryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
        return EateryDto.fromEntity(eatery);
    }

    // 삭제
    public void delete(long id) {
        eateryRepository.deleteById(id);
    }

    // 수정
    @Transactional
    public EateryDto update(long id, EateryDto eateryDto) {
        Eatery eatery = eateryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
        eateryDto.updateEntity(eatery);
        return EateryDto.fromEntity(eatery);
    }
}

