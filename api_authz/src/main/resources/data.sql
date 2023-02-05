INSERT INTO authorities (name, endpoint) values ('User_Write', 'POST:/api/user/');
INSERT INTO authorities (name, endpoint) values ('User_Read', 'GET:/api/user/');
INSERT INTO authorities (name, endpoint) values ('UserById_Read', 'GET:/api/user/{id}/');
INSERT INTO authorities (name, endpoint) values ('User_Delete', 'DELETE:/api/user/{id}/');
INSERT INTO authorities (name, endpoint) values ('User_Update', 'PUT:/api/user/{id}/');
INSERT INTO authorities (name, endpoint) values ('User_PartialUpdate', 'PATCH:/api/user/{id}/');

INSERT INTO authorities (name, endpoint) values ('Role_Write', 'POST:/api/role/');
INSERT INTO authorities (name, endpoint) values ('Role_Read', 'GET:/api/role/');
INSERT INTO authorities (name, endpoint) values ('RoleById_Read', 'GET:/api/role/{id}/');
INSERT INTO authorities (name, endpoint) values ('Role_Delete', 'DELETE:/api/role/{id}/');
INSERT INTO authorities (name, endpoint) values ('Role_Update', 'PUT:/api/role/{id}/');
INSERT INTO authorities (name, endpoint) values ('Role_PartialUpdate', 'PATCH:/api/role/');

INSERT INTO authorities (name, endpoint) values ('Authority_Write', 'POST:/api/authority/');
INSERT INTO authorities (name, endpoint) values ('Authority_Read', 'GET:/api/authority/');
INSERT INTO authorities (name, endpoint) values ('AuthorityById_Read', 'GET:/api/authority/{id}/');
INSERT INTO authorities (name, endpoint) values ('Authority_Delete', 'DELETE:/api/authority/{id}/');
INSERT INTO authorities (name, endpoint) values ('Authority_Update', 'PUT:/api/authority/{id}/');
INSERT INTO authorities (name, endpoint) values ('Authority_PartialUpdate', 'PATCH:/api/authority/{id}/');
INSERT INTO authorities (name, endpoint) values ('AuthorityByUser_Read', 'GET:/api/authority/byuser/{id}/');

INSERT INTO authorities (name, endpoint) values ('Ciudad_Write', 'POST:/api/ciudad/');
INSERT INTO authorities (name, endpoint) values ('Ciudad_Read', 'GET:/api/ciudad/');
INSERT INTO authorities (name, endpoint) values ('CiudadById_Read', 'GET:/api/ciudad/{id}/');
INSERT INTO authorities (name, endpoint) values ('Ciudad_Delete', 'DELETE:/api/ciudad/{id}/');
INSERT INTO authorities (name, endpoint) values ('Ciudad_Update', 'PUT:/api/ciudad/{id}/');
INSERT INTO authorities (name, endpoint) values ('Ciudad_PartialUpdate', 'PATCH:/api/ciudad/{id}/');

INSERT INTO authorities (name,endpoint) values ('genero_Write','POST:/api/genero/');
INSERT INTO authorities (name,endpoint) values ('genero_Read','GET:/api/genero/');
INSERT INTO authorities (name,endpoint) values ('generoById_Read','GET:/api/genero/{id}/');
INSERT INTO authorities (name,endpoint) values ('genero_Delete','DELETE:/api/genero/{id}/');
INSERT INTO authorities (name,endpoint) values ('genero_Update','PUT:/api/genero/{id}/');
INSERT INTO authorities (name,endpoint) values ('genero_PartialUpdate','PATCH:/api/genero/{id}/');

INSERT INTO authorities (name,endpoint) values ('ocupacion_Write','POST:/api/ocupacion/');
INSERT INTO authorities (name,endpoint) values ('ocupacion_Read','GET:/api/ocupacion/');
INSERT INTO authorities (name,endpoint) values ('ocupacionById_Read','GET:/api/ocupacion/{id}/');
INSERT INTO authorities (name,endpoint) values ('ocupacion_Delete','DELETE:/api/ocupacion/{id}/');
INSERT INTO authorities (name,endpoint) values ('ocupacion_Update','PUT:/api/ocupacion/{id}/');
INSERT INTO authorities (name,endpoint) values ('ocupacion_PartialUpdate','PATCH:/api/ocupacion/{id}/');

INSERT INTO authorities (name,endpoint) values ('tiposangre_Write','POST:/api/tiposangre/');
INSERT INTO authorities (name,endpoint) values ('tiposangre_Read','GET:/api/tiposangre/');
INSERT INTO authorities (name,endpoint) values ('tiposangreById_Read','GET:/api/tiposangre/{id}/');
INSERT INTO authorities (name,endpoint) values ('tiposangre_Delete','DELETE:/api/tiposangre/{id}/');
INSERT INTO authorities (name,endpoint) values ('tiposangre_Update','PUT:/api/tiposangre/{id}/');
INSERT INTO authorities (name,endpoint) values ('tiposangre_PartialUpdate','PATCH:/api/tiposangre/{id}/');

