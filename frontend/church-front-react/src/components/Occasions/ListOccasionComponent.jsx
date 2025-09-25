import React, { useEffect, useState } from "react";

import { getAllOccasions } from "../../services/OccasionService";

const ListOccasionComponent = () => {
  const [occasions, setOccasions] = useState([]);

  useEffect(() => {
    listOfOccasions();
  }, []);

  function listOfOccasions() {
    getAllOccasions()
      .then((response) => {
        // console.log(response.data);
        setOccasions(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  return (
    <div className="container">
      <h2 className="text-center">List of Events</h2>

      <table className="table table-striped ">
        <thead>
          <tr>
            <th>id</th>
            <th>Start</th>
            <th>End</th>
            <th>Name</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {occasions.map((occasion) => (
            <tr key={occasion.id}>
              <td>{occasion.id}</td>
              <td>{occasion.start}</td>
              <td>{occasion.end}</td>
              <td>{occasion.name}</td>
              <td></td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListOccasionComponent;
