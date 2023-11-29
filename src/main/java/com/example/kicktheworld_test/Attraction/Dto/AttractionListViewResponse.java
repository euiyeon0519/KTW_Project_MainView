package com.example.kicktheworld_test.Attraction.Dto;

import com.example.kicktheworld_test.Attraction.Entity.Attraction;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AttractionListViewResponse {

    private Long id;
    private String name;
    private String category;
    private String location;
    private String address;
    private String detail;

    public AttractionListViewResponse(Attraction attraction){
        this.id = attraction.getId();
        this.name = attraction.getName();
        this.category = attraction.getCategory();
        this.location = attraction.getLocation();
        this.address = attraction.getAddress();
        this.detail = attraction.getDetail();

    }
}