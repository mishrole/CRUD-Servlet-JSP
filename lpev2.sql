# Nota: Mi root no tiene password, MySqlBDConexion tiene una cadena vacía como pwd

CREATE DATABASE lpev2;
USE lpev2;

CREATE TABLE TB_EMPLEADO(
cod_empleado int primary key not null auto_increment,
nom_empleado varchar(30) not null,
ape_empleado varchar(30) not null,
dni_empleado int(8) not null,
num_hijos int(1) not null
);