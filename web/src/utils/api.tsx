import axios, { Axios, AxiosRequestConfig, AxiosResponse } from "axios";

const defaultvalue = {
  baseURL: '/api',
  timeout: 2500,
}
const instance = axios.create(defaultvalue);
// instance.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
instance.defaults.headers.get['Content-Type'] = 'application/json';
instance.defaults.headers.post['Content-Type'] = 'application/json';

axios.interceptors.request.use(
  (config: AxiosRequestConfig) => {
    const token = sessionStorage.getItem('token');
    if (config.headers) {
      if (token) {
        config.headers['token'] = token;
      }
    }

    return config;
  },
  (error) => Promise.reject(error)
);

axios.interceptors.response.use(
  (response: AxiosResponse) => {
    const { code, data, msg } = response.data || {}
    if (code !== 0) {
      
    }
  },
  (error) => Promise.reject(error)
);

export default instance;
