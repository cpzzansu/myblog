const {defineConfig} = require('@vue/cli-service');
module.exports = defineConfig({
  transpileDependencies: true,
  outputDir: '../src/main/resources/static',
  devServer: {
    port: 8084,
    proxy: {
      '/api': {
        target: 'http://localhost:90', // 스프링 부트 서버 주소
        changeOrigin: true,
        pathRewrite: {
          '^/api': '',
        },
      },
    },
  },
});
