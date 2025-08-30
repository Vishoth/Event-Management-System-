import React,{useEffect,useState} from "react";
import API from "../services/api";

export default function Events(){
  const [events,setEvents] = useState([]);
  useEffect(()=>{ API.get("/events").then(r=>setEvents(r.data)).catch(()=>{}); },[]);
  const register = async (id) => {
    const emailToken = localStorage.getItem("token");
    const participantId = prompt("Enter your Participant ID (for demo)"); // simple demo
    await API.post(`/registrations?participantId=${participantId}&eventId=${id}`);
    alert("Registered");
  };
  return (
    <div className="container mt-3">
      <h3>Events</h3>
      <div className="list-group">
        {events.map(e => (
          <div key={e.id} className="list-group-item d-flex justify-content-between">
            <div>
              <strong>{e.title}</strong><br/>
              <small>{e.date} • {e.location}</small>
            </div>
            <button className="btn btn-primary" onClick={()=>register(e.id)}>Register</button>
          </div>
        ))}
      </div>
    </div>
  );
}
