package com.ecommerce.bicicle.controller;

import com.ecommerce.bicicle.constants.EndpointNames;
import com.ecommerce.bicicle.dto.ItemFilterDto;
import com.ecommerce.bicicle.dto.ItemSavedDto;
import com.ecommerce.bicicle.entity.ItemImgUrlsEntity;
import com.ecommerce.bicicle.service.ItemImgUrlsService;
import com.ecommerce.bicicle.service.ItemService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.activation.FileTypeMap;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.websocket.server.PathParam;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = EndpointNames.URI)
public class ItemController {

    private static final String itemUri = EndpointNames.ITEM_CONTROLLER;
    private static final String userUri = EndpointNames.USER_CONTROLLER;

    private static final String ITEM_FILE_PREFIX = "item_file";

    @Value("${user.path.img.items}")
    private String imgFilePath;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemImgUrlsService itemImgUrlsService;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = itemUri + "/{itemId}", method = {RequestMethod.GET})
    public @ResponseBody
    ItemSavedDto getItemById(@PathVariable(value = "itemId")  Integer itemId) {
        return itemService.getItemsById(itemId);
    }

    @RequestMapping(value = itemUri, method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemSavedDto> getItem() {
        return itemService.get();
    }

    @RequestMapping(value = itemUri + "/user/{userId}", method = {RequestMethod.GET})
    public @ResponseBody
    List<ItemSavedDto> getItem(
            @PathVariable(value = "userId") Integer userId
    ) {
        return itemService.getItemsByUser(userId);
    }

    //
    @RequestMapping(value = itemUri + "/image/{imageName}", method = {RequestMethod.GET})
    public @ResponseBody
    byte[] getItemImage(
            @PathVariable(value = "imageName") String imageName
    ) throws IOException {

        BufferedImage bufferedImage = ImageIO.read(new File( "/Users/rodrigomirazo/dev/Ecloth-ui/src/assets/uploaded/" + imageName));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", bos );
        byte[] data = bos.toByteArray();
        return data;
    }

    @RequestMapping(value = itemUri + "/criteria", method = {RequestMethod.POST})
    public @ResponseBody
    List<ItemSavedDto> getFilteredItems(
            @RequestBody ItemFilterDto itemFilterDto
    ) {
        return itemService.getFilteredItems(itemFilterDto);
    }

    @RequestMapping(value = itemUri, method = {RequestMethod.POST})
    public @ResponseBody
    ItemSavedDto saveItem(@RequestBody ItemSavedDto item) {

        return itemService.save(item);
    }

    @RequestMapping(value = itemUri + "/{itemId}", method = {RequestMethod.DELETE})
    public @ResponseBody
    void deleteItem(@PathVariable(value = "itemId") Integer itemId) {

        itemService.delete(itemId);
    }

    /**
     * Upload FIle
     */
    @PostMapping( itemUri + "/uploadImg/{itemId}")
    public String singleFileUpload(
            @RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes,
            @PathVariable(value = "itemId") Integer itemId
            ) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        Timestamp timestamp = new Timestamp(new Date().getTime());
        ItemImgUrlsEntity itemImgUrls = new ItemImgUrlsEntity();
        itemImgUrls.setCreatedTime(timestamp);
        itemImgUrls.setImgUrl("not_saved");
        itemImgUrls.setItemId(itemId);
        ItemImgUrlsEntity savedItemImg = itemImgUrlsService.save(itemImgUrls);

        String pathStr = this.imgFilePath + ITEM_FILE_PREFIX + "_" + itemId + "_" + savedItemImg.getId() + ".png";
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(pathStr);
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            itemImgUrlsService.delete(savedItemImg.getItemId());
            e.printStackTrace();
        }

        itemImgUrls.setImgUrl(ITEM_FILE_PREFIX + "_" + itemId + "_" + savedItemImg.getId() + ".png");
        itemImgUrlsService.save(itemImgUrls);

        return "redirect:/uploadStatus";
    }

}
