# Docker

## Primeiros passos

```
docker run -e MYSQL_ROOT_PASSWORD=toor -p 3306:3306 -d --name mysql mysql:5.7

docker run -p 8080:8080 -d --link mysql:mysql alura-forum:latest
```

## Usando volumes
```
docker run -e MYSQL_ROOT_PASSWORD=toor -p 3306:3306 -v /Users/newtonangelini/dev/caelum/curso-devops/infra/mysql/data:/var/lib/mysql -d --name mysql mysql:5.7
```