INSERT INTO authorities (name,endpoint) values ('FichaPaciente_Write','POST:/api/ficha/');
INSERT INTO authorities (name,endpoint) values ('FichaPaciente_Read','GET:/api/ficha/');
INSERT INTO authorities (name,endpoint) values ('FichaPacienteById_Read','GET:/api/ficha/{id}/');
INSERT INTO authorities (name,endpoint) values ('FichaPaciente_Delete','DELETE:/api/ficha/{id}/');
INSERT INTO authorities (name,endpoint) values ('FichaPaciente_Update','PUT:/api/ficha/{id}/');
INSERT INTO authorities (name,endpoint) values ('FichaPaciente_PartialUpdate','PATCH:/api/ficha/{id}/');
INSERT INTO authorities (name,endpoint) values ('FichaPacientePdf_Read','GET:/api/atencion/pdf/{id}/');

INSERT INTO authorities (name,endpoint) values ('Paciente_Write','POST:/api/paciente/');
INSERT INTO authorities (name,endpoint) values ('Paciente_Read','GET:/api/paciente/');
INSERT INTO authorities (name,endpoint) values ('PacienteById_Read','GET:/api/paciente/{id}/');
INSERT INTO authorities (name,endpoint) values ('Paciente_Delete','DELETE:/api/paciente/{id}/');
INSERT INTO authorities (name,endpoint) values ('Paciente_Update','PUT:/api/paciente/{id}/');
INSERT INTO authorities (name,endpoint) values ('Paciente_PartialUpdate','PATCH:/api/paciente/{id}/');

INSERT INTO authorities (name,endpoint) values ('especialista_Write','POST:/api/especialista/');
INSERT INTO authorities (name,endpoint) values ('especialista_Read','GET:/api/especialista/');
INSERT INTO authorities (name,endpoint) values ('especialistaById_Read','GET:/api/especialista/{id}/');
INSERT INTO authorities (name,endpoint) values ('especialista_Delete','DELETE:/api/especialista/{id}/');
INSERT INTO authorities (name,endpoint) values ('especialista_Update','PUT:/api/especialista/{id}/');
INSERT INTO authorities (name,endpoint) values ('especialista_PartialUpdate','PATCH:/api/especialista/{id}/');

INSERT INTO authorities (name,endpoint) values ('Horario_Write', 'POST:/api/horario/');
INSERT INTO authorities (name,endpoint) values ('Horario_Read','GET:/api/horario/');
INSERT INTO authorities (name,endpoint) values ('HorarioById_Read','GET:/api/horario/{id}/');
INSERT INTO authorities (name,endpoint) values ('Horario_Delete','DELETE:/api/horario/{id}/');
INSERT INTO authorities (name,endpoint) values ('Horario_Update','PUT:/api/horario/{id}/');
INSERT INTO authorities (name,endpoint) values ('Horario_PartialUpdate','PATCH:/api/horario/{id}/');

INSERT INTO authorities (name, endpoint) values ('Agendamiento_Write', 'POST:/api/agendamiento/');
INSERT INTO authorities (name, endpoint) values ('Agendamiento_Read', 'GET:/api/agendamiento/');
INSERT INTO authorities (name, endpoint) values ('AgendamientoById_Read', 'GET:/api/agendamiento/{id}/');
INSERT INTO authorities (name, endpoint) values ('Agendamiento_Delete', 'DELETE:/api/agendamiento/{id}/');
INSERT INTO authorities (name, endpoint) values ('Agendamiento_Update', 'PUT:/api/agendamiento/{id}/');
INSERT INTO authorities (name, endpoint) values ('Agendamiento_PartialUpdate', 'PATCH:/api/agendamiento/{id}/');

INSERT INTO authorities (name, endpoint) values ('Estado_Write', 'POST:/api/estado/');
INSERT INTO authorities (name, endpoint) values ('Estado_Read', 'GET:/api/estado/');
INSERT INTO authorities (name, endpoint) values ('EstadoById_Read', 'GET:/api/estado/{id}/');
INSERT INTO authorities (name, endpoint) values ('Estado_Delete', 'DELETE:/api/estado/{id}/');
INSERT INTO authorities (name, endpoint) values ('Estado_Update', 'PUT:/api/estado/{id}/');
INSERT INTO authorities (name, endpoint) values ('Estado_PartialUpdate', 'PATCH:/api/estado/{id}/');

