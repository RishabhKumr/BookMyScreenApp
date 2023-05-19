import { CapacitorConfig } from '@capacitor/cli';

const config: CapacitorConfig = {
  appId: 'com.example.app',
  appName: 'book-my-screen-front-end-ui',
  webDir: 'dist/book-my-screen-front-end-ui',
  server: {
    androidScheme: 'https'
  }
};

export default config;
