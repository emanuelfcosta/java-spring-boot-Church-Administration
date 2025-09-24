import React, { useEffect, useState } from "react";
import { getAllMembers } from "../../services/MemberService";

const ListMemberComponent = () => {
  const [members, setMembers] = useState([]);

  useEffect(() => {
    listOfMembers();
  }, []);

  function listOfMembers() {
    getAllMembers()
      .then((response) => {
        // console.log(response.data);
        setMembers(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  return (
    <div className="container">
      <h2 className="text-center">List of Members</h2>

      <table className="table table-striped">
        <thead>
          <tr>
            <th>id</th>
            <th>Name</th>
            <th>Ocupation</th>
            <th>Church</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {members.map((member) => (
            <tr key={member.id}>
              <td>{member.id}</td>
              <td>{member.name}</td>
              <td>{member.occupation}</td>
              <td>{member.church.name}</td>
              <td></td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListMemberComponent;
