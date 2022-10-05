package dev.kevinbatchelor.controller;

import dev.kevinbatchelor.exception.InvalidReqParamException;
import dev.kevinbatchelor.model.Image;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ImageController {

    @Value("${api-key}")
    private String API_KEY;
    private int count;

    @RequestMapping(value = "/image{request}")
    public List<Image> getImages(@RequestParam String request) {

        if (request != null && request.length() == 1) {
            count = Integer.parseInt(request);

        } else throw new InvalidReqParamException();

        if (count > 6) throw new InvalidReqParamException();

        if (count <= 0) {

            throw new InvalidReqParamException();

        } else {

            String url = "https://api.nasa.gov/planetary/apod?" + API_KEY + request + "&thumbs=True";
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<List<Image>> responseEntity =
                    restTemplate.exchange(
                            url,
                            HttpMethod.GET,
                            null, new ParameterizedTypeReference<List<Image>>() {
                            }
                    );

            List<Image> images = responseEntity.getBody();

            return images;
        }
    }
}
