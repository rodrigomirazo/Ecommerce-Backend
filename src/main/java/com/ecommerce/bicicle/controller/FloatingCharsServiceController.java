package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.dto.ItemFloatingCharsCatDto;
import com.ecommerce.bicicle.dto.ItemFloatingCharsDto;
import com.ecommerce.bicicle.service.FloatingCharsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class FloatingCharsServiceController {

    private static final String itemFloatingCharsUri = EndpointNames.ITEM_FLOATING_CHARS_CONTROLLER;
    private static final String itemFloatingCharsCatUri = EndpointNames.ITEM_FLOATING_CHARS_CAT_CONTROLLER;

    @Autowired
    private FloatingCharsService floatingCharsService;

    /**
     * Floating Chars
     */

    @RequestMapping(value = itemFloatingCharsUri, method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemFloatingCharsDto> get(Long itemTypeId) {
        List<ItemFloatingCharsDto> itemFloatingCharsDtos = floatingCharsService.getItemFloatingCharsDtos();
        return itemFloatingCharsDtos;
    }

    @RequestMapping(value = itemFloatingCharsUri, method = {RequestMethod.PUT})
    public @ResponseBody
    ItemFloatingCharsDto save(@RequestBody ItemFloatingCharsDto itemFloatingCharsDto) {
        ItemFloatingCharsDto itemCategoryDto = floatingCharsService.saveFloatingCharsDtos(itemFloatingCharsDto);
        return itemCategoryDto;
    }

    @RequestMapping(value = itemFloatingCharsUri, method = {RequestMethod.DELETE})
    public @ResponseBody
    void delete(@RequestParam Integer itemFloatingCharId) {
        floatingCharsService.deleteFloatingChar(itemFloatingCharId);
    }

    /**
     * Floating Chars Cat
     */

    @RequestMapping(value = itemFloatingCharsCatUri+"/{floatingCharsCat}", method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemFloatingCharsCatDto> getCat(@PathVariable("floatingCharsCat") Integer floatingCharsCat) {
        List<ItemFloatingCharsCatDto> itemFloatingCharsDtos = floatingCharsService.getItemFloatingCharsCat(floatingCharsCat);
        return itemFloatingCharsDtos;
    }

    @RequestMapping(value = itemFloatingCharsCatUri+"/{floatingCharsCat}", method = {RequestMethod.PUT})
    public @ResponseBody
    ItemFloatingCharsCatDto saveCat(@PathVariable("floatingCharsCat") Integer floatingCharsCat, @RequestBody ItemFloatingCharsCatDto itemFloatingCharsDto) {
        ItemFloatingCharsCatDto itemCategoryDto = null;
        try {
            itemCategoryDto = floatingCharsService.saveItemFloatingCharsCat(floatingCharsCat, itemFloatingCharsDto);
        } catch (Exception e) {
            return null;
        }
        return itemCategoryDto;
    }

    @RequestMapping(value = itemFloatingCharsCatUri, method = {RequestMethod.DELETE})
    public @ResponseBody
    void deleteCat(@RequestParam Integer itemFloatingCharId) {
        floatingCharsService.deleteFloatingCharCat(itemFloatingCharId);
    }
}
