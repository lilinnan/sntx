package com.lln.api.controller;

import com.lln.api.domain.AvatarRequestBody;
import com.lln.api.domain.Message;
import com.lln.api.service.GetAvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiLinnan
 * @version 1.0
 * @date 2020/6/5 1:26
 */

@RestController
@CrossOrigin
public class AvatarController {

    private final GetAvatarService getAvatarService;

    @Autowired
    public AvatarController(GetAvatarService getAvatarService) {
        this.getAvatarService = getAvatarService;
    }

    @PostMapping("/getAvatar")
    public Message getAvatar(@RequestBody AvatarRequestBody avatarRequestBody) {
        if (avatarRequestBody.getUid() == null) {
            return Message.builder().status(400).message("请输入您的ID").build();
        }

        return Message.builder()
                .status(200)
                .message(getAvatarService.getAvatar(avatarRequestBody.getUid(), avatarRequestBody.getType()))
                .build();
    }
}
