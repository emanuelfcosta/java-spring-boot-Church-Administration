import React, { useEffect, useState } from "react";
import { getAllChurches } from "../../services/ChurchService";
import { useNavigate } from "react-router-dom";

const ListChurchComponent = () => {
  const [churches, setChurches] = useState([]);

  const navigator = useNavigate([]);

  function listOfChurches() {
    getAllChurches()
      .then((response) => {
        console.log(response.data);
        setChurches(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  useEffect(() => {
    listOfChurches();
  }, []);

  function addNewChurch(){
    navigator("/add-church");
  }

  return (
    <div className="container">
      <h2 className="text-center">List of Churches</h2>
      <button className="btn btn-success" onClick={addNewChurch}>
      Add Church
    </button>

      <table className="table table-striped">
        <thead>
          <tr>
            <th>Id</th>
            <th>Type</th>
            <th>Responsible</th>
            <th>Address</th>
            <th>City</th>
          </tr>
        </thead>
        <tbody>
          {churches.map((church) => (
            <tr key={church.id}>
              <td>{church.id}</td>
              <td>{church.type}</td>
              <td>{church.responsible}</td>
              <td>{church.address}</td>
              <td>{church.city}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListChurchComponent;
