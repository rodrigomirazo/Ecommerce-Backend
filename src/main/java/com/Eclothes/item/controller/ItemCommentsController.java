package com.Eclothes.item.controller;

import com.Eclothes.item.config.GlobalConstant;
import com.Eclothes.item.constants.EndpointNames;
import com.Eclothes.item.dto.ItemCommentsDto;
import com.Eclothes.item.entity.ItemComments;
import com.Eclothes.item.service.ItemCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class ItemCommentsController {

    private static final String itemCommentsUri = EndpointNames.ITEM_COMMENTS_CONTROLLER;
    
    @Autowired
    private ItemCommentsService itemCommentsService;

    @RequestMapping(value = itemCommentsUri, method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemCommentsDto> get() {

        //List<ItemCommentsDto> itemComments = itemCommentsService.get();

        return null;
    }

    @RequestMapping(value = itemCommentsUri, method = {RequestMethod.PUT})
    public @ResponseBody
    ItemCommentsDto save(ItemCommentsDto itemComments) {

        //ItemComments saveItemUser = itemCommentsService.save(itemComments);

        return null;
    }

    @RequestMapping(value = itemCommentsUri, method = {RequestMethod.DELETE})
    public @ResponseBody
    void delete(Long itemCommentId) {

        //itemCommentsService.delete(itemCommentId);
    }
}