INSERT INTO authorities (name,endpoint) values ('citasagendadas_Write','POST:/api/citasagendadas/');
INSERT INTO authorities (name,endpoint) values ('citasagendadas_Read','GET:/api/citasagendadas/');
INSERT INTO authorities (name,endpoint) values ('citasagendadasById_Read','GET:/api/citasagendadas/{id}/');
INSERT INTO authorities (name,endpoint) values ('citasagendadas_Delete','DELETE:/api/citasagendadas/{id}/');
INSERT INTO authorities (name,endpoint) values ('citasagendadas_Update','PUT:/api/citasagendadas/{id}/');
INSERT INTO authorities (name,endpoint) values ('citasagendadas_PartialUpdate','PATCH:/api/citasagendadas/{id}/');


INSERT INTO authorities (name,endpoint) values ('AtencionMedica_Write','POST:/api/atencion/');
INSERT INTO authorities (name,endpoint) values ('AtencionMedica_Read','GET:/api/atencion/');
INSERT INTO authorities (name,endpoint) values ('AtencionMedicaById_Read','GET:/api/atencion/{id}/');
INSERT INTO authorities (name,endpoint) values ('AtencionMedica_Delete','DELETE:/api/atencion/{id}/');
INSERT INTO authorities (name,endpoint) values ('AtencionMedica_Update','PUT:/api/atencion/{id}/');
INSERT INTO authorities (name,endpoint) values ('AtencionMedica_PartialUpdate','PATCH:/api/atencion/{id}/');
INSERT INTO authorities (name,endpoint) values ('AtencionMedicaPdf_Read','GET:/api/atencion/pdf/{id}/');

INSERT INTO authorities (name, endpoint) values ('Sintoma_Write', 'POST:/api/sintoma/');
INSERT INTO authorities (name, endpoint) values ('Sintoma_Read', 'GET:/api/sintoma/');
INSERT INTO authorities (name, endpoint) values ('SintomaById_Read', 'GET:/api/sintoma/{id}/');
INSERT INTO authorities (name, endpoint) values ('Sintoma_Delete', 'DELETE:/api/sintoma/{id}/');
INSERT INTO authorities (name, endpoint) values ('Sintoma_Update', 'PUT:/api/sintoma/{id}/');
INSERT INTO authorities (name, endpoint) values ('Sintoma_PartialUpdate', 'PATCH:/api/sintoma/{id}/');

INSERT INTO authorities (name, endpoint) values ('Tratamiento_Write', 'POST:/api/tratamiento/');
INSERT INTO authorities (name, endpoint) values ('Tratamiento_Read', 'GET:/api/tratamiento/');
INSERT INTO authorities (name, endpoint) values ('TratamientoById_Read', 'GET:/api/tratamiento/{id}/');
INSERT INTO authorities (name, endpoint) values ('Tratamiento_Delete', 'DELETE:/api/tratamiento/{id}/');
INSERT INTO authorities (name, endpoint) values ('Tratamiento_Update', 'PUT:/api/tratamiento/{id}/');
INSERT INTO authorities (name, endpoint) values ('Tratamiento_PartialUpdate', 'PATCH:/api/tratamiento/{id}/');

INSERT INTO authorities (name,endpoint) values ('Diagnostico_Write','POST:/api/diagnostico/');
INSERT INTO authorities (name,endpoint) values ('Diagnostico_Read','GET:/api/diagnostico/');
INSERT INTO authorities (name,endpoint) values ('DiagnosticoById_Read','GET:/api/diagnostico/{id}/');
INSERT INTO authorities (name,endpoint) values ('Diagnostico_Delete','DELETE:/api/diagnostico/{id}/');
INSERT INTO authorities (name,endpoint) values ('Diagnostico_Update','PUT:/api/diagnostico/{id}/');
INSERT INTO authorities (name,endpoint) values ('Diagnostico_PartialUpdate','PATCH:/api/diagnostico/{id}/');

INSERT INTO roles (name) values ('ROLE_ADMIN');
INSERT INTO roles (name) values ('ROLE_ESPECIALISTA');
INSERT INTO roles (name) values ('ROLE_PACIENTE');


INSERT INTO roles_authorities (role_id, authority_id) (select (SELECT id FROM roles where name = 'ROLE_ADMIN')  AS role_id, e.id from authorities e );

INSERT INTO users (name, username, password, looked, expired, enabled) VALUES ('Admin', 'admin', '$2a$10$TwROhi2MZsOTt8igkE7Yyec0WfjK7NlgdX9apOu0b6cY4SxzHLvCq', false, false, true);

INSERT INTO users_roles (user_id, role_id) VALUES ((SELECT id FROM users where username = 'admin'), (SELECT id FROM roles where name = 'ROLE_ADMIN'));