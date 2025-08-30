import axios from "axios";
const API = axios.create({ baseURL: process.env.REACT_APP_API_BASE || "http://localhost:8081/api" });
API.interceptors.request.use(cfg => {
  const token = localStorage.getItem("token");
  if (token) cfg.headers.Authorization = `Bearer ${token}`;
  return cfg;
});
export default API;
