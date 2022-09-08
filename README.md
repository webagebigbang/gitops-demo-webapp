# Building the Docker Image

## Build the Application

Run:

```
./mvnw clean package
```

This will create the application file ``target/gitops-demo-webapp.jar``.

## Create the Docker Image

Log into Docker Hub.

```
docker login
```

Build the image. Here replace ``<DOCKER_USER>`` with your own Docker user ID.

```
docker build -t <DOCKER_USER>/gitops-demo-webapp .
```

Push the image.

```
docker push <DOCKER_USER>/gitops-demo-webapp
```

## Test the Image

Run the image:

```
docker run --rm -p8080:8080 <DOCKER_USER>/gitops-demo-webapp
```

Send a request.

```
curl http://localhost:8080/hello
```

You should see.

```
{"requestCount":1,"greeting":"Hello!"}
```