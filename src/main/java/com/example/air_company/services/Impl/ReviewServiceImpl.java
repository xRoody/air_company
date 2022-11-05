package com.example.air_company.services.Impl;

import com.example.air_company.domain.Review;
import com.example.air_company.repositories.ReviewRepo;
import com.example.air_company.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepo reviewRepo;

    public Flux<Review> findAll(){
        return reviewRepo.findAll(Sort.unsorted());
    }

    public Mono<Review> findById(Long id){
        return reviewRepo.findById(id);
    }

    public Mono<Void> delete(Long id){
        return reviewRepo.deleteById(id);
    }

    public Mono<Review> save(Review review){
        return reviewRepo.save(review);
    }

    public Flux<Review> findAllByUser(Integer id, Pageable pageable){
        return reviewRepo.findAllByUserId(id, pageable);
    }

    public Flux<Review> findAllByCompany(Integer id, Pageable pageable){
        return reviewRepo.findAllByCompanyId(id, pageable);
    }

    public Mono<Review> update(Review review, Long id){
        return reviewRepo.findById(id).flatMap(x->{
            if (review.getInfo()!=null) x.setInfo(review.getInfo());
            if (review.getReviewRating()!=null) x.setReviewRating(review.getReviewRating());
            if (review.getCompanyId()!=null) x.setCompanyId(review.getCompanyId());
            if (review.getSetRating()!=null) x.setSetRating(review.getSetRating());
            if (review.getTicketId()!=null) x.setTicketId(review.getTicketId());
            if (review.getUserId()!=null) x.setUserId(review.getUserId());
            if (review.getDateTime()!=null) x.setDateTime(review.getDateTime());
            return reviewRepo.save(x);
        });
    }
}
