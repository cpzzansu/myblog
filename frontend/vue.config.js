const {defineConfig} = require('@vue/cli-service');
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port: 8084,
    proxy: {
      'http://localhost:90': {
        target: 'http://localhost:90', // 스프링 부트 서버 주소
        changeOrigin: true,
        pathRewrite: {
          '^http://localhost:90': '',
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
