package dev.project.pixelwar.repository;

import dev.project.pixelwar.model.PixelMb;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PixelRepository {

  @Insert("""
      INSERT INTO pixel(x, y, color, "user")
      VALUES (#{x},#{y}, #{color},#{user})
      ON CONFLICT ON CONSTRAINT uc_x_y
      DO UPDATE
      SET
          color = #{color},
          "user" = #{user}
       """)
  void savePixel(PixelMb pixelMB);

  @Select("""
        SELECT x, y, color FROM pixel
      """)
  List<PixelMb> getPixels();


}
