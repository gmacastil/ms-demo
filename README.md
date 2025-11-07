# compilar
mvn clean package -DskipTests

# construir imagen
docker build . -t ms-demo:1

# publicar la imagen
docker tag ms-demo:2 mauron/ms-demo:2
docker push mauron/ms-demo:2


# run container
docker run --name ms-demo-2 -d -p 9090:8080 -e APP_FACTOR=1001 -e APP_MONTO=250000 ms-demo:2
