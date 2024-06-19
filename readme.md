# Projekat i projektna dokumentacija za predmet IT355.

## Specifikacije

<p>Projektni zadatak je izrađen korišćenjem Spring okvira verzije 3 u veriziji 17 Java jezika. </p>
<p>Najlakši oblik pokretanja projekta je preko Intellij IDEA editora sa skinutom verzijom 22 open source java SDK-a.</p>

Spisak zavisnosti: 
 - `spring-boot-starter-web`
 - `spring-boot-starter-data-jpa`
 - `h2`
 - `lombok`
 - `spring-security-web`
 - `spring-security-config`
 - `spring-security-core`
 - `spring-boot-devtools`
 - `spring-boot-starter-test`
 - `junit`
 - `spring-boot-starter-thymeleaf`

<p>Svi detalji zavisnosti se mogu naći u pom fajlu [pom.xml](pom.xml)</p>

<p>Aplikacija predstavlja implementaciju MVC šablona preko Srping okvira sa korisničkim interfejsom implementiranim u Thymeleaf-u sa integracijom Bootstrap-a. Baza podataka predstavlja H2 in-memory baza a konektor baze je obavljen preko JPA konektora.</p>

<p>Projekat realizuje web shop mvc program. Cilj je omogućiti naručivanje proizvoda preko aplikacije.
Druga sfera projekta predstavlja RESTful api kojim se mogu vršiti modifikacije nad podacima</p>

Omogućeno je vršiti sledeće funckionalnosti preko korisničkog interfejsa:
 - Pregled proizvoda
 - Dodavanje u korpu
 - Kreiranje računa

<p>Ostale funkcionalnosti se vrše preko CRUD rest API poziva.</p>

## Dizajn sistema

<p>Baza podataka je h2 in-memory baza koja koristi ugrađen JPA konektor za kreiranje entiteta pomoću code first pristupa. Pri pokretanju aplikacije baza će pogledati definisane entite i kreirati table na osnovu istih.</p>

Entiteti projekta su:
- Customer
- Inventory
- Item
- Receipt
- Order

<p>Pored samih entiteta koje kreira JPA, JPA omogućuje kreiranje JPA repositorija koje realizuju Repository šablon omogućujući lako kreairanje CRUD operacija.</p>

R

![Repositorijumi i njihova implementacija se mogu videti na slici.](src%2Fmain%2Fresources%2Fdoc-images%2Frepos.png)


## Slučajevi korišćenja

## Interfejs aplikacije

## Dokumentacija REST servisa

## Primeri poziva REST servisa

## Testiranje