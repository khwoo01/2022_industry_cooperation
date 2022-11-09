module.exports = {  
    outputDir: "../src/main/resources/static",  
    indexPath: "../static/index.html",  
    devServer: {  
      proxy: "http://49.50.164.178:8080"  
    },  
    chainWebpack: config => {  
      const svgRule = config.module.rule("svg");    
      svgRule.uses.clear();    
      svgRule.use("vue-svg-loader").loader("vue-svg-loader");  
    }  
  };