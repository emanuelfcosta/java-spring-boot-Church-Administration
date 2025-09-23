import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8090/churches";

export const getAllChurches = () => axios.get(REST_API_BASE_URL);

export const createChurch = (church) => axios.post(REST_API_BASE_URL, church);

export const getChurchById = (churchId) =>
 axios.get(REST_API_BASE_URL + "/" + churchId);

export const updateChurch = (churchId, church) =>
 axios.put(REST_API_BASE_URL + "/" + churchId, church);

export const deleteChurch = (churchId) =>
 axios.delete(REST_API_BASE_URL + "/" + churchId);
