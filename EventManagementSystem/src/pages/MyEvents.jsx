import React, { useEffect, useState } from "react";
import API from "../services/api";

export default function MyEvents() {
  const [regs, setRegs] = useState([]);
  const participantId = prompt("Enter your Participant ID"); // demo only

  useEffect(() => {
    API.get(`/registrations/me?participantId=${participantId}`)
      .then(r => setRegs(r.data))
      .catch(() => {});
  }, [participantId]);

  return (
    <div className="container mt-3">
      <h3>My Registered Events</h3>
      <ul className="list-group">
        {regs.map(r => (
          <li key={r.id} className="list-group-item">
            {r.event.title} — {r.event.date}
          </li>
        ))}
      </ul>
    </div>
  );
}
