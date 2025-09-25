import React, { useEffect, useState } from "react";
import { getAllStudy } from "../../services/StudyService";

const ListStudyComponent = () => {
  const [study, setStudy] = useState([]);

  useEffect(() => {
    listOfStudy();
  }, []);

  function listOfStudy() {
    getAllStudy()
      .then((response) => {
        // console.log(response.data);
        setStudy(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  // shows the date in  dd/mm/yyyy format
  function formatDate(date) {
    const options = { day: "2-digit", month: "2-digit", year: "numeric" };
    return new Date(date).toLocaleDateString("pt-BR", options);
  }

  return (
    <div className="container">
      <h2 className="text-center">List of Studies</h2>
      <table className="table table-striped ">
        <thead>
          <tr>
            <th>id</th>
            <th>Date</th>
            <th>Subject</th>
            <th>Description</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {study.map((theStudy) => (
            <tr key={theStudy.id}>
              <td>{theStudy.id}</td>
              <td>{theStudy.theDate}</td>
              <td>{theStudy.subject}</td>
              <td>{theStudy.description}</td>
              <td></td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListStudyComponent;
