package com.lln.api.controller;

import com.lln.api.domain.AvatarRequestBody;
import com.lln.api.domain.Message;
import com.lln.api.service.GetAvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiLinnan
 * @version 1.0
 * @date 2020/6/5 1:26
 */

@RestController
@CrossOrigin
@RequestMapping("/get-avatar")
public class AvatarController {

    private final GetAvatarService getAvatarService;

    @Autowired
    public AvatarController(GetAvatarService getAvatarService) {
        this.getAvatarService = getAvatarService;
    }

    @GetMapping("/{type}/{uid}")
    public Message getAvatar2(@PathVariable String type, @PathVariable String uid) {
        if (type == null || uid == null) {
            return Message.builder().status(400).message("请输入信息").build();
        }

        return Message.builder()
                .status(200)
                .message(getAvatarService.getAvatar(uid, type))
                .build();
    }
}
