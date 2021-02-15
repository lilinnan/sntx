package com.lln.api.controller;

import com.lln.api.domain.Feedback;
import com.lln.api.domain.Message;
import com.lln.api.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author LiLinnan
 * @version 1.0
 * @date 2020/6/19 18:54
 */

@RestController
@CrossOrigin
public class FeedbackController {
    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/feedback")
    public Message feedback(@RequestBody @Valid Feedback feedback) {
        feedbackService.feedback(feedback);
        return Message.builder().status(200).message("反馈成功").build();
    }
}
