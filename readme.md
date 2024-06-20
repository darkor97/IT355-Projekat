# Projekat i projektna dokumentacija za predmet IT355.

## Spec

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

<p>Podešavanje aplikacije se odnosi na definisanje baze, podešavanje autorizacije i autentifikacije korišćenem spring security paketa. </p>
<p>Podešavanja baze se vide na slici ispod. Primećuje se skripa USERS koja kreira tabele neophodne za kreiranje korisnika za logovanje na aplikaciju.</p>

![db.png](src%2Fmain%2Fresources%2Fdoc-images%2Fdb.png)

<p>Podešavanja bezbednosti se vide na slici ispod, konkretno podešavanja pristupa metodama kontrolera na osnovu rola, kao i osnovna podešavanja za logovanje preko forme.</p>

![secfilter.png](src%2Fmain%2Fresources%2Fdoc-images%2Fsecfilter.png)

<p>Podešavanja rola.</p>

![roles.png](src%2Fmain%2Fresources%2Fdoc-images%2Froles.png)

<p>Baza podataka je h2 in-memory baza koja koristi ugrađen JPA konektor za kreiranje entiteta pomoću code first pristupa. Pri pokretanju aplikacije baza će pogledati definisane entite i kreirati table na osnovu istih.</p>

Entiteti projekta su i vide se na slici ispod:

![models.png](src%2Fmain%2Fresources%2Fdoc-images%2Fmodels.png)

<p>Pored samih entiteta koje kreira JPA, JPA omogućuje kreiranje JPA repositorija koje realizuju Repository šablon omogućujući lako kreairanje CRUD operacija.</p>

Repositorijumi i njihova implementacija se mogu videti na slici.

![repos.png](src%2Fmain%2Fresources%2Fdoc-images%2Frepos.png)

<p>Biznis logika je implementirana u servisnom sloju i može se videti na slici ispod.</p>

![services.png](src%2Fmain%2Fresources%2Fdoc-images%2Fservices.png)

<p>Sloj kontrolera poseduje dva tipa kontorlera REST kontrolere i jedan MVC controler pod nazivom index koji се vide na slici.</p>

![controllers.png](src%2Fmain%2Fresources%2Fdoc-images%2Fcontrollers.png)

<p>Interfejs templejti za mvc kontrolere su implementirani korišćenjem thymeleafa i prikazuju slučaj kreiranja računa</p>

![templates.png](src%2Fmain%2Fresources%2Fdoc-images%2Ftemplates.png)

<p>Poslednji sloj aplikacije predstavlja test sloj u kome za svaki servis i kontroler postoje jedinični testovi.</p>

![tests.png](src%2Fmain%2Fresources%2Fdoc-images%2Ftests.png)

## Slučajevi korišćenja
<p>Postoje dva fundamentalna slučaja korišćenja aplikacije, jedan je poziv API metoda a drugi predstavlja korišćenje korisničkog interfejsa.</p>
<p>Za demonstraciju rada aplikacije neophodno je korisiti oba, kako je interfejs zavistan od API-ja, API pozivima se kreira inventar, kao i proizvodi koji se omogućuju na prodaju. </p>

Neophodno je prvo kreirati proizvode za prodaju. Da bi mogli pozivati metode neophodno je preuzeti ADMIN kolačić za autorizaciju i proslediti ga u Postman. To je moguće nakon logovanja.

![login.png](src%2Fmain%2Fresources%2Fdoc-images%2Flogin.png)

Zatim se uzima cookie.

![cookie.png](src%2Fmain%2Fresources%2Fdoc-images%2Fcookie.png)

A onda dodaje u Postman zahtev.

![adding-cookie.png](src%2Fmain%2Fresources%2Fdoc-images%2Fadding-cookie.png)

Nakon toga pozivamo i kreiramo proizvode i njihova stanja u inventaru. 

![created-item.png](src%2Fmain%2Fresources%2Fdoc-images%2Fcreated-item.png)

![created-inventory.png](src%2Fmain%2Fresources%2Fdoc-images%2Fcreated-inventory.png)

Sada se na prikaz vide proizvodi.

![created-items.png](src%2Fmain%2Fresources%2Fdoc-images%2Fcreated-items.png)

Korisnik ih može dodati u korpu i dobiće prikaz obaveštenja za to.

![adding-items.png](src%2Fmain%2Fresources%2Fdoc-images%2Fadding-items.png)

U korpi se mogu videti proizvodi i njihova cena.

![to-buy.png](src%2Fmain%2Fresources%2Fdoc-images%2Fto-buy.png)

I na kraju izgenerisani račun.

![receipt.png](src%2Fmain%2Fresources%2Fdoc-images%2Freceipt.png)