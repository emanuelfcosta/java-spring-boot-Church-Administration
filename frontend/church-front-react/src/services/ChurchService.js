import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8090/churches";

export const getAllChurches = () => axios.get(REST_API_BASE_URL);

export const createChurch = (church) => axios.post(REST_API_BASE_URL, church);
