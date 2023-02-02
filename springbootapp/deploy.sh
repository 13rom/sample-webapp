#!/bin/bash

CONTAINER_NAME="simple-webapp"
DOCKER_IMAGE="13rom/simple-webapp"

docker container stop ${CONTAINER_NAME}
docker container rm ${CONTAINER_NAME}
docker rmi ${DOCKER_IMAGE}

docker login -u "${DOCKER_USERNAME}" -p "${DOCKER_PASSWORD}"
docker pull ${DOCKER_IMAGE}:latest
docker logout

docker run -p80:8080 --name $CONTAINER_NAME -d ${DOCKER_IMAGE}:latest
