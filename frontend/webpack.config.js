const { resolve } = require('path')
const webpack = require('webpack')
const HtmlWebpackPlugin = require('html-webpack-plugin');
const merge = require('webpack-merge')

const PORT = 3000;

const targetEnv = process.env.npm_lifecycle_event === 'build' ? 'production' : 'development'

const config = {
  output: {
    filename: 'bundle.js',
    path: resolve(__dirname, 'dist'),
    publicPath: '/'
  },
  context: resolve(__dirname, 'src'),
  module: {
    rules: [{
      test: /\.js$/,
      exclude: /node_modules/,
      use: 'babel-loader'
    }]
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: 'index.ejs'
    }),
    // enable HMR globally
    new webpack.HotModuleReplacementPlugin(),

    // prints more readable module names in the browser console on HMR updates
    new webpack.NamedModulesPlugin()
  ]
}

if (targetEnv === 'development') {
  module.exports = merge(config, {
    entry: [
      'react-hot-loader/patch',
      // activate HMR for React

      `webpack-dev-server/client?http://localhost:${PORT}`,
      // bundle the client for webpack-dev-server
      // and connect to the provided endpoint

      'webpack/hot/only-dev-server',
      // bundle the client for hot reloading
      // only- means to only hot reload for successful updates

      './index.js'
      // the entry point of our app
    ],
    devServer: {
      hot: true,
      contentBase: resolve(__dirname, 'dist'),
      publicPath: '/',
      port: PORT
    },
    devtool: 'inline-source-map',
  })
}

if (targetEnv === 'production') {
  module.exports = merge(config, {
    entry: './index.js',
    plugins: [
      new webpack.DefinePlugin({
        'process.env': {
          NODE_ENV: JSON.stringify('production')
        }
      })
    ]
  })
}
