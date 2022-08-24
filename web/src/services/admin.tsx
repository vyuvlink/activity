import api from "../utils/api";

export const BackendList = (data) =>
  api.get("/act/backend/list", { params: data });

export const Login = (data) => api.post("/user/backend/login", data);
