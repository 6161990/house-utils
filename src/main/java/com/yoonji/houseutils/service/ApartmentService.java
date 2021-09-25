package com.yoonji.houseutils.service;

import com.yoonji.houseutils.exception.ErrorCode;
import com.yoonji.houseutils.exception.HouseUtilsException;
import com.yoonji.houseutils.repository.ApartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;

    @Transactional
    public Long getPriceOrThrow(Long apartmentId){ // 금액을 가져오거나 예외를 던져주거나
        return apartmentRepository.findById(apartmentId)
                .orElseThrow(()-> new HouseUtilsException(ErrorCode.ENTITY_NOT_FOUND))
                //여기까지 담아온 것을 변수로 따로 뽑아 그것을 getPrice할 수 있으나 그건 불필요한 지역변수임
                .getPrice();
    }

}
