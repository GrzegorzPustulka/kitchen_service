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