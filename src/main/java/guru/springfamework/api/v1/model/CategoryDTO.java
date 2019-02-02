package guru.springfamework.api.v1.model;

import lombok.Data;
import org.mapstruct.Mapper;

/**
 * Created by jt on 9/24/17.
 */
@Data
public class CategoryDTO {
    private Long id;
    private String name;
}
