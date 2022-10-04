
module.exports = {
    devServer: {
        port: 3000,
        proxy: {
            '/api': {
                target: 'https://nasa-apod-photos.herokuapp.com/',
                ws: true,
                changeOrigin: true
            }
        }
    }
}