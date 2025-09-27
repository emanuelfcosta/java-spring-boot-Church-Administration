import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8090/financial";

export const getAllFinancial = () => axios.get(REST_API_BASE_URL);

export const createFinancial = (financial) =>
  axios.post(REST_API_BASE_URL, financial);

export const getFinancialById = (financialId) =>
  axios.get(REST_API_BASE_URL + "/" + financialId);

export const updateFinancial = (financialId, financial) =>
  axios.put(REST_API_BASE_URL + "/" + financialId, financial);
