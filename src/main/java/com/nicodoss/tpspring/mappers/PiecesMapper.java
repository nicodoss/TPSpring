package com.nicodoss.tpspring.mappers;
import com.nicodoss.tpspring.dtos.PiecesDto;
import com.nicodoss.tpspring.entites.Pieces;
import org.mapstruct.*;
import java.util.List;
import static org.mapstruct.SubclassExhaustiveStrategy.RUNTIME_EXCEPTION;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, subclassExhaustiveStrategy = RUNTIME_EXCEPTION,
        componentModel = MappingConstants.ComponentModel.SPRING, uses={PersonneMapper.class})
public interface PiecesMapper extends EntityMapper<PiecesDto,Pieces>{
    @Override
    Pieces toEntity(PiecesDto piecesDto);
    @Override
    List<Pieces> toEntity(List<PiecesDto> piecesDto);
    @Override
    PiecesDto toDto(Pieces pieces);
    @Override
    List<PiecesDto> toDto(List<Pieces> pieces);

}