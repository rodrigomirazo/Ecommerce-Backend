package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.dto.ItemDto;
import com.ecommerce.bicicle.service.ItemService;
import com.ecommerce.bicicle.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin
@RestController
@RequestMapping(value = EndpointNames.URI)
public class ItemController {

    private static final String itemUri = EndpointNames.ITEM_CONTROLLER;
    private static final String userUri = EndpointNames.USER_CONTROLLER;

    @Value("${user.path.img.items}")
    private String imgFilePath;

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = itemUri, method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemDto> getItem() {
        return itemService.get();
    }

    @RequestMapping(value = itemUri + "/user/{userId}", method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemDto> getItem(
            @PathVariable(value = "userId") Integer userId
    ) {
        return itemService.getItemsByUser(userId);
    }

    @RequestMapping(value = itemUri, method = {RequestMethod.POST})
    public @ResponseBody
    ItemDto getItem(@RequestBody ItemDto item) {

        return itemService.save(item);
    }

    @RequestMapping(value = itemUri, method = {RequestMethod.DELETE})
    public @ResponseBody
    void getItem(Long itemId) {

        itemService.delete(itemId);
    }

    /**
     * Upload FIle
     */
    @PostMapping( itemUri + "/uploadImg")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(this.imgFilePath + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }
}
