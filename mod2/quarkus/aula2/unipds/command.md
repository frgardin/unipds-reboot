


token=$(curl https://raw.githubusercontent.com/eldermoraes/unipds/main/jwt-token/quarkus.jwt.token -s)


docker run --name=jaeger -d -p 16686:16686 -p 4317:4317 -e COLLECTOR_OLTP_ENABLED=true jaegertracing/all-in-one:latest