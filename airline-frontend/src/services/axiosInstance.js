import axios from 'axios';

const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080/api/', // Set your API base URL
});

// Add an interceptor to include the JWT token in the authorization header
axiosInstance.interceptors.request.use(
  (config) => {
    // Get the JWT token from sessionStorage
    const token = window.sessionStorage.getItem('JWTtoken');
    if (token) {
        console.log("there IS token");
      config.headers.Authorization = `Bearer ${token}`;
    }else{
        console.log("there is NO token");
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

export default axiosInstance;