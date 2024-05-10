package com.nicodoss.tpspring.repositories;

import com.nicodoss.tpspring.entites.Pieces;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PiecesRepository extends JpaRepository<Pieces,Long> {
    @Override
    List<Pieces> findAllById(Iterable<Long> longs);
}
