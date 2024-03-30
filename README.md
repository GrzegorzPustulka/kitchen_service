# DineStream

Future description of the project


## Message Format in RabbitMQ

Describe the format of messages processed by the application in RabbitMQ. Provide guidelines on the structure and data within the messages.

Example message format:
```json
{
    "id": "1",
    "meals": [
        {
            "meal": "chicken",
            "count": 2
        },
        {
            "meal": "soup",
            "count": 1
        },
        {
            "meal": "vegetables",
            "count": 6
        },
        {
            "meal": "broth",
            "count": 1
        }
    ]
}
```