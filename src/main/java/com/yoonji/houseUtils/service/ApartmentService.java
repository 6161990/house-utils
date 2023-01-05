package com.yoonji.houseUtils.service;

import com.yoonji.houseUtils.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;

    @Transactional
    public Long priceOrThrow(Long apartmentId){ // 금액을 가져오거나 예외를 던지거나 이니까, 그 전부를 포괄하는 메소드 이름
        return apartmentRepository.findById(apartmentId)
                .orElseThrow(() -> new IllegalArgumentException(""))
                .getPrice();
    }
}
