package dev.project.pixelwar.controller;

import dev.project.pixelwar.model.PixelFront;
import dev.project.pixelwar.service.PixelwarService;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("pixel")
public class PixelController {

  private final PixelwarService pixelwarService;

  public PixelController(PixelwarService pixelwarService) {
    this.pixelwarService = pixelwarService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<PixelFront> getMapPixels() {
    return pixelwarService.getPixels();
  }

}
