import axios from 'axios'

const http = axios.create ({
    baseURL: "/api/"
});

export default {
    getImagesFromNasaApodApi(request) {
        return http.get(`image?request=${request}`);
    }
}