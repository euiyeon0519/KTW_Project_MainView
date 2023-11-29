package com.example.kicktheworld_test.Eatery.Dto;

import com.example.kicktheworld_test.Eatery.Entity.Eatery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EateryDto {

    private Long id;
    private String code;
    private String category;
    private String name;
    private String location;
    private String address;
    private String detail;

    // entity -> dto, dto에 entity 필드값을 매핑
    public static EateryDto fromEntity(Eatery eatery) {
        return new EateryDto(
                eatery.getId(),
                eatery.getCode(),
                eatery.getCategory(),
                eatery.getName(),
                eatery.getLocation(),
                eatery.getAddress(),
                eatery.getDetail()
        );
    }

    // entity list -> dto list
    public static List<EateryDto> listFromEntities(List<Eatery> eateries) {
        return eateries.stream()
                .map(EateryDto::fromEntity) // entity -> dto
                .collect(Collectors.toList());
    }

    // dto list -> entity list
    public static List<Eatery> listToEntities(List<EateryDto> eateryDtos) {
        return eateryDtos.stream()
                .map(EateryDto::toEntity) // dto -> entity
                .collect(Collectors.toList());
    }

    // dto -> entity, entity에 dto 필드값을 매핑
    public Eatery toEntity() {
        return Eatery.builder()
//                .id(id)
                .code(code)
                .category(category)
                .name(name)
                .location(location)
                .address(address)
                .detail(detail)
                .build();
    }


    // dto 정보 -> entity update
    public void updateEntity(Eatery eatery) {
        eatery.update(code, category, name, location, address, detail);
    }
}



