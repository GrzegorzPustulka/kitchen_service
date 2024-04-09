#!/bin/bash

check_and_kill() {
  local port=$1
  echo "Sprawdzanie, czy port $port jest zajęty..."
  pid=$(lsof -ti:$port)

  if [ ! -z "$pid" ]; then
    echo "Port $port jest zajęty przez proces $pid, zabijanie..."
    kill -9 $pid
  fi
}

check_and_kill 8080
check_and_kill 8000
check_and_kill 5137

echo "Zatrzymywanie usług Docker Compose..."
docker compose down > /dev/null 2>&1

echo "Uruchamianie usług Docker Compose..."
docker-compose up -d > /dev/null 2>&1

echo "Pauza na 5s..."
sleep 5

echo "Uruchamianie Service Kitchen..."
./mvnw spring-boot:run > /dev/null 2>&1 &

cd ../scripts/
source .venv/bin/activate
cd order_sender/
echo "Uruchamianie skryptu dodajace zamowienia na kolejke..."
python3 main.py > /dev/null 2>&1 &
python3 main.py > /dev/null 2>&1 &

cd ../order-status-api/
echo "Uruchamianie Restaurant Service..."
uvicorn main:app --reload > /dev/null 2>&1 &

cd ../../kitchen-frontend/
echo "Uruchamianie Kitchen Frontend..."
npm run dev > /dev/null 2>&1 &

cd ../scripts/order-wb-front
echo "Uruchamianie Restaurant Frontend..."
open ~/Projects/scripts/order-wb-front/index.html
open http://localhost:5173/
