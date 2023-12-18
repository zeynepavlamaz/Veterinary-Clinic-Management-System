## Animals
| Endpoint                | Method | Description          |
|-------------------------|--------|----------------------|
| `/animals/get`          | GET    | List all animals     |
| `/animals/getById/{id}` | GET    | Get animal by Id     |
| `/animals/add`          | POST   | Add new animal       |
| `/animals/update`       | PUT    | Update animal record |
| `/animals/delete/{id}`  | DELETE | Delete animal record |

## Animal Vaccines
| Endpoint                         | Method | Description                             |
|----------------------------------|--------|-----------------------------------------|
| `/animalVaccines/get`            | GET    | List all animal vaccines records        |
| `/animalVaccines/getById/{id}`   | GET    | Get animal vaccine records by Id        |
| `/getAnimalVaccines/{id}`        | GET    | Get all vaccine records of animal       |
| `/getAnimalVaccines/getBetween`  | GET    | Get all vaccines between dates enquired |
| `/getAnimalVaccines/add`         | POST   | Add new animal vaccine record           |
| `/getAnimalVaccines/update`      | PUT    | Update animal vaccine record            |
| `/getAnimalVaccines/delete/{id}` | DELETE | Delete animal vaccine record            |

## Customer
| Endpoint                | Method | Description            |
|-------------------------|--------|------------------------|
| `/customers/get`        | GET    | List all customers     |
| `/customers/getById/{id}` | GET    | Get customer by Id     |
| `/customers/getByName/{name}` | GET    | Get customer by name   |
| `/customers/getPets/{id}` | GET    | Get pets of customer   |
| `/customersadd`          | POST   | Add new customer       |
| `/customers/update`       | PUT    | Update customer record |
| `/customers/delete/{id}`  | DELETE | Delete customer record |

## Vet
| Endpoint                | Method | Description       |
|-------------------------|--------|-------------------|
| `/vets/get`             | GET    | List all vets     |
| `/vets/getById/{id}` | GET    | Get vet by Id     |
| `/vets/add`          | POST   | Add new vet       |
| `/vets/update`       | PUT    | Update vet record |
| `/vets/delete/{id}`  | DELETE | Delete vet record |

## Vet Available Days
| Endpoint                | Method | Description                 |
|-------------------------|--------|-----------------------------|
| `/vetAvailability/get`             | GET    | List all vet available days |
| `/vetAvailability/getById/{id}` | GET    | Get vet available day by Id              |
| `/vetAvailability/add`          | POST   | Add new vet available day                |
| `/vetAvailability/update`       | PUT    | Update vet available day record           |
| `/vetAvailability/delete/{id}`  | DELETE | Delete vet available day record           |

## Vaccines
| Endpoint                | Method | Description                    |
|-------------------------|--------|--------------------------------|
| `/vaccines/get`             | GET    | List all vaccines              |
| `/vaccines/getById/{id}` | GET    | Get vaccine by Id              |
| `/vaccines/add`          | POST   | Add new vaccine    |
| `/vaccines/update`       | PUT    | Update vaccine record |
| `/vaccines/delete/{id}`  | DELETE | Delete vaccine record |
## Appointment
| Endpoint                             | Method | Description                                           |
|--------------------------------------|--------|-------------------------------------------------------|
| `/appointments/get`                  | GET    | List all appointments                                 |
| `/appointments/getById/{id}`         | GET    | Get appointment by Id                                 |
| `/appointments/getByAnimalIdBetween` | GET    | Get all appointments by animal between dates enquired |
| `/appointments/getByDoctorIdBetween` | GET    | Get all appointments by doctor between dates enquired |
| `/appointments/add"`                 | POST   | Add new appointment                                   |
| `/appointments/update"`              | PUT    | Update appointment record                             |
| `/appointments/delete/{id}"`         | DELETE | Delete appointment record                             |









