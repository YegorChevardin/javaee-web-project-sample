package ua.com.yehorchevardin.andersen.javaee.project.sample.service.convertors;

import java.util.List;

/**
 * Method for converting dto to entity
 *
 * @author yegorchevardin
 * @version 0.0.1
 */
public interface EntityDtoObjectConvertor<E, D> {
  D convertEntityToDto(E entity);

  E convertDtoToEntity(D dto);

  default List<D> convertListEntityToListDto(List<E> entities) {
    return entities.stream().map(this::convertEntityToDto).toList();
  }

  default List<E> convertListDtoToListEntity(List<D> dtos) {
    return dtos.stream().map(this::convertDtoToEntity).toList();
  }
}
