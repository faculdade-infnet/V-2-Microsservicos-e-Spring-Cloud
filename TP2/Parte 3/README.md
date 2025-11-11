WSL 
1. Acessar endereço 
```shell
cd "/mnt/f/Engenharia de Software/_Materias/V-2-Microsservicos-e-Spring-Cloud/TP2/Parte 3"
```
2. Rodar DockerFile
```bash
docker build -t samuelhermany1012/mysql-custom:1.0 .
```
3. Verificar se a imagem foi criada corretametne
```bash
docker images
```
4. Subir o container
```bash
docker run -d \
  -p 3307:3306 \
  --name mysql-custom \
  samuelhermany1012/mysql-custom:1.0
```
5. Verificar se MySQL está rodando dentor do container
```bash
docker exec -it mysql-custom bash
```
- Dentro do Copntainer
```bash
ps aux | grep mysqld
```
6. Atualize o arquivo de configuração
```bash
sed -i 's/^bind-address.*/bind-address = 0.0.0.0/' /etc/mysql/mysql.conf.d/mysqld.cnf
```
- Verificar se funcionou
```bash
grep bind-address /etc/mysql/mysql.conf.d/mysqld.cnf
```
- Resposta esperada
```
bind-address = 0.0.0.0
mysqlx-bind-address = 127.0.0.1
```
- Reiniciar o MySQL
```bash
service mysql restart
```
7. Verificar se esta ouvindo todas as interfaces
```bash
netstat -tlnp | grep 3306
```
8. Testar a conexão
```bash
docker ps

mysql -h 127.0.0.1 -P 3307 -u root -p=
```
6.a Docker Hub - Login
```bash
docker login
```
6.b Docker Hub - Publicar 
```bash
docker push samuelhermany1012/mysql-custom:1.0
```