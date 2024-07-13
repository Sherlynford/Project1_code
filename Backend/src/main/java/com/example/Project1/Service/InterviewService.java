package com.example.Project1.Service;

import com.example.Project1.Entity.Interview;
import com.example.Project1.Repository.InterviewRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InterviewService {

    private final InterviewRepository interviewRepository;

    public Interview createInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    public Optional<Interview> getInterviewById(Long id) {
        return interviewRepository.findById(id);
    }

    public Interview updateInterview(Interview newInterview, Long id) {
        return interviewRepository.findById(id)
                .map(interview -> {
                    interview.setDate(newInterview.getDate()); 
                    interview.setTime(newInterview.getTime()); 
                    interview.setType(newInterview.getType());
                    interview.setDetail(newInterview.getDetail());
                    interview.setLinkAddress(newInterview.getLinkAddress());
                    
                    return interviewRepository.save(interview);
                })
                .orElseGet(() -> {
                    newInterview.setId(id);
                    return interviewRepository.save(newInterview);
                });
    }


    public void deleteInterview(Long id) {
        interviewRepository.deleteById(id);
    }
}
