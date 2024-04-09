# DineStream

Future description of the project


## Message Format in RabbitMQ

Describe the format of messages processed by the application in RabbitMQ. Provide guidelines on the structure and data within the messages.

Example message format:
```json
{
  "id":"0a2140ea-432f-4c9d-bd45-1c21cb8ef5f6",
  "orderDateTime":"2024-04-09 23:00:08.247304",
  "notes":"Bez cebuli w burgerze.",
  "meals":[
    {
      "mealId":"c398f5e1-3b11-4c12-b35d-281ad5eaa06e",
      "meal":"Falafel",
      "count":3
    },
    {
      "mealId":"e89327cb-d28c-4760-85d0-290d2ac1b012",
      "meal":"Musaka",
      "count":3
    },
    {
      "mealId":"a798527c-b8b1-4b08-9ff1-4d6ac964ecf3",
      "meal":"Szakszuka",
      "count":3
    },
    {
      "mealId":"e72d8b73-2181-4605-92f7-5a6f4d2b8dbb",
      "meal":"Pad Thai",
      "count":2
    }
  ]
}
```

## Running the application


# Redis
Login to redis-cli
```shell
docker exec -it <container_id> redis-cli
```

# PostgreSQL
Login to psql
```shell
docker exec -it <container_id> psql -U postgres
```