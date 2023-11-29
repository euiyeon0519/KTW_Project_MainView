package com.example.kicktheworld_test.Attraction.Service;


import com.example.kicktheworld_test.Attraction.Dto.AddAttractionRequest;
import com.example.kicktheworld_test.Attraction.Dto.UpdateAttractionRequest;
import com.example.kicktheworld_test.Attraction.Entity.Attraction;
import com.example.kicktheworld_test.Attraction.Repository.AttractionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AttractionService {

    private final AttractionRepository attractionRepository;

    public Attraction save(AddAttractionRequest request) {return attractionRepository.save(request.toEntity());}

    // 페이징
    public Page<Attraction> findAll(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return this.attractionRepository.findAll(pageable);
    }

    public Attraction findById(long id){
        return attractionRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found : " + id));
    }

    public void delete(long id) {attractionRepository.deleteById(id);}

    @Transactional
    public Attraction update(long id, UpdateAttractionRequest request){
        Attraction attraction = attractionRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found : " + id));

        attraction.update(request.getName(), request.getCategory(), request.getLocation(),
                request.getAddress(), request.getDetail());

        return attraction;
    }
    

}
