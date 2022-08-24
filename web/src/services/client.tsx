import api from "../utils/api";

export const queryActivityList = (data) =>
  api.get("/act/list", { params: data });

export const queryActivity = (data) => api.get("/act/query", { params: data });

export const decodeSence = (data) => api.get("/sence/decode", { params: data });
