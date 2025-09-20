import React, { useEffect, useState } from "react";
import { getAllChurches } from "../../services/ChurchService";

const ListChurchComponent = () => {
  const [churches, setChurches] = useState([]);

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

  return (
    <div className="container">
      <h2 className="text-center">List of Churches</h2>
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
            <tr key={church._id}>
              <td>{church._id}</td>
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
