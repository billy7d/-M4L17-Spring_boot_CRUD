package com.example.crud.service.province;

import com.example.crud.model.Customer;
import com.example.crud.model.Province;

import java.util.Optional;

public interface ProvinceService {
    Iterable<Province> findAll();
    Optional<Province> findById(Integer id);
    Province save(Province province);
    void remove(Integer id);
}
