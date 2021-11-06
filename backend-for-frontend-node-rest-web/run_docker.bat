docker run --rm ^
    -p 8080:8080 ^
    -p 1100:1100 ^
    -p 5566:5566 ^
    -m 8192m ^
    --cpus 2 ^
    -e JAVA_XMX=6144m ^
    -it backend-for-frontend-node-rest-web:latest