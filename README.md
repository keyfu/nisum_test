# NISUM_TEST

# Run project
1 - Install Spring Tool Suite 4

2 - Open the project, File -> Open Projects from File System ..

3 - Locate file src / main / java / -> com.example -> NisumTestApplication.java

4 - Right click on this file and Run As -> Spring Boot App

# Testing API

This project sould be running over port 8081, so, you should be open Postman and execute the following urls:

### Method GET, Url localhost:8081/api/persona

Returns a list of people

### Method GET, Url localhost:8081/api/persona/{id}

Returns a person by your id, if the person is not found, error will return

### Method POST, Url localhost:8081/api/persona
#### Body
```
{
    "name": "Juan",
    "last_name": "Perez Perez",
    "address": "Av Americo Temporal",
    "simple_phone_number": "12323"
    "hair_colour": "red"
}
```

This Insert a person in DB

### Method PUT, Url localhost:8081/api/persona/{id}
#### Body
```
{
    "name": "Leandro",
    "last_name": "Hernandez Mira",
    "address": "Av Americo Temporal",
    "simple_phone_number": "12323"
    "hair_colour": "red"
}
```

Update a person’s data, if the person is not found, error will return

### Method DELETE, Url localhost:8081/api/persona/{id}

Delete a person by your id, if the person is not found, error will return 