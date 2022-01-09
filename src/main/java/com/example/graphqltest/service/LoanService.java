package com.example.graphqltest.service;

import com.example.graphqltest.mapper.LoanMapper;
import com.example.graphqltest.model.LoanModel;
import com.example.graphqltest.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    @Transactional
    public List<LoanModel> getLoans() {
        return loanMapper.toModel(loanRepository.findAll());
    }

    @Transactional
    public LoanModel getLoanById(Long id) {
        return loanMapper.toModel(loanRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Transactional
    public LoanModel saveLoan(LoanModel post) {
        return loanMapper.toModel(loanRepository.save(loanMapper.toEntity(post)));
    }

    @Transactional
    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}
