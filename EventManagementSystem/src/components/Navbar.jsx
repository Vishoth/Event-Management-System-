import React, { useContext } from "react";
import { Link, useNavigate } from "react-router-dom";
import { AuthContext } from "../context/AuthContext";

export default function Navbar() {
  const { user, logout } = useContext(AuthContext);
  const navigate = useNavigate();

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark px-3">
      <Link className="navbar-brand" to="/">EMS</Link>
      <div className="navbar-nav">
        <Link className="nav-link" to="/events">Events</Link>
        {user && user.role === "USER" && (
          <Link className="nav-link" to="/myevents">My Events</Link>
        )}
        {user && user.role === "ADMIN" && (
          <Link className="nav-link" to="/admin">Admin</Link>
        )}
      </div>
      <div className="ms-auto">
        {user ? (
          <>
            <span className="text-white me-2">Hi, {user.name}</span>
            <button className="btn btn-outline-light btn-sm"
              onClick={() => { logout(); navigate("/"); }}>Logout</button>
          </>
        ) : (
          <>
            <Link className="btn btn-outline-light btn-sm me-2" to="/">Login</Link>
            <Link className="btn btn-light btn-sm" to="/register">Register</Link>
          </>
        )}
      </div>
    </nav>
  );
}
