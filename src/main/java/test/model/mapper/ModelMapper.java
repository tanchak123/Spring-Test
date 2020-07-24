package test.model.mapper;

public interface ModelMapper<E, Q, P> {
    E toEntity(Q dto);

    P toDto(E entity);

}
