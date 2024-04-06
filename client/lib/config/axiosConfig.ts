import axios from 'axios';

const MAX_REQUESTS = 5;
const REQUEST_TIME_INTERVAL = 1000;

let requestCount: number = 0;
let lastRequestTime: number = 0;

const axiosInstance = axios.create({
  timeout: 5000,
  headers: {
    'Content-Type': 'application/json',
  },
  baseURL: 'http://localhost:8080',
});

axiosInstance.interceptors.request.use(
  (config) => {
    const currentTime = Date.now();
    if (
      requestCount >= MAX_REQUESTS &&
      currentTime - lastRequestTime < REQUEST_TIME_INTERVAL
    ) {
      return Promise.reject(new Error('Max number of request'));
    }

    requestCount += 1;
    lastRequestTime = currentTime;

    return config;
  },
  (error) => Promise.reject(error)
);

axiosInstance.interceptors.response.use(
  (response) => {
    requestCount -= 1;
    return response;
  },
  (error) => {
    requestCount -= 1;
    return Promise.reject(error);
  }
);

export default axiosInstance;
