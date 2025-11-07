import http from 'k6/http';
import { sleep, check } from 'k6';

export const options = {
  stages: [
    { duration: '1s', target: 10 }, // Fase de ramp-up: sube a 10 usuarios virtuales
    { duration: '1s', target: 10 },  // Carga sostenida
    { duration: '1s', target: 0 },  // Fase de ramp-down
  ],
  thresholds: {
    http_req_duration: ['p(95)<500'], // 95% de las solicitudes deben responder en menos de 500ms
  },
};

export default function () {
  const url = 'http://localhost:8080/factura';
  const res = http.get(url);

  check(res, {
    'status es 200': (r) => r.status === 200,
    'respuesta no vacía': (r) => r.body && r.body.length > 0,
  });

  sleep(1);
}
