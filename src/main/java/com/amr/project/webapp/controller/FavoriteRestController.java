package com.amr.project.webapp.controller;

import com.amr.project.converter.FavoriteMapper;
import com.amr.project.model.dto.FavoriteDto;
import com.amr.project.model.entity.Favorite;
import com.amr.project.service.abstracts.FavoriteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favorite")
public class FavoriteRestController {

    private final FavoriteService favoriteService;
    private final FavoriteMapper favoriteMapper;

    public FavoriteRestController(FavoriteService favoriteService, FavoriteMapper favoriteMapper) {
        this.favoriteService = favoriteService;
        this.favoriteMapper = favoriteMapper;
    }

    @PostMapping
    public ResponseEntity<FavoriteDto> addToFavorite(@RequestBody FavoriteDto favorite) {
        Favorite favoriteToBeAdded = favoriteService.persist(favoriteMapper.toEntity(favorite));
        return ResponseEntity.ok(favoriteMapper.toDto(favoriteToBeAdded));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFromFavorite(@PathVariable Long id) {
        favoriteService.deleteByIdCascadeEnable(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
