import { useEffect, useState } from 'react'
import './App.css'

function App() {
  const [rooms, setRooms] = useState([
    {
      id: 1,
      titulo: "Cabaña Alpina de Lujo",
      ubicacion: "Guatavita, Colombia",
      precio: 250000,
      puntuacion: 4.95,
      imagenUrl: "https://images.unsplash.com/photo-1518780664697-55e3ad937233?q=80&w=1000&auto=format&fit=crop"
    },
    {
      id: 2,
      titulo: "Apartamento Vista al Mar",
      ubicacion: "Santa Marta, Colombia",
      precio: 180000,
      puntuacion: 4.8,
      imagenUrl: "https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?q=80&w=1000&auto=format&fit=crop"
    },
    {
      id: 3,
      titulo: "Villa Moderna con Piscina",
      ubicacion: "Cartagena, Colombia",
      precio: 450000,
      puntuacion: 5.0,
      imagenUrl: "https://images.unsplash.com/photo-1512917774080-9991f1c4c750?q=80&w=1000&auto=format&fit=crop"
    }
  ])
  const [error, setError] = useState(null)

useEffect(() => {
    fetch('http://localhost:8080/api/rooms')
      .then(respuesta => {
        if (respuesta.ok) return respuesta.json();
        throw new Error('Servidor no disponible');
      })
      .then(datos => {
        if (datos && datos.length > 0) {
          setRooms(datos);
        }
      })
      .catch(() => {
        console.log("Conexión con Java fallida. Mostrando datos locales de Airbnb.");
      });
  }, []);
  return (
    <div className="contenedor-airbnb">
      {error && <p>{error}</p>}
      
      {}
      {rooms.length > 0 ? (
        rooms.map((cuarto) => (
          <div key={cuarto.id} className="card-alojamiento">
            <img src={cuarto.imagenUrl || "https://via.placeholder.com/300"} alt="Alojamiento" />
            <div className="info-card">
              <div className="fila-superior">
                <span>{cuarto.ubicacion || "Ubicación desconocida"}</span>
                <span>★ {cuarto.puntuacion || "Nuevo"}</span>
              </div>
              <span className="titulo-gris">{cuarto.titulo}</span>
              <div className="precio-noche">
                <b>${cuarto.precio}</b> noche
              </div>
            </div>
          </div>
        ))
      ) : (
        !error && <p>Cargando alojamientos...</p>
      )}
    </div>
  )
}

export default App