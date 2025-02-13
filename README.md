# Prices e-commerce BCNC Group

## Overview
The following repo contains API REST Prices e-commerce of BCNC Group

## Architecture

The application's architecture is **Hexagonal architecture**.
The following articles will explain the purpose and benefits of it, and how to configure it:
1. [Baeladung Hexagonal architecture](https://www.baeldung.com/hexagonal-architecture-ddd-spring)
2. [Medium Hands-on Hexagonal architecture](https://medium.com/javarevisited/hands-on-hexagonal-architecture-with-spring-boot-ca61f88bed8b)

This application has layers: application, domain & infrastructure.

## Design Patterns, Clean code & SOLID Principles  

The application has been coded following best practices in code design and object-oriented programming, clean code, and SOLID principles. It also incorporates several design patterns, such as DTO, DAO, Repository, Builder, Singleton, and others.

## Requirements

1. Download & setup GIT for your OS: [GIT Download](https://git-scm.com/)
2. Download & setup Docker: [Docker Download](https://www.docker.com/)
3. Download Maven dependency manager: [Maven Download](https://maven.apache.org/download.cgi)

## Installation and Getting Started
The following repo contains examples for OpenFin's Java adapter.

1. Clone this repository

```shell
	git clone https://github.com/juliozarate5/bcncgroup.git
```

2. Enter the application directory

```shell
	cd ./bcncgroup
```

3. Clean & Build project.

```shell
	mvn clean install
```

4. Deployment on Docker :rocket:
```shell
	docker compose up -d
```

5. Unit tests:
```shell
	mvn test
```
You can detail coverage report in \{LAYER}\target\site and open index.html on browser; JaCoCo plugin is used for it.

### Note (Optional): 
You can configure properties how: port & others, in: \infraestructure\src\main\resources\application.yml

## Source Code Review

Source code for the example is located in:

\src\main\java\com\bcncgroup\application\
\src\main\java\com\bcncgroup\infrastructure\
\src\main\java\com\bcncgroup\domain\

1. Run Application from Main class in \src\main\java\com\bcncgroup\infrastructure\:

```java
@SpringBootApplication
public class InfrastructureApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfrastructureApplication.class, args);
    }

}

```
This code just creates an instance of DesktopConnection and it does not try to connect to runtime.

2. Controller in \src\main\java\com\bcncgroup\infrastructure\ contains the method for
retrieve prices:

```java
@GetMapping
public ResponseEntity<List<PriceResponseDTO>> getPrices(
    @RequestParam("application_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime appDate,
    @RequestParam("product_id") Long productId,
    @RequestParam("brand_id") Long brandId
        ) {
        log.info("Executing getPrices from Controller");
        return ResponseEntity.ok(
        priceService.getPrices(appDate, productId, brandId)
        );
}
```

3. In \src\main\java\com\bcncgroup\infrastructure\ is Adapter Repository:

 ```java
@Override
public List<Price> findPricesByParams(final LocalDateTime appDate,
        final Long productId,
        final Long brandId
        ) {
final List<PriceEntity> priceEntityList =
        priceJpaRepository.findByAppDateAndProductIdAndBrandId(appDate, productId, brandId);
        return priceMapper.toPriceList(priceEntityList);
        }
```
This method is Implementing of Domain repository for find prices with params.

4.  In infrastructure layer is Entities how PriceEntity:

```java
@Entity
@Table(name = "prices")
@FieldDefaults(level = PRIVATE)
@Getter
@Setter
public class PriceEntity implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    BrandEntity brand;

    @Column(name = "start_date", nullable = false)
    LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    LocalDateTime endDate;

    @Column(name = "price_list", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    PriceListEnum priceList;

    @ManyToOne
    @JoinColumn(name = "product_id")
    ProductEntity product;

    @Column(nullable = false)
    Integer priority;

    @Column(name = "price", nullable = false)
    BigDecimal total;

    @Column(name = "curr", nullable = false)
    @Enumerated(EnumType.STRING)
    CurrencyEnum currency;

    @Column(name = "created_at", updatable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        if(createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}

```

5. It's use Mapstruct for Mapping classes:

```java
@Mapper
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    Price toPrice(PriceEntity priceEntity);

    List<Price> toPriceList(List<PriceEntity> priceEntityList);
}

```

6. In infrastructure\config, is configurations: beans, swagger & interceptor for exceptions:

```java
@Configuration
public class PriceConfiguration {

    @Bean
    PriceService priceService(final PriceRepository priceRepository) {
        return new DomainPriceServiceImpl(priceRepository);
    }


}
```
Communicates with application layer

7. In Application Layer is the PriceService

```java
@Transactional(readOnly = true)
@Override
public List<PriceResponseDTO> getPrices(
final LocalDateTime appDate, final Long productId, final Long brandId) {
        try {

// TODO: VALIDAR & get BRAND
final Product product = this.getProduct(productId);
final List<Price> prices = priceRepository.findPricesByParams(appDate, product.getId(), brandId);
        Price price = prices.stream()
        .max(Comparator.comparingInt(Price::getPriority))
        .orElseThrow(() -> new BadRequestException("No valid price found"));

        return priceMapper.toPriceResponseDtoList(Collections.singletonList(price));

        } catch (InternalServerErrorException e) {
        throw new InternalServerErrorException(
        ErrorDTO.builder()
        .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
        .message("Error General")
        .date(LocalDateTime.now())
        .build()
        );
        }
        }
```

6. ..\domain layer contains: DTOs, enums, exceptions classes, models & Ports for infraestructura layer connects to the model

```java
/**
 * Port: for infraestructura layer connects to the model
 */
public interface PriceRepository {

    // Others methods...

    List<Price> findPricesByParams(
            LocalDateTime appDate, Long productId, Long brandId
    );
}
```

This method contains the bussines logic for get prices.

## Operations

Test API on Swagger UI: http://localhost:{port}/api/v1/swagger-ui.html

Note: default port in this app is 8084. You can configure in application.yml & relaunch app.

### Retrieve a price by Application Date, Product ID & Brand ID & priority

`GET` `/prices?application_date=2020-06-14T10:00:00&product_id=35455&brand_id=1`

This feature retrieves the price data from the database
and access the Pricing Service to enrich
the Prices information to be presented

### Response 200 OK

```json
[
  {
    "product_id":35455,
    "brand_id":1,"start_date":"2020-06-14T00:00:00",
    "end_date":"2020-12-31T23:59:59",
    "price":35.50,"price_list":1
  }
]
```

### Response 400 Bad Request

```json
{
  "error": "string",
  "message": "string",
  "status": 400,
  "date": "2025-01-21T01:06:26.761Z"
}
```

### Response 404 Not Found

```json
{
  "error": "string",
  "message": "string",
  "status": 404,
  "date": "2025-01-21T01:06:26.761Z"
}
```

### Response 500 Internal Error Server

```json
{
  "error": "string",
  "message": "string",
  "status": 500,
  "date": "2025-01-21T01:06:26.761Z"
}
```

## Use Project

1. Download & setup IntelliJ Community Edition(Recommended) : [IntelliJ Download](https://www.jetbrains.com/es-es/idea/download/?section=windows)
2. Open project: File -> Open
3. Run from: InfrastructureApplication main class or execute command: 
```shell
	mvn -pl infrastructure spring-boot:run
```
4. For unit testing, execute command: 
```shell
	mvn test
```

## More Info
More information and API documentation can be found at https://bcncgroup.com

## Disclaimers
* This is a starter example and intended to demonstrate to app providers a sample of how to approach an implementation. There are potentially other ways to approach it and alternatives could be considered.
* Its possible that the repo is not actively maintained.

## License
BCNC Group

https://bcncgroup.com/contact/

## Support
Please enter an issue in the repo for any questions or problems.
<br> Alternatively, please contact us at juliomzarate5@gmail.com