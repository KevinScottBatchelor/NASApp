package dev.kevinbatchelor;

import dev.kevinbatchelor.controller.ImageController;
import dev.kevinbatchelor.exception.InvalidReqParamException;
import dev.kevinbatchelor.model.Image;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ImageControllerTests {

    @Value("${api-key}")
    public String API_KEY;

    @Test
    public void requestIsNull_ExpectThrowsInvalidReqParamException() {

        String request = null;

        ImageController test = new ImageController();

        Throwable exception = assertThrows(InvalidReqParamException.class, () -> test.getImages(request));
        assertNull(null, exception.getMessage());

    }

    @Test
    public void requestIsZero_ExpectThrowsInvalidReqParamException() {

        String request = "0";

        ImageController test = new ImageController();

        Throwable exception = assertThrows(InvalidReqParamException.class, () -> test.getImages(request));
        assertNull(null, exception.getMessage());

    }

    @Test
    public void requestIsSeven_ExpectThrowsInvalidReqParamException() {

        String request = "7";

        ImageController test = new ImageController();

        Throwable exception = assertThrows(InvalidReqParamException.class, () -> test.getImages(request));
        assertNull(null, exception.getMessage());

    }

    @Test
    public void requestIsOne_ExpectListOfImagesToBeSizeOne() {

        ImageController test = new ImageController();
        List<Image> images;
        String request = "1";

        images = test.getImages(request);

        assertTrue(images.size() == 1);
    }
}
