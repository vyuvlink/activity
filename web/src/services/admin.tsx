import api from "../utils/api";

export const BackendList = (data) =>
  api.get("/act/backend/list", { params: data });

export const Login = (data) => api.post("/user/backend/login", data);

export const saveActivity = (data) =>
  api.post("/act/backend/save_activity", data);

export const uploadFile = (file) => {
  const body = new FormData();
  body.append("file", file);
  return fetch("/uapi/upload/file", {
    method: "post",
    body,
  }).then((byte) => byte.json());
};
