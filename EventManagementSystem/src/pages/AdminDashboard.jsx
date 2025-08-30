import React, { useEffect, useState } from "react";
import API from "../services/api";

export default function AdminDashboard() {
  const [events, setEvents] = useState([]);
  const [form, setForm] = useState({ title: "", date: "", location: "" });

  const load = () => API.get("/events").then(r => setEvents(r.data));
  useEffect(() => { load(); }, []);

  const create = async (e) => {
    e.preventDefault();
    await API.post("/events", form);
    setForm({ title: "", date: "", location: "" });
    load();
  };

  const remove = async (id) => {
    await API.delete(`/events/${id}`);
    load();
  };

  return (
    <div className="container mt-3">
      <h3>Admin Dashboard</h3>
      <form className="mb-3" onSubmit={create}>
        <input className="form-control mb-2" placeholder="Title" value={form.title}
          onChange={e => setForm({ ...form, title: e.target.value })} required/>
        <input className="form-control mb-2" type="date" value={form.date}
          onChange={e => setForm({ ...form, date: e.target.value })} required/>
        <input className="form-control mb-2" placeholder="Location" value={form.location}
          onChange={e => setForm({ ...form, location: e.target.value })} required/>
        <button className="btn btn-success">Create Event</button>
      </form>

      <ul className="list-group">
        {events.map(e => (
          <li key={e.id} className="list-group-item d-flex justify-content-between">
            {e.title} — {e.date} — {e.location}
            <button className="btn btn-danger btn-sm" onClick={() => remove(e.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}
