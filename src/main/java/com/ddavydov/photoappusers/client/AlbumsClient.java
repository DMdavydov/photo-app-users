package com.ddavydov.photoappusers.client;

import com.ddavydov.photoappusers.model.AlbumResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "photo-app-albums", fallbackFactory = AlbumsFallbackFactory.class)
public interface AlbumsClient {

    @GetMapping("/users/{id}/albums")
    List<AlbumResponse> getAlbums(@PathVariable String id);
}
