package com.lln.api.service.impl;

import com.lln.api.domain.Feedback;
import com.lln.api.mapper.FeedbackMapper;
import com.lln.api.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author LiLinnan
 * @version 1.0
 * @date 2020/6/19 18:46
 */

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackMapper feedbackMapper;

    private final JavaMailSender javaMailSender;

    @Autowired
    public FeedbackServiceImpl(FeedbackMapper feedbackMapper, JavaMailSender javaMailSender) {
        this.feedbackMapper = feedbackMapper;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void feedback(Feedback feedback) {
        feedbackMapper.insert(feedback);
        sendMail(feedback);
    }

    private void sendMail(Feedback feedback) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("闪暖历史头像查询反馈");
        simpleMailMessage.setText(String.format("联系方式：%s\n反馈内容：%s", feedback.getContact(), feedback.getFeedback()));
        simpleMailMessage.setFrom("sntx_feedback@163.com");
        simpleMailMessage.setTo("1170909542@qq.com");
        javaMailSender.send(simpleMailMessage);
    }
}
