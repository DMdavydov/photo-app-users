package com.ddavydov.photoappusers.client;

import com.ddavydov.photoappusers.model.AlbumResponse;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlbumsFallbackFactory implements FallbackFactory<AlbumsClient> {

    @Override
    public AlbumsClient create(Throwable cause) {
        return new AlbumsClientFallback(cause);
    }
}

@Data
@Slf4j
@AllArgsConstructor
class AlbumsClientFallback implements AlbumsClient {

    private final Throwable cause;



    @Override
    public List<AlbumResponse> getAlbums(String id) {
        if(cause instanceof FeignException && ((FeignException) cause).status() == 404) {
            log.error("404 to took from Albums");
        } else {
            log.error("Other: " + cause.getLocalizedMessage());
        }
        return new ArrayList<>();
    }
}
