package dev.project.pixelwar.mapper;

import dev.project.pixelwar.model.PixelFront;
import dev.project.pixelwar.model.PixelMb;
import dev.project.pixelwar.model.PixelMessageFront;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface PixelMapper {

  PixelMb pixelMessageFrontToPixelMb(PixelMessageFront pixelMessageFront);

  List<PixelFront> pixelMbListToFront(List<PixelMb> pixelMbList);

}
