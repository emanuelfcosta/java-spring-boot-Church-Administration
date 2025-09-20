import "./App.css";
import ListChurchComponent from "./components/Churches/ListChurchComponent";
import HeaderComponent from "./components/HeaderComponent";
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
    <>
      <BrowserRouter>
        <HeaderComponent />

        <Routes>
          {/*http://localhost:5173/churches */}
          <Route path="/churches" element={<ListChurchComponent />}></Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
