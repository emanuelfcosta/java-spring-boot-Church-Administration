import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8090/prayers";

export const getAllPrayers = () => axios.get(REST_API_BASE_URL);
