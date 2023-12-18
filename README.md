# Veteriner Yönetim Sistemi - Spring Boot Projesi

Bu proje, bir veteriner kliniğinin işlerini yönetebilmek için geliştirilen bir Spring Boot uygulamasıdır.

## Proje Açıklaması

Proje, veteriner çalışanlarının sisteme doktorları, müşterileri, hayvanları, aşıları ve randevuları kaydedebilmelerini, güncelleyebilmelerini, görüntüleyebilmelerini ve silebilmelerini sağlar.

## Projede Kullanılan Entityler

- Animal
- Customer
- Vaccine
- Doctor
- AvailableDate
- Appointment

## API Temel Özellikleri

- Hayvan ve Sahip Yönetimi
- Aşı Yönetimi
- Randevu Yönetimi
- Veteriner Doktor Yönetimi
- Doktorun Müsait Günleri Yönetimi

## Önemli Notlar

- Proje katmanlı mimari yapısına sahiptir.
- IoC ve DI için constructor injection kullanılmıştır.
- Gerekli anotasyonlar uygun şekilde yazılmıştır.
- Tüm işlemlerde var olan verinin kontrolü yapılmıştır.
- HTTP durum kodları anlamlı şekilde kullanılmıştır.
- Hatalar API kullanıcılarına anlamlı çıktılar verir ve yönetilir.
- Request ve Response DTO'ları kullanılabilir.
- API endpointlerini tanımlayan bir doküman hazırlanmıştır. [endpoints.md]

## Teknolojiler

- Spring Boot
- Spring Data JPA
- PostgreSQL veya MySQL (veri tabanı olarak kullanılabilir)
