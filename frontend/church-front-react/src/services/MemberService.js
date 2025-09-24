import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8090/members";

export const getAllMembers = () => axios.get(REST_API_BASE_URL);

export const createMember = (churchId, member) =>
  axios.post(REST_API_BASE_URL + "/churches/" + churchId, member);
