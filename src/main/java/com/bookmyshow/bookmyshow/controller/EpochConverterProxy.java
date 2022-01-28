package com.bookmyshow.bookmyshow.controller;

import com.bookmyshow.bookmyshow.dto.EpochResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="epoch-converter")
public interface EpochConverterProxy {

    @GetMapping("/epoch/next/{x}/days")
    public ResponseEntity<EpochResponse> getEpochTimeAfterXdays(@PathVariable( name= "x") int x);
}
