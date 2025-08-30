import React from "react";
import { useNavigate } from "react-router-dom";
import API from "../services/api";

export default function Login(){
  const [email,setEmail] = React.useState("");
  const [password,setPassword] = React.useState("");
  const navigate = useNavigate();

  const submit = async (e) => {
    e.preventDefault();
    try {
      const res = await API.post("/auth/login", { email, password });
      localStorage.setItem("token", res.data.token);
      localStorage.setItem("role", res.data.role);
      localStorage.setItem("name", res.data.name);
      alert("Login OK");
      navigate("/events");
    } catch (err){ alert("Login failed"); }
  };

  return (
    <div className="container mt-4" style={{maxWidth:500}}>
      <h3>Login</h3>
      <form onSubmit={submit}>
        <input className="form-control mb-2" type="email" placeholder="Email" value={email} onChange={e=>setEmail(e.target.value)} required/>
        <input className="form-control mb-2" type="password" placeholder="Password" value={password} onChange={e=>setPassword(e.target.value)} required/>
        <button className="btn btn-primary">Login</button>
      </form>
    </div>
  );
}
