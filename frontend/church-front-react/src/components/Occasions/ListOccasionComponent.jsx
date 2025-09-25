import React, { useEffect, useState } from "react";

import { getAllOccasions } from "../../services/OccasionService";
import { useNavigate } from "react-router-dom";

const ListOccasionComponent = () => {
  const [occasions, setOccasions] = useState([]);

  const navigator = useNavigate();

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

  function addNewOccasion() {
    navigator("/add-occasion");
  }

  return (
    <div className="container">
      <h2 className="text-center">List of Events</h2>

      <button className="btn btn-success" onClick={addNewOccasion}>
        Add Event
      </button>

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
