import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Events from "./pages/Events";
import MyEvents from "./pages/MyEvents";
import AdminDashboard from "./pages/AdminDashboard";
import Navbar from "./components/Navbar";
import AuthProvider from "./context/AuthContext";

export default function App() {
  return (
    <AuthProvider>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/events" element={<Events />} />
          <Route path="/myevents" element={<MyEvents />} />
          <Route path="/admin" element={<AdminDashboard />} />
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  );
}
