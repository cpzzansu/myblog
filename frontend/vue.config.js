const {defineConfig} = require('@vue/cli-service');
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port: 8084,
    proxy: {
      '/api': {
        target: '/api', // 스프링 부트 서버 주소
        changeOrigin: true,
        pathRewrite: {
          '^/api': '',
        },
      },
    },
  },
  configureWebpack: {
    resolve: {
      alias: {
        codemirror$: 'codemirror/lib/codemirror.js',
      },
    },
  },
});
