import { Route, Routes } from "react-router-dom";
import "./App.css";
import Home from "./pages/Home/Home";
import Navbar from "./pages/Navbar/Navbar";
import ProjectDetails from "./pages/ProjectDetails/ProjectDetails";
import IssueDetails from "./pages/IssueDetails/IssueDetails";
import Subscripton from "./pages/Subscription/Subscripton";
import Auth from "./pages/Auth/Auth";
import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import { getUser } from "./Redux/Auth/Action";
import { fetchProjects } from "./Redux/Project/Action";

function App() {
  const dispatch = useDispatch();
  const auth = useSelector((store) => store.auth);
  useEffect(() => {
    dispatch(getUser());
    dispatch(fetchProjects([]));
  }, [auth.jwt,dispatch]);

  console.log(auth);
  

  return (
    <>
      {auth.user ? (
        <div>
          <Navbar />
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/project/:id" element={<ProjectDetails />} />
            <Route
              path="/project/:projectId/issue/:issueId"
              element={<IssueDetails />}
            />
            <Route path="/upgrade_plan" element={<Subscripton />} />
          </Routes>
        </div>
      ) : (
        <Auth />
      )}
    </>
  );
}

export default App;
