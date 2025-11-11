FROM ubuntu:22.04

# Evita perguntas interativas
ENV DEBIAN_FRONTEND=noninteractive

# Instala dependências e MySQL
RUN apt-get update && \
    apt-get install -y mysql-server net-tools && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Configura MySQL para aceitar conexões externas
RUN sed -i 's/^bind-address.*/bind-address = 0.0.0.0/' /etc/mysql/mysql.conf.d/mysqld.cnf

# Define variáveis
ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=dados_db

# Copia script de inicialização
COPY init.sql /init.sql

# Inicializa MySQL no primeiro start, cria root com acesso externo, executa init.sql
CMD ["bash", "-c", "\
    service mysql start && \
    mysql -uroot -p${MYSQL_ROOT_PASSWORD} -e \"ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY '${MYSQL_ROOT_PASSWORD}'; GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION; FLUSH PRIVILEGES;\" && \
    mysql -uroot -p${MYSQL_ROOT_PASSWORD} < /init.sql && \
    tail -f /dev/null \
"]
