package com.zep.reviewms.reviews.messaging;

import com.zep.reviewms.reviews.Reviews;
import com.zep.reviewms.reviews.dtos.ReviewMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReviewMessageProducer {
    private  final RabbitTemplate rabbitTemplate;

    public ReviewMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public  void  sendMessage(Reviews reviews){
        ReviewMessage reviewMessage=new ReviewMessage();
        reviewMessage.setId(reviews.getId());
        reviewMessage.setTitle(reviewMessage.getTitle());
        reviewMessage.setDescription(reviewMessage.getDescription());
        reviewMessage.setRating(reviewMessage.getRating());
        reviewMessage.setCompanyId(reviews.getCompanyId());
        rabbitTemplate.convertAndSend("companyRatingQueue",reviewMessage);
    }
}
