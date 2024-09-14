#!/bin/bash

IP=$(hostname -I | awk '{print $1}')
echo "Monitoreo de luz: http://$IP:8080"

gunicorn -b 0.0.0.0:8080 app:app
