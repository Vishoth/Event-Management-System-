import React from "react";
import API from "../services/api";
import { useNavigate } from "react-router-dom";

export default function Register(){
  const [name,setName] = React.useState("");
  const [email,setEmail] = React.useState("");
  const [password,setPassword] = React.useState("");
  const navigate = useNavigate();

  const submit = async e => {
    e.preventDefault();
    try {
      await API.post("/auth/register", { name, email, password });
      alert("Registered, please login");
      navigate("/");
    } catch { alert("Registration failed"); }
  };

  return (
    <div className="container mt-4" style={{maxWidth:500}}>
      <h3>Register</h3>
      <form onSubmit={submit}>
        <input className="form-control mb-2" placeholder="Name" value={name} onChange={e=>setName(e.target.value)} required/>
        <input className="form-control mb-2" type="email" placeholder="Email" value={email} onChange={e=>setEmail(e.target.value)} required/>
        <input className="form-control mb-2" type="password" placeholder="Password" value={password} onChange={e=>setPassword(e.target.value)} required/>
        <button className="btn btn-success">Register</button>
      </form>
    </div>
  );
}
