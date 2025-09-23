import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { createChurch } from "../../services/ChurchService";

const ChurchComponent = () => {

 const [name, setName] = useState("");
 const [responsible, setResponsible] = useState("");
 const [website, setWebsite] = useState("");
 const [type, setType] = useState("");
 const [foundationdate, setFoundationdate] = useState("");
 const [cnpj, setCnpj] = useState("");
 const [address, setAddress] = useState("");
 const [city, setCity] = useState("");
 const [state, setState] = useState("");
 const [phone, setPhone] = useState("");

  const navigator = useNavigate();


  function saveChurch(e) {
   e.preventDefault();


   const church = {
     name,
     responsible,
     website,
     type,
     foundationdate,
     cnpj,
     address,
     city,
     state,
     phone,
   };


  // console.log(church);

   createChurch(church)
          .then((response) => {
            console.log(response.data);
            navigator("/churches");
          })
          .catch((error) => {
            console.error(error);
          });
 }



  return(
     <div className="container">
     <br></br>
     <div className="row">
       <div className="card col-md-10 offset-md-1 offset-md-1">
         <h2 className="text-center">Add Church</h2>
         <div className="card-body">
           <form>
             <div className="form-group mb-2">
               <label className="form-label">Name:</label>
               <input
                 type="text"
                
                 name="name"
                 value={name}
                 className="form-control"
                 onChange={(e) => setName(e.target.value)}
               ></input>
             </div>
             <div className="form-group mb-2">
               <label className="form-label">Responsible:</label>
               <input
                 type="text"
                 
                 name="responsible"
                 value={responsible}
                 className="form-control"
                 onChange={(e) => setResponsible(e.target.value)}
               ></input>
             </div>
             <div className="form-group mb-2">
               <label className="form-label">Site:</label>
               <input
                 type="text"
                
                 name="website"
                 value={website}
                 className="form-control"
                 onChange={(e) => setWebsite(e.target.value)}
               ></input>
             </div>
             <div className="form-group mb-2">
               <label className="form-label">Type:</label>
               <select
                 value={type}
                 onChange={(e) => setType(e.target.value)}
                 className="form-control"
               >
                 <option value="Church">Church</option>
                 <option value="Cell">Cell</option>
                 <option value="Headquarters">Headquarters</option>
                 <option value="Congregation">Congregation</option>
                 <option value="Community">Community</option>
                 <option value="Family">Family</option>
                 <option value="Group">Group</option>
               </select>
             </div>


             <div className="form-group mb-2">
               <label className="form-label">Date of Foundation:</label>
               <input
                 type="date"
                 name="foundationdate"
                 value={foundationdate}
                 onChange={(e) => setFoundationdate(e.target.value)}
                 className="form-control"
               ></input>
             </div>


             <div className="form-group mb-2">
               <label className="form-label">CNPJ:</label>
               <input
                 type="text"
                
                 name="cnpj"
                 value={cnpj}
                 className="form-control"
                 onChange={(e) => setCnpj(e.target.value)}
               ></input>
             </div>


             <div className="form-group mb-2">
               <label className="form-label">Address:</label>
               <input
                 type="text"
                 
                 name="address"
                 value={address}
                 className="form-control"
                 onChange={(e) => setAddress(e.target.value)}
               ></input>
             </div>


             <div className="form-group mb-2">
               <label className="form-label">City:</label>
               <input
                 type="text"
                
                 name="city"
                 value={city}
                 className="form-control"
                 onChange={(e) => setCity(e.target.value)}
               ></input>
             </div>


             <div className="form-group mb-2">
               <label className="form-label">State:</label>
               <select
                 value={state}
                 onChange={(e) => setState(e.target.value)}
                 className="form-control"
               >
                 <option value="AC">AC</option>
                 <option value="AL">AL</option>
                 <option value="AP">AP</option>
                 <option value="AM">AM</option>
                 <option value="BA">BA</option>
                 <option value="CE">CE</option>
                 <option value="DF">DF</option>
                 <option value="ES">ES</option>
                 <option value="GO">GO</option>
                 <option value="MA">MA</option>
                 <option value="MT">MT</option>
                 <option value="MS">MS</option>
                 <option value="MG">MG</option>
                 <option value="PA">PA</option>
                 <option value="PB">PB</option>
                 <option value="PR">PR</option>
                 <option value="PE">PE</option>
                 <option value="PI">PI</option>
                 <option value="RJ">RJ</option>
                 <option value="RN">RN</option>
                 <option value="RS">RS</option>
                 <option value="RO">RO</option>
                 <option value="RR">RR</option>
                 <option value="SC">SC</option>
                 <option value="SP">SP</option>
                 <option value="SE">SE</option>
                 <option value="TO">TO</option>
               </select>
             </div>


             <div className="form-group mb-2">
               <label className="form-label">Phone:</label>
               <input
                 type="text"
                
                 name="phone"
                 value={phone}
                 className="form-control"
                 onChange={(e) => setPhone(e.target.value)}
               ></input>
             </div>


             <button className="btn btn-success" onClick={saveChurch}>
               Save
             </button>
           </form>
         </div>
       </div>
     </div>
   </div>
  ); 
  
};

export default ChurchComponent;
