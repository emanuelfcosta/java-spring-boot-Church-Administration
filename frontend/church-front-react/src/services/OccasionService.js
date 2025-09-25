import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8090/occasions";

export const getAllOccasions = () => axios.get(REST_API_BASE_URL);
