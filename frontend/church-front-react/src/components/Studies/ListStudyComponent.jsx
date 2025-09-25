import React, { useEffect, useState } from "react";
import { getAllStudy } from "../../services/StudyService";
import { useNavigate } from "react-router-dom";

const ListStudyComponent = () => {
  const [study, setStudy] = useState([]);

  const navigator = useNavigate();

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

  function addNewStudy() {
    navigator("/add-study");
  }

  function updateStudy(id) {
    navigator(`/edit-study/${id}`);
  }

  // shows the date in  dd/mm/yyyy format
  function formatDate(date) {
    const options = { day: "2-digit", month: "2-digit", year: "numeric" };
    return new Date(date).toLocaleDateString("pt-BR", options);
  }

  return (
    <div className="container">
      <h2 className="text-center">List of Studies</h2>
      <button className="btn btn-success" onClick={addNewStudy}>
        Add Study
      </button>

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
              <td>
                <button
                  onClick={() => updateStudy(theStudy.id)}
                  className="btn btn-info"
                >
                  Update
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListStudyComponent;
