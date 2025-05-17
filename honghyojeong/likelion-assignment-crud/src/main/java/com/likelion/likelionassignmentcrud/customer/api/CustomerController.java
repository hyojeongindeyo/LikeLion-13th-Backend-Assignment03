package com.likelion.likelionassignmentcrud.customer.api;

import com.likelion.likelionassignmentcrud.customer.api.dto.request.CustomerSaveRequestDto;
import com.likelion.likelionassignmentcrud.customer.api.dto.response.CustomerInfoResponseDto;
import com.likelion.likelionassignmentcrud.customer.api.dto.response.CustomerListResponseDto;
import com.likelion.likelionassignmentcrud.customer.application.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<String> customerSave(@RequestBody CustomerSaveRequestDto customerSaveRequestDto) {
        customerService.customerSave(customerSaveRequestDto);
        return new ResponseEntity<>("사용자 저장!", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<CustomerListResponseDto> customerFindAll() {
        CustomerListResponseDto customerListResponseDto = customerService.customerFindAll();
        return new ResponseEntity<>(customerListResponseDto, HttpStatus.OK);
    }

    // 회원 id를 통해 특정 사용자 조회
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerInfoResponseDto> customerFindOne(@PathVariable("customerId") Long customerId) {
        CustomerInfoResponseDto customerInfoResponseDto = customerService.customerFindOne(customerId);
        return new ResponseEntity<>(customerInfoResponseDto, HttpStatus.OK);
    }
}
