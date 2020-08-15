package com.at2t.blip.controller;

import com.at2t.blip.dto.ParentProfileDto;
import com.at2t.blip.service.ParentLoginService;
import com.at2t.blip.util.BlipResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParentProfileController {

    @Autowired
    ParentLoginService parentLoginService;

    @RequestMapping(value = "/parent/profile/{parentId}", method = RequestMethod.GET)
    public BlipResponse getParentProfile(@PathVariable int parentId) {
        return parentLoginService.getParentProfile(parentId);
    }

    @RequestMapping(value = "/parent/profile", method = RequestMethod.POST)
    public BlipResponse updateProfile(@RequestBody ParentProfileDto parentProfileDto) {
        return parentLoginService.updateProfile(parentProfileDto);
    }

}
