package com.example.graphqltest.controller;

import com.example.graphqltest.model.LoanModel;
import com.example.graphqltest.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoanController {

    // 1. 작성한 서비스를 가져오고
    private final LoanService loanService;

    // 2. 서비스를 사용하기 위한 생성자를 만들어줍니다.
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    // 1) 메인 페이지로 접근
    // 2) Feign Client가 /testfeign 으로 get 호출
    // 3) 반환값 받고 메인에서 보여줍니다.
    @GetMapping("/loans")
    public List<LoanModel> loans() {
        return loanService.getLoans();
    }

    @GetMapping("/loan/{id}")
    public LoanModel getLoanById(@PathVariable Long id) {
        return loanService.getLoanById(id);
    }

    @PostMapping("/loan")
    public LoanModel saveLoan(@RequestBody LoanModel post) {
        return loanService.saveLoan(post);
    }

    @PostMapping("/delete-loan")
    public void deleteLoan(Long id) {
        loanService.deleteLoan(id);
    }

}