module.exports = {
  lintOnSave: false,
  // proxy all webpack dev-server requests starting with /api
  // to our Spring Boot backend (localhost:2077) using http-proxy-middleware
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:2077', // this configuration needs to correspond to the Spring Boot backends' application.properties server.port
        ws: true,
        changeOrigin: true
      }
    }
  },
  // Change build paths to make them Maven compatible
  outputDir: 'target/dist',
  assetsDir: 'static'
};
